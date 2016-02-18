package com.mycompany.calculatrice.myButton.Buttons;

import android.content.Context;
import android.util.AttributeSet;

import com.mycompany.calculatrice.myButton.MyButton;

public class switchModeButton extends MyButton {

    public switchModeButton(Context context) {
        super(context);
    }

    public switchModeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public switchModeButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){

    }

    public void onClick(){
        if(getName().equals("back")){
            repopulateLayout(0);
        }
        else{
            repopulateLayout(1);
        }
    }

    private void repopulateLayout(int mode){ // toggle between the two modes

        if(mode == 0){
            utils.mainll.removeView(utils.ll6);
            utils.mainll.removeView(utils.ll7);
            utils.mainll.removeView(utils.ll8);
            utils.mainll.removeView(utils.ll9);
            utils.mainll.removeView(utils.ll10);
            utils.mainll.addView(utils.ll1);
            utils.mainll.addView(utils.ll2);
            utils.mainll.addView(utils.ll3);
            utils.mainll.addView(utils.ll4);
            utils.mainll.addView(utils.ll5);
        }
        else{
            utils.mainll.removeView(utils.ll1);
            utils.mainll.removeView(utils.ll2);
            utils.mainll.removeView(utils.ll3);
            utils.mainll.removeView(utils.ll4);
            utils.mainll.removeView(utils.ll5);
            utils.mainll.addView(utils.ll6);
            utils.mainll.addView(utils.ll7);
            utils.mainll.addView(utils.ll8);
            utils.mainll.addView(utils.ll9);
            utils.mainll.addView(utils.ll10);
        }

    }
}
