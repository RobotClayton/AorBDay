package me.beckerlethcoe.aorbday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    Date myDate;
    Calendar cal;
    EditText et1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = Calendar.getInstance();
        et1 = (EditText) findViewById(R.id.editText);
        tv1 = (TextView) findViewById(R.id.textView);
    }

    public void updateTV(View view){

        try {
            myDate = df.parse(et1.getText().toString());
            //String myText = myDate.getDate() + "-" + (myDate.getMonth() + 1) + "-" + (1900 + myDate.getYear());
            //Log.i(TAG, myText);
        } catch (ParseException e) {
            myDate = null;
            e.printStackTrace();
        }

        cal.setTime(myDate);

        if(checkIfSchoolDay()){
            tv1.setText(cal.getTime().toString());
        }else{
            tv1.setText("Not a school day");
        }

    }

    public boolean checkIfSchoolDay(){

        boolean isWeekend = false;
        boolean isHoliday = false;

        //weekend checker
        if(cal.getTime().equals(Calendar.SATURDAY) || cal.getTime().equals(Calendar.SUNDAY)){
            //It's the weekend :-)
            isWeekend = true;
        }else{
            isWeekend = false;
        }

        //holiday checker
        //if(cal.getTime().equals(Calendar.))

        return (!isWeekend && !isHoliday);
    }


}
