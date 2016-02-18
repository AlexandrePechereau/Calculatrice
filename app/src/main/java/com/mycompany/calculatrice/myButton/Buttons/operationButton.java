package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class operationButton extends MyButton {

    public operationButton(Context context) {
        super(context);
    }

    public operationButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public operationButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onClick(){
        utils.dot = false;
        if(rules.textViewEndsWithDot() || rules.textViewEndsWithOperator() || rules.textViewEndsWithE()) {
            utils.tv.setText(utils.tv.getText().toString().subSequence(0, utils.tv.getText().toString().length() - (utils.stack.pop())));
        }
        if(!rules.textViewTextIsEmpty()){
            if(!rules.textViewEndsWithRP()) {
                if (rules.textViewEndsWithDigit() && !rules.textViewEndsWithMinus()) {
                    utils.tv.append(" "+getName()+" ");
                    utils.stack.push(3);
                }
            }
            else{
                utils.tv.append(getName()+" ");
                utils.stack.push(2);
            }

        }
    }
}