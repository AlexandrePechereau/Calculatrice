package com.mycompany.calculatrice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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

    private Button buttonmore;
    private Button buttonmore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        buttonmore = (Button) findViewById(R.id.buttonmore);
        buttonmore.setOnClickListener(myButtonListener);

        buttonmore2 = (Button) findViewById(R.id.buttonmore2);
        buttonmore2.setOnClickListener(myButtonListener);

        mainll.removeView(ll6);
        mainll.removeView(ll7);
        mainll.removeView(ll8);
        mainll.removeView(ll9);
        mainll.removeView(ll10);

    }

    private View.OnClickListener myButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonmore:
                    repopulateLayout(1);
                    break;
                case R.id.buttonmore2:
                    repopulateLayout(0);
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
