package com.minnathon.stresskiller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    ImageButton ok;
    EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ok = (ImageButton) findViewById(R.id.ok);
        age = (EditText) findViewById(R.id.age);
        age.setInputType(InputType.TYPE_CLASS_NUMBER);

        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!isInteger(age.getText().toString())) {
                    age.setText(null);
                    Toast toast = Toast.makeText(getApplicationContext(), "You have to enter a numver\nbetween 1 and 100", Toast.LENGTH_SHORT);
                    TextView tv = (TextView) toast.getView().findViewById(android.R.id.message);
                    if( v != null) tv.setGravity(Gravity.CENTER);
                    toast.show();
                }
                else {
                    if (Integer.parseInt(age.getText().toString()) < 1 || Integer.parseInt(age.getText().toString()) > 100) {
                        age.setText(null);
                        Toast toast = Toast.makeText(getApplicationContext(), "You have to enter a numver\nbetween 1 and 100", Toast.LENGTH_SHORT);
                        TextView tv = (TextView) toast.getView().findViewById(android.R.id.message);
                        if (v != null) tv.setGravity(Gravity.CENTER);
                        toast.show();
                    }
                    else{
                        age.setText(null);
                        startActivity(new Intent(HomeActivity.this,SelectionActivity.class));
                    }
                }
            }
        });
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

}
