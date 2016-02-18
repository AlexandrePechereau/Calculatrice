package com.mycompany.calculatrice.myButton.Rules;

import com.mycompany.calculatrice.Utils.Utils;

public class Rules {

    private Utils utils;

    public Rules(Utils utils){
        this.utils = utils;
    }

    public boolean textViewEndsWithEMinus(){
        if(stackEmpty()) return false;
        return utils.tv.getText().toString().endsWith("E-");
    }

    public boolean textViewEndsWithRP(){
        if(stackEmpty()) return false;
        return utils.tv.getText().toString().endsWith(" ) ");
    }

    public boolean textViewTextIsEmpty(){
        return utils.tv.getText().toString().isEmpty();
    }

    public boolean textViewEndsWithDigit(){
        if(stackEmpty()) return false;
        return (utils.stack.peek() == 1 && !textViewEndsWithDot() && !textViewEndsWithMinus() && !textViewEndsWithE() && !textViewEndsWithEMinus());
    }

    public boolean textViewEndsWithDot(){
        if(stackEmpty()) return false;
        return (utils.stack.peek() == 1 && utils.tv.getText().toString().endsWith("."));
    }

    public boolean textViewEndsWithMinus(){
        if(stackEmpty()) return false;
        return (utils.stack.peek() == 1 && utils.tv.getText().toString().endsWith("-"));
    }

    public boolean stackEmpty(){
        return utils.stack.empty();
    }

    public boolean textViewEndsWithE(){
        if(stackEmpty()) return false;
        return utils.tv.getText().toString().endsWith("E");
    }

    public boolean textViewEndsWithLP(){
        if(stackEmpty()) return false;
        return utils.tv.getText().toString().endsWith("( ");
    }

    public boolean stackPeekMoreThanOne(){
        return utils.stack.peek() > 1;
    }

    public boolean textViewEndsWithOperator(){
        if(stackEmpty()) return false;
        return (utils.tv.getText().toString().endsWith(" / ") || utils.tv.getText().toString().endsWith(" - ") || utils.tv.getText().toString().endsWith(" x ") || utils.tv.getText().toString().endsWith(" + "));
    }
}
