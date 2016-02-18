package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class clearButton extends MyButton{

    public clearButton(Context context) {
        super(context);
    }

    public clearButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public clearButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onClick(){
        if(!rules.textViewTextIsEmpty()) {
            String str = utils.tv.getText().toString();
            String substr = str.subSequence(str.length() - utils.stack.peek(), str.length()).toString();
            if (substr.contains(")")) utils.parentheses++;
            if (substr.contains("(")) utils.parentheses--;
            if(substr.contains(".")) utils.dot = false;
            utils.tv.setText(utils.tv.getText().toString().subSequence(0, utils.tv.getText().toString().length() - (utils.stack.pop())));
        }
    }
}
