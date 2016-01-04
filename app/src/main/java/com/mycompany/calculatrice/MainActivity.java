package com.mycompany.calculatrice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);

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

        Button buttonrootsquare = (Button) findViewById(R.id.buttonrootsquare);
        buttonrootsquare.setOnClickListener(myButtonListener);

        Button buttonexposant = (Button) findViewById(R.id.buttonexposant);
        buttonexposant.setOnClickListener(myButtonListener);

        Button buttoncos = (Button) findViewById(R.id.buttoncos);
        buttoncos.setOnClickListener(myButtonListener);

        Button buttonhex = (Button) findViewById(R.id.buttonhex);
        buttonhex.setOnClickListener(myButtonListener);

        Button buttonmul10exposant = (Button) findViewById(R.id.buttonmul10exposant);
        buttonmul10exposant.setOnClickListener(myButtonListener);

        Button buttoneexp = (Button) findViewById(R.id.buttoneexp);
        buttoneexp.setOnClickListener(myButtonListener);

        Button buttontan = (Button) findViewById(R.id.buttontan);
        buttontan.setOnClickListener(myButtonListener);

        Button buttonbin = (Button) findViewById(R.id.buttonbin);
        buttonbin.setOnClickListener(myButtonListener);

        Button buttonsinminus1 = (Button) findViewById(R.id.buttonsinminus1);
        buttonsinminus1.setOnClickListener(myButtonListener);

        Button buttoncosminus1 = (Button) findViewById(R.id.buttoncosminus1);
        buttoncosminus1.setOnClickListener(myButtonListener);

        Button buttontanminus1 = (Button) findViewById(R.id.buttontanminus1);
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
                    tv.append("0 ");
                    break;
                case R.id.button1:
                    tv.append("1 ");
                    break;
                case R.id.button2:
                    tv.append("2 ");
                    break;
                case R.id.button3:
                    tv.append("3 ");
                    break;
                case R.id.button4:
                    tv.append("4 ");
                    break;
                case R.id.button5:
                    tv.append("5 ");
                    break;
                case R.id.button6:
                    tv.append("6 ");
                    break;
                case R.id.button7:
                    tv.append("7 ");
                    break;
                case R.id.button8:
                    tv.append("8 ");
                    break;
                case R.id.button9:
                    tv.append("9 ");
                    break;
                case R.id.buttonAC:
                    tv.setText("");
                    break;
                case R.id.buttonAC2:
                    tv.setText("");
                    break;
                case R.id.buttonC:
                    if(!tv.getText().toString().isEmpty()) tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - 2));
                    break;
                case R.id.buttonC2:
                    if(!tv.getText().toString().isEmpty()) tv.setText(tv.getText().toString().subSequence(0, tv.getText().toString().length() - 2));
                    break;
                case R.id.buttondot:
                    tv.append(". ");
                    break;
                case R.id.buttonpercent:
                    break;
                case R.id.buttondivision:
                    tv.append("/ ");
                    break;
                case R.id.buttonmul:
                    tv.append("x ");
                    break;
                case R.id.buttonminus:
                    tv.append("- ");
                    break;
                case R.id.buttonplus:
                    tv.append("+ ");
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
