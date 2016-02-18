package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class allClearButton extends MyButton {

    public allClearButton(Context context) {
        super(context);
    }

    public allClearButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public allClearButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onClick(){
        utils.tv.setText("");
        utils.dot = false;
        utils.stack.empty();
        utils.parentheses = 0;
    }
}

