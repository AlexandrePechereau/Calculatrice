package com.mycompany.calculatrice.ShuntingYardAlgorithm.lexer;

import java.io.*;
import java.util.Stack;

public class Lexer {

	private Stack<String> input;
    private String current;

	private int symbol = NONE;
	public static final int INVALID = -1;
	public static final int NONE = 0;
	public static final int PLUS = 1;
	public static final int MINUS = 2;
	public static final int MULTIPLY = 3;
	public static final int DIVIDE = 4;
	public static final int POWER = 10;
	public static final int CONSTANT = 5;
	public static final int FUNCTION = 13;
	public static final int LEFT = 7;
	public static final int RIGHT = 8;
	public static final int COMMA = 11;
	public static final int EOF = 9;
	public static final int EOL = 12;

	public Lexer(String expression){
        input = new Stack();

        String[] inputsplit = expression.split(" ");
        for(String str : inputsplit){
            if(getSymbol(str)==CONSTANT){
                if(!str.contains(".")){
                    str = str+".0";
                }
            }
            input.add(0,str);
        }
    }

    /*public String getString(){
        return null;
    }*/
    public static int getSymbol(String str){
        switch (str) {
            case "(":
                return LEFT;
            case ")":
                return RIGHT;
            case "+":
                return PLUS;
            case "x":
                return MULTIPLY;
            case "-":
                return MINUS;
            case "/":
                return DIVIDE;
            case "log":
                return FUNCTION;
            case "ln":
                return FUNCTION;
            case "sin":
                return FUNCTION;
            case "cos":
                return FUNCTION;
            case "tan":
                return FUNCTION;
            case "Arcsin":
                return FUNCTION;
            case "Arccos":
                return FUNCTION;
            case "Arctan":
                return FUNCTION;
            case "exp":
                return FUNCTION;
            case "sqrt":
                return FUNCTION;
            case "^":
                return POWER;
            default:
                return CONSTANT;
        }
    }

    public int nextSymbol(){
        if(!input.isEmpty()) {
            current = input.pop();
            getSymbol(current);
        }
        else{
            symbol = EOF;
        }
        return symbol;
    }

    public String stringfy() {
        return current;
    }

    public static boolean isNumber(String str){

        return getSymbol(str) == CONSTANT;
    }

    public static void main(String[] args) {
        Lexer l = new Lexer("log ( ln ( sin ( Arcsin ( Arccos ( Arctan ( tan ( cos ( exp ( sqrt ( 2 )  )  )  )  )  )  )  )  )  ) ^ ( 2 ) + -8");
        int s;
        while ( (s = l.nextSymbol()) != Lexer.EOF) if(s != EOL) System.out.println(s + " " + l.stringfy());
    }

}