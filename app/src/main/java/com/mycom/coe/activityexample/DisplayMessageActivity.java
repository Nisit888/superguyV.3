package com.mycom.coe.activityexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {

    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        tvDisplay = (TextView) findViewById(R.id.tvDisplay);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        System.out.println( bundle.getInt("value")   );
        System.out.println( bundle.getBoolean("isTrue",false)   );
        System.out.println( bundle.getString("message") );

        MyData myData = getIntent().getParcelableExtra("MyData");
        System.out.println("x: " + myData.x + "  y = " + myData.y );

//        int value = intent.getIntExtra("value",0);
//        boolean isTrue = intent.getBooleanExtra("isTrue",true);
//        Toast.makeText(this, Integer.toString(value) , Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "" + isTrue , Toast.LENGTH_SHORT).show();
//        tvDisplay.setText( intent.getStringExtra("message") );


    }
}
