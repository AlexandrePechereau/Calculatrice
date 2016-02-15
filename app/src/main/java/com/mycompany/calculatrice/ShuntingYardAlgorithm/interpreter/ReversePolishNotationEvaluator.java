package com.mycompany.calculatrice.ShuntingYardAlgorithm.interpreter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

import com.mycompany.calculatrice.BigDecimalMath;
import com.mycompany.calculatrice.ShuntingYardAlgorithm.lexer.Lexer;

public class ReversePolishNotationEvaluator {
    private LinkedList<String> stack = new LinkedList<String>();
    private String bytecode;

    public ReversePolishNotationEvaluator(String expression) {
        this.bytecode = expression;
    }
	public HashMap<String, Double> context = new HashMap<String, Double>();
	
    public Double evaluate() {
	    System.out.println(bytecode);
	    String code[] = bytecode.split(" ");
        String instruction;
	    //double firstOperand, secondOperand;
        BigDecimal firstOp, secondOp;
	    int instructionPointer = 0; //instruction pointer
	    //System.out.println("IP,\tCode[IP],\tSTACK");
	    while (instructionPointer < code.length && instructionPointer > -1) {
		    //System.out.printf("%d,\t%s,\t\t%s\n", instructionPointer, code[instructionPointer], stack);
			if(stack.peek() == "NaN") return Double.parseDouble("NaN");
            instruction = code[instructionPointer++];
		    if(Lexer.isNumber(instruction)) {
                stack.push(instruction);
            } else {
			    if (instruction.equals("^")) {
                    secondOp = castBigDecimal(stack.pop());
                    firstOp = castBigDecimal(stack.pop());
				    stack.push("" + BigDecimalMath.pow(firstOp, secondOp));
			    } else if (instruction.equals("/")) {
                    secondOp = castBigDecimal(stack.pop());
                    firstOp = castBigDecimal(stack.pop());
				    stack.push("" + BigDecimalMath.divideRound(firstOp, secondOp));
			    } else if (instruction.equals("x")) {
                    secondOp = castBigDecimal(stack.pop());
                    firstOp = castBigDecimal(stack.pop());
				    stack.push("" + BigDecimalMath.multiplyRound(firstOp, secondOp));
			    } else if (instruction.equals("+")) {
                    secondOp = castBigDecimal(stack.pop());
                    firstOp = castBigDecimal(stack.pop());
				    stack.push("" + BigDecimalMath.addRound(firstOp, secondOp));
			    } else if (instruction.equals("-")) {
                    secondOp = castBigDecimal(stack.pop());
				    if(stack.peek() != null && Lexer.isNumber(stack.peek())) { // unary minus
                        firstOp = castBigDecimal(stack.pop());
				    	stack.push("" + BigDecimalMath.subtractRound(firstOp, secondOp));
				    } else {
                        System.out.println("minus");
				    	stack.push("" + BigDecimalMath.multiplyRound(secondOp, (-1)));
				    }
			    }
                else if (instruction.equals("sin")) {
		            firstOp = castBigDecimal(stack.pop());
		            stack.push("" + BigDecimalMath.sin(firstOp));
	            } else if (instruction.equals("cos")) {
                    firstOp = castBigDecimal(stack.pop());
		            stack.push("" + BigDecimalMath.cos(firstOp));
	            } else if (instruction.equals("tan")) {
                    firstOp = castBigDecimal(stack.pop());
					stack.push("" + BigDecimalMath.tan(firstOp));
				} else if (instruction.equals("Arctan")) {
                    firstOp = castBigDecimal(stack.pop());
		            stack.push("" + BigDecimalMath.atan(firstOp));
	            } else if (instruction.equals("log")) {
                    firstOp = castBigDecimal(stack.pop());
		            stack.push("" + BigDecimalMath.log(firstOp));
	            } else if (instruction.equals("exp")) {
                    firstOp = castBigDecimal(stack.pop());
		            stack.push("" + BigDecimalMath.exp(firstOp));
	            } else if(instruction.equals("Arcsin")){
                    firstOp = castBigDecimal(stack.pop());
					stack.push("" + BigDecimalMath.asin(firstOp));
				} else if (instruction.equals("Arccos")) {
                    firstOp = castBigDecimal(stack.pop());
					stack.push("" + BigDecimalMath.acos(firstOp));
				} else if (instruction.equals("ln")) {
                    firstOp = castBigDecimal(stack.pop());
					stack.push("" + BigDecimalMath.divideRound(BigDecimalMath.log(firstOp), BigDecimalMath.log(10,new MathContext(1))));
				} else if (instruction.equals("sqrt")) {
                    firstOp = castBigDecimal(stack.pop());
					stack.push("" + BigDecimalMath.sqrt(firstOp));
				}
	            /*else if (instruction.equals("ack")) {
	            	secondOperand = cast(stack.pop());
		            firstOperand = cast(stack.pop());
		            stack.push("" + ackermann(firstOperand, secondOperand));
	            }*/
				else {
		            throw new RuntimeException("Unknown instruction: " + instruction);
	            }
            }
        }
        return castBigDecimal(stack.pop()).doubleValue();
    }

	private BigDecimal castBigDecimal(String token){ return new BigDecimal(token);}
}
