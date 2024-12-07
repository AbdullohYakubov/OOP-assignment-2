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

    public Tokeniser(){}
   
    public ArrayList<Token> getTokens(){
        return this.tokens;
    }

    public String sanitise(String s){
        return s.toLowerCase().trim();
    }

    public void tokenise(String s){
        String[] words = s.split("\\s+");
        Token token;

        if(words.length == 0){
            token = new Token(TokenType.ERROR);
            tokens.add(token);
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(i == 0){
                for(TokenType tokenType : TokenType.values()){
                    if(tokenType.name().equals(words[0])){
                        token = new Token(tokenType);
                        tokens.add(token);
                    }else{
                        token = new Token(TokenType.ERROR);
                        tokens.add(token);
                    }
                }
            }
            else if(words[i].equals("on") || words[i].equals("with")){
                token = new Token(TokenType.PREPOSITION, words[i]);
                tokens.add(token);
            }else{
                token = new Token(TokenType.VAR, words[i]);
                tokens.add(token);
            }
        }
    }
}
