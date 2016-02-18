package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class RPButton extends MyButton {

    public RPButton(Context context) {
        super(context);
    }

    public RPButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RPButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onClick(){
        if(utils.parentheses > 0) {

            if (rules.textViewEndsWithDot()) {
                utils.tv.setText(utils.tv.getText().toString().subSequence(0, utils.tv.getText().toString().length() - (utils.stack.pop())));
            }
            if (!rules.textViewTextIsEmpty()) {
                if(rules.textViewEndsWithRP()){
                    utils.parentheses--;
                    utils.tv.append(") ");
                    utils.stack.push(2);
                }
                else {
                    if (rules.textViewEndsWithDigit()) {

                        utils.parentheses--;
                        utils.tv.append(" ) ");
                        utils.stack.push(3);
                    }
                }
            }
        }
    }
}