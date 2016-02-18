package com.mycompany.calculatrice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mycompany.calculatrice.ShuntingYardAlgorithm.interpreter.ReversePolishNotationEvaluator;
import com.mycompany.calculatrice.ShuntingYardAlgorithm.parser.ShuntingJardAlgorithm;
import com.mycompany.calculatrice.Utils.Utils;
import com.mycompany.calculatrice.myButton.Buttons.numericalButton;
import com.mycompany.calculatrice.myButton.Buttons.switchModeButton;
import com.mycompany.calculatrice.myButton.MyButton;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        utils = new Utils();

        utils.tv = (TextView) findViewById(R.id.textView);

        utils.stack = new Stack<>();
        utils.dot = false;
        utils.parentheses = 0;

        //tv.setText(Html.fromHtml("X<sup>2<sup>2</sup></sup>"));

        utils.mainll = (LinearLayout) findViewById(R.id.mainLayoutContainer);
        utils.ll1 = (LinearLayout) findViewById(R.id.line1);
        utils.ll2 = (LinearLayout) findViewById(R.id.line2);
        utils.ll3 = (LinearLayout) findViewById(R.id.line3);
        utils.ll4 = (LinearLayout) findViewById(R.id.line4);
        utils.ll5 = (LinearLayout) findViewById(R.id.line5);
        utils.ll6 = (LinearLayout) findViewById(R.id.line6);
        utils.ll7 = (LinearLayout) findViewById(R.id.line7);
        utils.ll8 = (LinearLayout) findViewById(R.id.line8);
        utils.ll9 = (LinearLayout) findViewById(R.id.line9);
        utils.ll10 = (LinearLayout) findViewById(R.id.line10);

        MyButton buttonmore = (MyButton) findViewById(R.id.buttonmore);
        buttonmore.setOnClickListener(myButtonListener);
        buttonmore.init("more", utils);

        MyButton buttonback = (MyButton) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(myButtonListener);
        buttonback.init("back", utils);

        MyButton button0 = (MyButton) findViewById(R.id.button0);
        button0.setOnClickListener(myButtonListener);
        button0.init("0", utils);

        MyButton button1 = (MyButton) findViewById(R.id.button1);
        button1.setOnClickListener(myButtonListener);
        button1.init("1", utils);

        MyButton button2 = (MyButton) findViewById(R.id.button2);
        button2.setOnClickListener(myButtonListener);
        button2.init("2", utils);

        MyButton button3 = (MyButton) findViewById(R.id.button3);
        button3.setOnClickListener(myButtonListener);
        button3.init("3", utils);

        MyButton button4 = (MyButton) findViewById(R.id.button4);
        button4.setOnClickListener(myButtonListener);
        button4.init("4", utils);

        MyButton button5 = (MyButton) findViewById(R.id.button5);
        button5.setOnClickListener(myButtonListener);
        button5.init("5", utils);

        MyButton button6 = (MyButton) findViewById(R.id.button6);
        button6.setOnClickListener(myButtonListener);
        button6.init("6", utils);

        MyButton button7 = (MyButton) findViewById(R.id.button7);
        button7.setOnClickListener(myButtonListener);
        button7.init("7", utils);

        MyButton button8 = (MyButton) findViewById(R.id.button8);
        button8.setOnClickListener(myButtonListener);
        button8.init("8", utils);

        MyButton button9 = (MyButton) findViewById(R.id.button9);
        button9.setOnClickListener(myButtonListener);
        button9.init("9", utils);

        MyButton buttonAC = (MyButton) findViewById(R.id.buttonAC);
        buttonAC.setOnClickListener(myButtonListener);
        buttonAC.init("AC", utils);

        MyButton buttonAC2 = (MyButton) findViewById(R.id.buttonAC2);
        buttonAC2.setOnClickListener(myButtonListener);
        buttonAC2.init("AC2", utils);

        MyButton buttonC = (MyButton) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(myButtonListener);
        buttonC.init("C", utils);

        MyButton buttonC2 = (MyButton) findViewById(R.id.buttonC2);
        buttonC2.setOnClickListener(myButtonListener);
        buttonC2.init("C2", utils);

        MyButton buttonpercent = (MyButton) findViewById(R.id.buttonpercent);
        buttonpercent.setOnClickListener(myButtonListener);
        buttonpercent.init("percent", utils);

        MyButton buttondivision = (MyButton) findViewById(R.id.buttondivision);
        buttondivision.setOnClickListener(myButtonListener);
        buttondivision.init("/", utils);

        MyButton buttonmul = (MyButton) findViewById(R.id.buttonmul);
        buttonmul.setOnClickListener(myButtonListener);
        buttonmul.init("x", utils);

        MyButton buttonplus = (MyButton) findViewById(R.id.buttonplus);
        buttonplus.setOnClickListener(myButtonListener);
        buttonplus.init("+", utils);

        MyButton buttonminus = (MyButton) findViewById(R.id.buttonminus);
        buttonminus.setOnClickListener(myButtonListener);
        buttonminus.init("-", utils);

        MyButton buttonequal = (MyButton) findViewById(R.id.buttonequal);
        buttonequal.setOnClickListener(myButtonListener);
        buttonequal.init("=", utils);

        MyButton buttondot = (MyButton) findViewById(R.id.buttondot);
        buttondot.setOnClickListener(myButtonListener);
        buttondot.init(".", utils);

        MyButton buttonlog = (MyButton) findViewById(R.id.buttonlog);
        buttonlog.setOnClickListener(myButtonListener);
        buttonlog.init("log", utils);

        MyButton buttonln = (MyButton) findViewById(R.id.buttonln);
        buttonln.setOnClickListener(myButtonListener);
        buttonln.init("ln", utils);

        MyButton buttonlp = (MyButton) findViewById(R.id.buttonlp);
        buttonlp.setOnClickListener(myButtonListener);
        buttonlp.init("(", utils);

        MyButton buttonrp = (MyButton) findViewById(R.id.buttonrp);
        buttonrp.setOnClickListener(myButtonListener);
        buttonrp.init(")", utils);

        MyButton buttonsin = (MyButton) findViewById(R.id.buttonsin);
        buttonsin.setOnClickListener(myButtonListener);
        buttonsin.init("sin", utils);

        MyButton buttondec = (MyButton) findViewById(R.id.buttondec);
        buttondec.setOnClickListener(myButtonListener);
        buttondec.init("blank", utils);

        MyButton buttonexponent = (MyButton) findViewById(R.id.buttonexponent);
        buttonexponent.setOnClickListener(myButtonListener);
        buttonexponent.init("^", utils);

        MyButton buttonsquareroot = (MyButton) findViewById(R.id.buttonsquareroot);
        buttonsquareroot.setOnClickListener(myButtonListener);
        buttonsquareroot.init("√", utils);

        MyButton buttoncos = (MyButton) findViewById(R.id.buttoncos);
        buttoncos.setOnClickListener(myButtonListener);
        buttoncos.init("cos", utils);

        MyButton buttonhex = (MyButton) findViewById(R.id.buttonhex);
        buttonhex.setOnClickListener(myButtonListener);
        buttonhex.init("blank", utils);

        MyButton buttonplusorminus = (MyButton) findViewById(R.id.buttonplusorminus);
        buttonplusorminus.setOnClickListener(myButtonListener);
        buttonplusorminus.init("+/-", utils);

        MyButton buttonexp = (MyButton) findViewById(R.id.buttonexp);
        buttonexp.setOnClickListener(myButtonListener);
        buttonexp.init("exp", utils);

        MyButton buttontan = (MyButton) findViewById(R.id.buttontan);
        buttontan.setOnClickListener(myButtonListener);
        buttontan.init("tan", utils);

        MyButton buttonbin = (MyButton) findViewById(R.id.buttonbin);
        buttonbin.setOnClickListener(myButtonListener);
        buttonbin.init("blank", utils);

        MyButton buttonsinminus1 = (MyButton) findViewById(R.id.buttonarcsin);
        buttonsinminus1.setOnClickListener(myButtonListener);
        buttonsinminus1.init("Arcsin", utils);

        MyButton buttoncosminus1 = (MyButton) findViewById(R.id.buttonarccos);
        buttoncosminus1.setOnClickListener(myButtonListener);
        buttoncosminus1.init("Arccos", utils);

        MyButton buttontanminus1 = (MyButton) findViewById(R.id.buttonarctan);
        buttontanminus1.setOnClickListener(myButtonListener);
        buttontanminus1.init("Arctan", utils);

        ///// remove the last 5 lines (5 LinearLayouts) of the xml because they should not be visible at the same time ///////
        utils.mainll.removeView(utils.ll6);
        utils.mainll.removeView(utils.ll7);
        utils.mainll.removeView(utils.ll8);
        utils.mainll.removeView(utils.ll9);
        utils.mainll.removeView(utils.ll10);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    final private View.OnClickListener myButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(utils.tv.getText().toString().endsWith("Error")) {
                utils.tv.setText("");
                utils.stack.empty();
                utils.parentheses = 0;
            }
            MyButton mb = (MyButton)findViewById(v.getId());
            mb.onClick();
        }

    };
}

