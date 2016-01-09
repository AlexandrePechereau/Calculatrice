package com.mycompany.calculatrice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mycompany.calculatrice.ShuntingYardAlgorithm.interpreter.ReversePolishNotationEvaluator;
import com.mycompany.calculatrice.ShuntingYardAlgorithm.parser.ShuntingJardAlgorithm;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainll;
    private LinearLayout ll1;
    private LinearLayout ll2;
    private LinearLayout ll3;
    private LinearLayout ll4;
    private LinearLayout ll5;
    private LinearLayout ll6;
    private LinearLayout ll7;
    private LinearLayout ll8;
    private LinearLayout ll9;
    private LinearLayout ll10;

    private TextView tv;
    private Stack<Integer> stack;
    private boolean dot;
    private int parentheses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        stack = new Stack<>(); //enable the clear feature to remove exactly the right number of character(s)
        dot = false;
        parentheses = 0;

        mainll = (LinearLayout) findViewById(R.id.mainLayoutContainer);
        ll1 = (LinearLayout) findViewById(R.id.line1);
        ll2 = (LinearLayout) findViewById(R.id.line2);
        ll3 = (LinearLayout) findViewById(R.id.line3);
        ll4 = (LinearLayout) findViewById(R.id.line4);
        ll5 = (LinearLayout) findViewById(R.id.line5);
        ll6 = (LinearLayout) findViewById(R.id.line6);
        ll7 = (LinearLayout) findViewById(R.id.line7);
        ll8 = (LinearLayout) findViewById(R.id.line8);
        ll9 = (LinearLayout) findViewById(R.id.line9);
        ll10 = (LinearLayout) findViewById(R.id.line10);

        Button buttonmore = (Button) findViewById(R.id.buttonmore);
        buttonmore.setOnClickListener(myButtonListener);

        Button buttonmore2 = (Button) findViewById(R.id.buttonmore2);
        buttonmore2.setOnClickListener(myButtonListener);

        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(myButtonListener);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(myButtonListener);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(myButtonListener);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(myButtonListener);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(myButtonListener);

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(myButtonListener);

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(myButtonListener);

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(myButtonListener);

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(myButtonListener);

        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(myButtonListener);

        Button buttonAC = (Button) findViewById(R.id.buttonAC);
        buttonAC.setOnClickListener(myButtonListener);

        Button buttonAC2 = (Button) findViewById(R.id.buttonAC2);
        buttonAC2.setOnClickListener(myButtonListener);

        Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(myButtonListener);

        Button buttonC2 = (Button) findViewById(R.id.buttonC2);
        buttonC2.setOnClickListener(myButtonListener);

        Button buttonpercent = (Button) findViewById(R.id.buttonpercent);
        buttonpercent.setOnClickListener(myButtonListener);

        Button buttondivision = (Button) findViewById(R.id.buttondivision);
        buttondivision.setOnClickListener(myButtonListener);

        Button buttonmul = (Button) findViewById(R.id.buttonmul);
        buttonmul.setOnClickListener(myButtonListener);

        Button buttonplus = (Button) findViewById(R.id.buttonplus);
        buttonplus.setOnClickListener(myButtonListener);

        Button buttonminus = (Button) findViewById(R.id.buttonminus);
        buttonminus.setOnClickListener(myButtonListener);

        Button buttonequal = (Button) findViewById(R.id.buttonequal);
        buttonequal.setOnClickListener(myButtonListener);

        Button buttondot = (Button) findViewById(R.id.buttondot);
        buttondot.setOnClickListener(myButtonListener);

        Button buttonlog = (Button) findViewById(R.id.buttonlog);
        buttonlog.setOnClickListener(myButtonListener);

        Button buttonln = (Button) findViewById(R.id.buttonln);
        buttonln.setOnClickListener(myButtonListener);

        Button buttonlp = (Button) findViewById(R.id.buttonlp);
        buttonlp.setOnClickListener(myButtonListener);

        Button buttonrp = (Button) findViewById(R.id.buttonrp);
        buttonrp.setOnClickListener(myButtonListener);

        Button buttonsin = (Button) findViewById(R.id.buttonsin);
        buttonsin.setOnClickListener(myButtonListener);

        Button buttondec = (Button) findViewById(R.id.buttondec);
        buttondec.setOnClickListener(myButtonListener);

        Button buttonexponent = (Button) findViewById(R.id.buttonexponent);
        buttonexponent.setOnClickListener(myButtonListener);

        Button buttonexposant = (Button) findViewById(R.id.buttonsquareroot);
        buttonexposant.setOnClickListener(myButtonListener);

        Button buttoncos = (Button) findViewById(R.id.buttoncos);
        buttoncos.setOnClickListener(myButtonListener);

        Button buttonhex = (Button) findViewById(R.id.buttonhex);
        buttonhex.setOnClickListener(myButtonListener);

        Button buttonplusorminus = (Button) findViewById(R.id.buttonplusorminus);
        buttonplusorminus.setOnClickListener(myButtonListener);

        Button buttoneexp = (Button) findViewById(R.id.buttoneexp);
        buttoneexp.setOnClickListener(myButtonListener);

        Button buttontan = (Button) findViewById(R.id.buttontan);
        buttontan.setOnClickListener(myButtonListener);

        Button buttonbin = (Button) findViewById(R.id.buttonbin);
        buttonbin.setOnClickListener(myButtonListener);

        Button buttonsinminus1 = (Button) findViewById(R.id.buttonarcsin);
        buttonsinminus1.setOnClickListener(myButtonListener);

        Button buttoncosminus1 = (Button) findViewById(R.id.buttonarccos);
        buttoncosminus1.setOnClickListener(myButtonListener);

        Button buttontanminus1 = (Button) findViewById(R.id.buttonarctan);
        buttontanminus1.setOnClickListener(myButtonListener);

        mainll.removeView(ll6);
        mainll.removeView(ll7);
        mainll.removeView(ll8);
        mainll.removeView(ll9);
        mainll.removeView(ll10);

    }

    final private View.OnClickListener myButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonmore:
                    repopulateLayout(1);
                    break;
                case R.id.buttonmore2:
                    repopulateLayout(0);
                    break;
                case R.id.button0:
                    tv.append("0");
                    stack.push(1);
                    break;
                case R.id.button1:
                    tv.append("1");
                    stack.push(1);
                    break;
                case R.id.button2:
                    tv.append("2");
                    stack.push(1);
                    break;
                case R.id.button3:
                    tv.append("3");
                    stack.push(1);
                    break;
                case R.id.button4:
                    tv.append("4");
                    stack.push(1);
                    break;
                case R.id.button5:
                    tv.append("5");
                    stack.push(1);
                    break;
                case R.id.button6:
                    tv.append("6");
                    stack.push(1);
                    break;
                case R.id.button7:
                    tv.append("7");
                    stack.push(1);
                    break;
                case R.id.button8:
                    tv.append("8");
                    stack.push(1);
                    break;
                case R.id.button9:
                    tv.append("9");
                    stack.push(1);
                    break;
                case R.id.buttonAC:
                case R.id.buttonAC2:
                    tv.setText("");
                    stack.empty();
                    parentheses = 0;
                    break;
                case R.id.buttonC:
                case R.id.buttonC2:
                    if(!tv.getText().toString().isEmpty()) {
                        String str = tv.getText().toString();
                        String substr = str.subSequence(str.length() - stack.peek(), str.length()).toString();
                        if (substr.contains(")")) parentheses++;
                        if (substr.contains("(")) parentheses--;
                        if (!tv.getText().toString().isEmpty())
                            tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    break;
                case R.id.buttondot:
                    if(stack.peek() == 1 && !dot){ //prevent double dot in a number
                        tv.append(" . ");
                        dot = true;
                        stack.push(3);
                    }
                    break;
                case R.id.buttonplusorminus:
                    if(tv.getText().toString().isEmpty() ||(stack.peek() > 1)){
                        tv.append("-");
                        stack.push(1);
                    }
                    break;
                case R.id.buttondivision:
                    dot = false;
                    if(tv.getText().toString().endsWith(" . ") || tv.getText().toString().endsWith(" / ") || tv.getText().toString().endsWith(" - ") || tv.getText().toString().endsWith(" x ") || tv.getText().toString().endsWith(" + ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if(!tv.getText().toString().endsWith(" ) ")) {
                            if (stack.peek() < 2 && !tv.getText().toString().endsWith("-")) {
                                tv.append(" / ");
                                stack.push(3);
                            }
                        }
                        else{
                            tv.append("/ ");
                            stack.push(2);
                        }

                    }
                    break;
                case R.id.buttonmul:
                    dot = false;
                    if(tv.getText().toString().endsWith(" . ") || tv.getText().toString().endsWith(" / ") || tv.getText().toString().endsWith(" - ") || tv.getText().toString().endsWith(" x ") || tv.getText().toString().endsWith(" + ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if(!tv.getText().toString().endsWith(" ) ")) {
                            if (stack.peek() < 2 && !tv.getText().toString().endsWith("-")) {
                                tv.append(" x ");
                                stack.push(3);
                            }
                        }
                        else{
                            tv.append("x ");
                            stack.push(2);
                        }
                    }
                    break;
                case R.id.buttonminus:
                    dot = false;
                    if(tv.getText().toString().endsWith(" . ") || tv.getText().toString().endsWith(" / ") || tv.getText().toString().endsWith(" - ") || tv.getText().toString().endsWith(" x ") || tv.getText().toString().endsWith(" + ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if(!tv.getText().toString().endsWith(" ) ")) {
                            if (stack.peek() < 2 && !tv.getText().toString().endsWith("-")) {
                                tv.append(" - ");
                                stack.push(3);
                            }
                        }
                        else{
                            tv.append("- ");
                            stack.push(2);
                        }
                    }
                    break;
                case R.id.buttonplus:
                    dot = false;
                    if(tv.getText().toString().endsWith(" . ") || tv.getText().toString().endsWith(" / ") || tv.getText().toString().endsWith(" - ") || tv.getText().toString().endsWith(" x ") || tv.getText().toString().endsWith(" + ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if(!tv.getText().toString().endsWith(" ) ")) {
                            if (stack.peek() < 2 && !tv.getText().toString().endsWith("-")) {
                                tv.append(" + ");
                                stack.push(3);
                            }
                        }
                        else{
                            tv.append("+ ");
                            stack.push(2);
                        }
                    }
                    break;
                case R.id.buttonlog:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x log( ");
                            stack.push(8);
                        }
                        else{
                            tv.append("log( ");
                            stack.push(5);
                        }
                    }
                    else{
                        tv.append("log( ");
                        stack.push(5);
                    }
                    break;
                case R.id.buttonln:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x ln( ");
                            stack.push(7);
                        }
                        else{
                            tv.append("ln( ");
                            stack.push(4);
                        }
                    }
                    else{
                        tv.append("ln( ");
                        stack.push(4);
                    }
                    break;
                case R.id.buttonlp:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x ( ");
                            stack.push(5);
                        }
                        else{
                            tv.append("( ");
                            stack.push(2);
                        }
                    }
                    else{
                        tv.append("( ");
                        stack.push(2);
                    }
                    break;
                case R.id.buttonrp:
                    if(parentheses > 0) {

                        if (tv.getText().toString().endsWith(" . ")) {
                            tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                        }
                        if (!tv.getText().toString().isEmpty()) {
                            if ((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")) {

                                parentheses--;
                                tv.append(" ) ");
                                stack.push(3);
                            }
                        }
                    }
                    break;
                case R.id.buttonsin:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x sin( ");
                            stack.push(8);
                        }
                        else{
                            tv.append("sin( ");
                            stack.push(5);
                        }
                    }
                    else{
                        tv.append("sin( ");
                        stack.push(5);
                    }
                    break;
                case R.id.buttonarcsin:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x Arcsin( ");
                            stack.push(11);
                        }
                        else{
                            tv.append("Arcsin( ");
                            stack.push(8);
                        }
                    }
                    else{
                        tv.append("Arcsin( ");
                        stack.push(8);
                    }
                    break;
                case R.id.buttoncos:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x cos( ");
                            stack.push(8);
                        }
                        else{
                            tv.append("cos( ");
                            stack.push(5);
                        }
                    }
                    else{
                        tv.append("cos( ");
                        stack.push(5);
                    }
                    break;
                case R.id.buttonarccos:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x Arccos( ");
                            stack.push(11);
                        }
                        else{
                            tv.append("Arccos( ");
                            stack.push(8);
                        }
                    }
                    else{
                        tv.append("Arccos( ");
                        stack.push(8);
                    }
                    break;
                case R.id.buttontan:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x tan( ");
                            stack.push(8);
                        }
                        else{
                            tv.append("tan( ");
                            stack.push(5);
                        }
                    }
                    else{
                        tv.append("tan( ");
                        stack.push(5);
                    }
                    break;
                case R.id.buttonarctan:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x Arctan( ");
                            stack.push(11);
                        }
                        else{
                            tv.append("Arctan( ");
                            stack.push(8);
                        }
                    }
                    else{
                        tv.append("Arctan( ");
                        stack.push(8);
                    }
                    break;
                case R.id.buttonsquareroot:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x √( ");
                            stack.push(6);
                        }
                        else{
                            tv.append("√( ");
                            stack.push(3);
                        }
                    }
                    else{
                        tv.append("√( ");
                        stack.push(3);
                    }
                    break;
                case R.id.buttonexponent:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append("^( ");
                            stack.push(3);
                        }
                    }
                    break;
                case R.id.buttoneexp:
                    dot = false;
                    parentheses++;
                    if(tv.getText().toString().endsWith(" . ")) {
                        tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - (stack.pop())));
                    }
                    if(!tv.getText().toString().isEmpty()){
                        if((stack.peek() == 1 && !tv.getText().toString().endsWith("-")) || tv.getText().toString().endsWith(" ) ")){
                            tv.append(" x exp( ");
                            stack.push(8);
                        }
                        else{
                            tv.append("exp( ");
                            stack.push(5);
                        }
                    }
                    else{
                        tv.append("exp( ");
                        stack.push(5);
                    }
                    break;
                case R.id.buttonequal:
                    if(parentheses>0){
                        System.out.println("Not enough right parentheses");
                    }
                    else {
                        String formula = tv.getText().toString();
                        formula = formula.replace("√(", "sqrt (");
                        formula = formula.replace("-sqrt", "- sqrt");
                        formula = formula.replace("exp(", "exp (");
                        formula = formula.replace("-exp", "- exp");
                        formula = formula.replace("sin(", "sin (");
                        formula = formula.replace("-sin", "- sin");
                        formula = formula.replace("cos(", "cos (");
                        formula = formula.replace("-cos", "- cos");
                        formula = formula.replace("tan(", "tan (");
                        formula = formula.replace("-tan", "- tan");
                        formula = formula.replace("Arcsin(", "Arcsin (");
                        formula = formula.replace("-Arcsin", "- Arcsin");
                        formula = formula.replace("Arccos(", "Arccos (");
                        formula = formula.replace("-Arccos", "- Arccos");
                        formula = formula.replace("Arctan(", "Arctan (");
                        formula = formula.replace("-Arctan", "- Arctan");
                        formula = formula.replace("^(", "^ (");
                        formula = formula.replace("log(", "log (");
                        formula = formula.replace("-log", "- log");
                        formula = formula.replace("ln(", "ln (");
                        formula = formula.replace("-ln", "- ln");
                        formula = formula.replace("- -","+");
                        System.out.println(formula);
                        try {
                            String result = String.valueOf(new ReversePolishNotationEvaluator(new ShuntingJardAlgorithm(formula).evaluate()).evaluate());
                            tv.setText("");
                            tv.append(result);
                            stack.empty();
                            stack.push(result.length());
                            parentheses = 0;
                        } catch (NoSuchElementException e) {
                            System.out.println("Syntax error!");
                        }
                    }
                    break;
                default:
                    break;
            }


        }
    };
    private void repopulateLayout(int mode){

        if(mode == 0){
            mainll.removeView(ll6);
            mainll.removeView(ll7);
            mainll.removeView(ll8);
            mainll.removeView(ll9);
            mainll.removeView(ll10);
            mainll.addView(ll1);
            mainll.addView(ll2);
            mainll.addView(ll3);
            mainll.addView(ll4);
            mainll.addView(ll5);
        }
        else{
            mainll.removeView(ll1);
            mainll.removeView(ll2);
            mainll.removeView(ll3);
            mainll.removeView(ll4);
            mainll.removeView(ll5);
            mainll.addView(ll6);
            mainll.addView(ll7);
            mainll.addView(ll8);
            mainll.addView(ll9);
            mainll.addView(ll10);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
