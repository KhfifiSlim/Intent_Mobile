package com.dev_mobile.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;

import com.google.type.DateTime;

public class MainActivity extends AppCompatActivity {
EditText var;
Button button,btn2,btn3;
private CharSequence DateTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        var=findViewById(R.id.a);
        button=findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( getApplicationContext(),MainActivity2.class);
                i.putExtra("valeur",var.getText().toString());
                startActivity(i);





            }


        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent( getApplicationContext(),MainActivity3.class);

                startActivity(j);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, DateTime);
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, DateTime);
                intent.putExtra(CalendarContract.Events.ALL_DAY, false);
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Descripttion");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location");
                startActivity(Intent.createChooser(intent, "Add to calendar"));
            }
        });


    }
}