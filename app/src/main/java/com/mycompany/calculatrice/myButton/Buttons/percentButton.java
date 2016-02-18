package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class percentButton extends MyButton {

    public percentButton(Context context) {
        super(context);
    }

    public percentButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public percentButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void onClick(){
        if(rules.textViewEndsWithDigit()) {
            int nb_char = 0;
            boolean b_continue = rules.textViewEndsWithDigit();
            while (b_continue) {
                nb_char = nb_char + utils.stack.pop();
                if(!rules.stackEmpty()) b_continue = rules.textViewEndsWithDigit();
                else break;
            }
            if(!rules.stackEmpty()) {
                String text = utils.tv.getText().toString();
                String str_left_part = text.substring(0, text.length() - nb_char);
                String str_right_part = text.substring(text.length() - nb_char, text.length());
                str_right_part = getPercentage(str_right_part);
                for (int i = 0; i < str_right_part.length(); i++) utils.stack.push(1);
                utils.tv.setText("");
                utils.tv.append(str_left_part);
                utils.tv.append(str_right_part);
            }
            else{
                String text = utils.tv.getText().toString();
                text = getPercentage(text);
                for (int i = 0; i < text.length(); i++) utils.stack.push(1);
                utils.tv.setText("");
                utils.tv.append(text);
            }
        }
    }

    private String getPercentage(String nb){
        double val = Double.parseDouble(nb);
        String result = String.valueOf((val/100));
        if(result.equals("0.0")) return "0";
        else return result;
    }
}
