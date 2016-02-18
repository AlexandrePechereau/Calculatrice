package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class functionButton extends MyButton {

    public functionButton(Context context) {
        super(context);
    }

    public functionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public functionButton(Context context, AttributeSet attrs, int defStyle) {
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
                String str = " x "+getName()+"( ";
                utils.tv.append(str);
                utils.stack.push(str.length());
            }
            else if(!rules.textViewEndsWithEMinus() && !rules.textViewEndsWithE()){
                String str = getName()+"( ";
                utils.tv.append(str);
                utils.stack.push(str.length());
            }
        }
        else{
            String str = getName()+"( ";
            utils.tv.append(str);
            utils.stack.push(str.length());
        }
    }
}