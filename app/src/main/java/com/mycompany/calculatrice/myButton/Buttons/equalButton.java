package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.ShuntingYardAlgorithm.interpreter.ReversePolishNotationEvaluator;
import com.mycompany.calculatrice.ShuntingYardAlgorithm.parser.ShuntingJardAlgorithm;
import com.mycompany.calculatrice.myButton.MyButton;

public class equalButton extends MyButton {

    public equalButton(Context context) {
        super(context);
    }

    public equalButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public equalButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onClick(){
        if(rules.textViewEndsWithDot()) return;
        if(rules.textViewEndsWithE()) return;
        else if(rules.textViewEndsWithEMinus()) return;
        else if(utils.parentheses>0){
            //System.out.println("Not enough right parentheses");
        }
        else {
            String formula = utils.tv.getText().toString();

            ////// HELPING THE LEXER //////////
            formula = formula.replace("√(", "sqrt (");
            formula = formula.replace("-sqrt", "- sqrt");
            formula = formula.replace("exp(", "exp (");
            formula = formula.replace("-exp", "- exp");
            formula = formula.replace("sin(", "sin (");
            formula = formula.replace("-sin", "- sin");
            formula = formula.replace("cos(", "cos (");
            formula = formula.replace("-cos", "- cos");
            formula = formula.replace("tan(", "tan (");
            formula = formula.replace("-tan", "- tan");
            formula = formula.replace("Arcsin(", "Arcsin (");
            formula = formula.replace("-Arcsin", "- Arcsin");
            formula = formula.replace("Arccos(", "Arccos (");
            formula = formula.replace("-Arccos", "- Arccos");
            formula = formula.replace("Arctan(", "Arctan (");
            formula = formula.replace("-Arctan", "- Arctan");
            formula = formula.replace("^(", " ^ (");
            formula = formula.replace("log(", "log (");
            formula = formula.replace("-log", "- log");
            formula = formula.replace("ln(", "ln (");
            formula = formula.replace("-ln", "- ln");
            formula = formula.replace("-(", "- (");

            formula = formula.replace("- -","+"); // helping the calculations
            //////////////////////////////////////

            try {
                String result = String.valueOf(new ReversePolishNotationEvaluator(new ShuntingJardAlgorithm(formula).evaluate()).evaluate());
                utils.tv.setText("");
                if(result.endsWith(".0")) result = result.substring(0,result.length()-2); // deleting .0 a the end of the result
                utils.tv.append(result);
                utils.stack.clear();
                for(int i = 0;i<utils.tv.getText().length();i++) utils.stack.push(1);
                if(rules.textViewEndsWithDot()) utils.dot = true;
                else utils.dot = false;
                utils.parentheses = 0;
            }catch(Exception e) {
                e.printStackTrace();
                utils.tv.setText("");
                utils.tv.append("Error");
                utils.stack.clear();
                utils.dot = false;
                utils.parentheses = 0;
            }
        }
    }
}
