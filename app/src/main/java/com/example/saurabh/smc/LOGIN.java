package com.example.saurabh.smc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Saurabh on 5/25/2016.
 */
public class LOGIN extends AppCompatActivity {
    Button signin;
    boolean buttonpress = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        signin = (Button) findViewById(R.id.signin_button);
        signin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                    buttonpress = true;

                    Intent openH = new Intent(LOGIN.this, HOMEPAGE.class);
                    startActivity(openH);

            }
        });

    }

    @Override
    protected void onPause(){
        super.onPause();

        if(buttonpress == true){
            finish();
        }

    }

}
