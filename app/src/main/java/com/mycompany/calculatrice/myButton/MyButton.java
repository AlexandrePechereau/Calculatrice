package com.mycompany.calculatrice.myButton;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.mycompany.calculatrice.Utils.Utils;
import com.mycompany.calculatrice.myButton.Rules.Rules;

public abstract class MyButton extends Button{

    private String name;

    protected Rules rules;

    protected Utils utils;


    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initMyButton(attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initMyButton(attrs);
    }

    private void initMyButton(AttributeSet attrs){

    }

    public void init(String name, Utils utils){
        this.name = name;
        this.utils = utils;
        this.rules = new Rules(utils);
    }

    public String getName(){
        return name;
    }

    public abstract void  onClick();
}
