package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class LPButton extends MyButton {

    public LPButton(Context context) {
        super(context);
    }

    public LPButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LPButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onClick(){
        if(rules.textViewEndsWithDot()) {
            utils.tv.setText(utils.tv.getText().toString().subSequence(0, utils.tv.getText().toString().length() - (utils.stack.pop())));
        }
        if(!rules.textViewTextIsEmpty()){
            if(rules.textViewEndsWithDigit() || rules.textViewEndsWithRP()){
                utils.tv.append(" x ( ");
                utils.stack.push(5);
            }
            else if(!rules.textViewEndsWithEMinus() && !rules.textViewEndsWithE()){
                utils.tv.append("( ");
                utils.stack.push(2);
            }
            utils.dot = false;
            utils.parentheses++;
        }
        else{
            utils.tv.append("( ");
            utils.stack.push(2);
            utils.dot = false;
            utils.parentheses++;
        }
    }
}