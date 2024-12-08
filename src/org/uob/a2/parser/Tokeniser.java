package org.uob.a2.parser;

import java.util.ArrayList;

/**
 * The {@code Tokeniser} class is responsible for converting a string input into a list of tokens
 * that can be parsed into commands by the game.
 * 
 * <p>
 * The tokeniser identifies keywords, variables, and special symbols, assigning each a {@code TokenType}.
 * </p>
 */
public class Tokeniser {
    private ArrayList<Token> tokens;

    public Tokeniser(){
        tokens = new ArrayList<Token>();
    }
   
    public ArrayList<Token> getTokens(){
        return this.tokens;
    }

    public String sanitise(String s){
        return s.toLowerCase().trim();
    }

    public void tokenise(String s){
        tokens.clear();

        String[] words = s.split("\\s+");
        Token token;

        if(words.length == 0){
            token = new Token(TokenType.ERROR);
            tokens.add(token);
            return;
        }

        try{
            TokenType tokenType = TokenType.valueOf(words[0].toUpperCase());
            token = new Token(tokenType);
            tokens.add(token);
        }catch(IllegalArgumentException iae){
            token = new Token(TokenType.ERROR);
            tokens.add(token);
        }

        for(int i = 1; i < words.length; i++){
            if(words[i].equals("on") || words[i].equals("with")){
                token = new Token(TokenType.PREPOSITION, words[i]);
            }else{
                token = new Token(TokenType.VAR, words[i]);
            }
            tokens.add(token);
        }

        token = new Token(TokenType.EOL);
        tokens.add(token);
    }
}
