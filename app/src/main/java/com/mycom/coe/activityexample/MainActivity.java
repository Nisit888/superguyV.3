package com.mycom.coe.activityexample;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnSubmit;
    private EditText edtName;
    private Button btnNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(MainActivity.this,
                DisplayMessageActivity.class);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        edtName = (EditText) findViewById(R.id.edtName);
        btnNew = (Button) findViewById(R.id.btnNew);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(edtName.getText());
                intent.putExtra("message", str);
                intent.putExtra("isTrue", true);
                intent.putExtra("value", 5);
                intent.putExtra("MyData", new MyData());
                startActivity(intent);
            }
        });

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSubmit.setText("Change!!");
                finish();
            }
        });
    }
}

class MyData implements Parcelable {
    public int x = 1 ;
    public int y = 2;

    public MyData() {}

    protected MyData(Parcel in) {
        x = in.readInt();
        y = in.readInt();
    }

    public static final Creator<MyData> CREATOR = new Creator<MyData>() {
        @Override
        public MyData createFromParcel(Parcel in) {
            return new MyData(in);
        }

        @Override
        public MyData[] newArray(int size) {
            return new MyData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(x);
        parcel.writeInt(y);
    }
}