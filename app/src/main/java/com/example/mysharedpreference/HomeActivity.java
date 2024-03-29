package com.example.mysharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView textView_name,textView_email;
    Button button_logout;
    SharedPreferences sharePreferences;
    private static final String SHARED_PREF_NAME ="mypref";
    private static final String KEY_NAME ="name";
    private static final String KEY_EMAIL ="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView_name = findViewById(R.id.text_name);
        textView_email = findViewById(R.id.text_email);
        button_logout = findViewById(R.id.button_logout);

        sharePreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharePreferences.getString(KEY_NAME,null);
        String email = sharePreferences.getString(KEY_EMAIL,null);

        if(name != null || email != null){
            //So set the data on texView
            textView_name.setText("Full Name - "+name);
            textView_email.setText("Email ID - "+email);
        }

        //So call to button for Log out Session
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharePreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this,"Log out successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}