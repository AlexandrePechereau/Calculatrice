package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class plusOrMinusButton extends MyButton {

    public plusOrMinusButton(Context context) {
        super(context);
    }

    public plusOrMinusButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public plusOrMinusButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onClick(){
        if(((rules.textViewTextIsEmpty() || (rules.stackPeekMoreThanOne())) && !rules.textViewEndsWithRP()) || rules.textViewEndsWithE()){
            utils.tv.append("-");
            utils.stack.push(1);
        }
        else{
            if(rules.textViewEndsWithMinus()){
                utils.tv.setText(utils.tv.getText().toString().subSequence(0, utils.tv.getText().toString().length() - (utils.stack.pop())));
            }
            else if((rules.textViewEndsWithDigit() || rules.textViewEndsWithDot())&& !rules.textViewEndsWithMinus()) {
                int nb_char = 0;
                boolean b_continue = (rules.textViewEndsWithDigit() || rules.textViewEndsWithDot());
                while (b_continue) {
                    nb_char = nb_char + utils.stack.pop();
                    if(!rules.stackEmpty()) b_continue = (rules.textViewEndsWithDigit()|| rules.textViewEndsWithDot());
                    else break;
                }
                if(!rules.stackEmpty()) {
                    String text = utils.tv.getText().toString();
                    String str_left_part = text.substring(0, text.length() - nb_char);
                    String str_right_part = text.substring(text.length() - nb_char, text.length());
                    utils. tv.setText("");
                    utils.tv.append(str_left_part);
                    if (str_right_part.contains("-")) {
                        str_right_part = str_right_part.subSequence(1, str_right_part.length()).toString();
                    } else {
                        str_right_part = "-" + str_right_part;
                    }
                    utils.tv.append(str_right_part);
                    for (int i = 0; i < str_right_part.length(); i++) utils.stack.push(1);

                }
                else{
                    String text = utils.tv.getText().toString();
                    if(text.charAt(0) == '-'){
                        text = text.subSequence(1,text.length()).toString();
                    }
                    else{
                        text = "-"+text;
                    }
                    for (int i = 0; i < text.length(); i++) utils.stack.push(1);
                    utils.tv.setText("");
                    utils.tv.append(text);
                }
            }
        }
    }
}