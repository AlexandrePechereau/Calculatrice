package com.mycompany.calculatrice.ShuntingYardAlgorithm.interpreter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.LinkedList;

import com.mycompany.calculatrice.ShuntingYardAlgorithm.lexer.Lexer;

public class ReversePolishNotationEvaluator {
    private LinkedList<String> stack = new LinkedList<String>();
    private String bytecode;

    public ReversePolishNotationEvaluator(String expression) {
        this.bytecode = expression;
    }

    public Double evaluate() throws NumberFormatException{
	    System.out.println(bytecode);
	    String code[] = bytecode.split(" ");
        String instruction;
	    double firstOperand;
        BigDecimal firstOp, secondOp;
	    int instructionPointer = 0; //instruction pointer
	    //System.out.println("IP,\tCode[IP],\tSTACK");
	    while (instructionPointer < code.length && instructionPointer > -1) {
		    //System.out.printf("%d,\t%s,\t\t%s\n", instructionPointer, code[instructionPointer], stack);
            instruction = code[instructionPointer++];
		    if(Lexer.isNumber(instruction)) {
                stack.push(instruction);
            } else {
			    if (instruction.equals("^")) {
                    secondOp = castBigDecimal(stack.pop());
                    firstOp = castBigDecimal(stack.pop());
                    stack.push("" + StrictMath.pow(firstOp.doubleValue(), secondOp.doubleValue()));

			    } else if (instruction.equals("/")) {
                    secondOp = castBigDecimal(stack.pop());
                    firstOp = castBigDecimal(stack.pop());
				    stack.push("" + firstOp.divide(secondOp));
			    } else if (instruction.equals("x")) {
                    secondOp = castBigDecimal(stack.pop());
                    firstOp = castBigDecimal(stack.pop());
				    stack.push("" + firstOp.multiply(secondOp));
			    } else if (instruction.equals("+")) {
                    secondOp = castBigDecimal(stack.pop());
                    firstOp = castBigDecimal(stack.pop());
				    stack.push("" + firstOp.add(secondOp));
			    } else if (instruction.equals("-")) {
                    secondOp = castBigDecimal(stack.pop());
				    if(stack.peek() != null && Lexer.isNumber(stack.peek())) { // unary minus
                        firstOp = castBigDecimal(stack.pop());
				    	stack.push("" + firstOp.subtract(secondOp));
				    } else {
                        System.out.println("minus");
				    	stack.push("" + secondOp.multiply(new BigDecimal (-1)));
				    }
			    } else if (instruction.equals("sin")) {
                    firstOperand = cast(stack.pop());
		            stack.push("" + StrictMath.sin(firstOperand));
	            } else if (instruction.equals("cos")) {
		            firstOperand = cast(stack.pop());
		            stack.push("" + StrictMath.cos(firstOperand));
	            } else if (instruction.equals("tan")) {
					firstOperand = cast(stack.pop());
					stack.push("" + StrictMath.tan(firstOperand));
				} else if (instruction.equals("Arctan")) {
		            firstOperand = cast(stack.pop());
		            stack.push("" + StrictMath.atan(firstOperand));
	            } else if (instruction.equals("log")) {
		            firstOperand = cast(stack.pop());
		            stack.push("" + StrictMath.log10(firstOperand));
	            } else if (instruction.equals("exp")) {
		            firstOperand = cast(stack.pop());
		            stack.push("" + StrictMath.exp(firstOperand));
	            } else if(instruction.equals("Arcsin")){
					firstOperand = cast(stack.pop());
					stack.push("" + StrictMath.asin(firstOperand));
				} else if (instruction.equals("Arccos")) {
					firstOperand = cast(stack.pop());
					stack.push("" + StrictMath.acos(firstOperand));
				} else if (instruction.equals("ln")) {
					firstOperand = cast(stack.pop());
					stack.push("" + StrictMath.log(firstOperand));
				} else if (instruction.equals("sqrt")) {
					firstOperand = cast(stack.pop());
					stack.push("" + StrictMath.sqrt(firstOperand));
				}
				else {
		            throw new RuntimeException("Unknown instruction: " + instruction);
	            }
            }
        }
        return castBigDecimal(stack.pop()).doubleValue();
    }

	private BigDecimal castBigDecimal(String token) throws NumberFormatException{ return new BigDecimal(token, new MathContext(10));}

	private Double cast(String token) {
		return Double.parseDouble(token);
	}
}
