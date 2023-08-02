package com.example.mysharedpreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText editText_name,editText_email;
    Button button_save;
    SharedPreferences sharePreferences;
    //So Create a shared preferences name and also create key name

    private static final String SHARED_PREF_NAME ="mypref";
    private static final String KEY_NAME ="name";
    private static final String KEY_EMAIL ="email";
    @Override
    protected void onCreate(Bundle saveInstanceSate){
        super.onCreate(saveInstanceSate);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.editText_name);
        editText_email = findViewById(R.id.editText_email);
        button_save = findViewById(R.id.button_save);

        sharePreferences = getSharedPreferences("",MODE_PRIVATE);
        //when open activity first check shared preferences data avialble or not

        String name = sharePreferences.getString(KEY_NAME,null);

        if(name != null){
            //if data avialble so directly call on HomeActivity...
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///when  click a button put data on Shared preferences..
                SharedPreferences.Editor editor = sharePreferences.edit();
                editor.putString(KEY_NAME,editText_name.getText().toString());
                editor.putString(KEY_EMAIL,editText_email.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"Login Success", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
