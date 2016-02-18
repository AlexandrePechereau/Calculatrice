package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class dotButton extends MyButton {

    public dotButton(Context context) {
        super(context);
    }

    public dotButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public dotButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onClick(){
        if(rules.textViewEndsWithDigit() && !utils.dot){ //prevent double dot in a number
            utils.tv.append(".");
            utils.dot = true;
            utils.stack.push(1);
        }
    }
}
