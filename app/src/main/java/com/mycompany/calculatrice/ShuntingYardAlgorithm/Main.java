package com.mycompany.calculatrice.ShuntingYardAlgorithm;

import com.mycompany.calculatrice.ShuntingYardAlgorithm.parser.ShuntingJardAlgorithm;
import com.mycompany.calculatrice.ShuntingYardAlgorithm.interpreter.ReversePolishNotationEvaluator;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
	    Scanner sc = new Scanner((System.in));
		String expression = "";
	    if(args.length > 0 && args[0].equals("-f")) {
		    while(sc.hasNextLine()) expression += sc.nextLine(); System.out.println(expression);
	    } else {
		    System.out.println("Insert an expression");
		    expression = sc.nextLine();
	    }
	    try {
	    	System.out.println(new ReversePolishNotationEvaluator(new ShuntingJardAlgorithm(expression).evaluate()).evaluate());	    	
	    } catch (NoSuchElementException e) {
	    	System.out.println("Syntax error!");
	    }
    }
}
