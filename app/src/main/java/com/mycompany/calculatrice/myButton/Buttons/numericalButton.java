package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class numericalButton extends MyButton {

    public numericalButton(Context context) {
        super(context);
        init();
    }

    public numericalButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public numericalButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){

    }

    public void onClick(){
        if(rules.textViewEndsWithRP()){
            utils.stack.push(2);
            utils.tv.append("x ");
        }
        utils.tv.append(getName());
        utils.stack.push(1);
    }
}
