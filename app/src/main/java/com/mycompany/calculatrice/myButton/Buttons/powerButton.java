package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class powerButton extends MyButton {

    public powerButton(Context context) {
        super(context);
    }

    public powerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public powerButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onClick(){
        utils.dot = false;
        utils.parentheses++;
        if(rules.textViewEndsWithDot()) {
            utils.tv.setText(utils.tv.getText().toString().subSequence(0, utils.tv.getText().toString().length() - (utils.stack.pop())));
        }
        if(!rules.textViewTextIsEmpty()){
            if(rules.textViewEndsWithDigit() || rules.textViewEndsWithRP()){
                utils.tv.append("^( ");
                utils.stack.push(3);
            }
        }
    }
}