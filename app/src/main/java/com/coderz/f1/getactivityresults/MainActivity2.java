package com.coderz.f1.getactivityresults;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.coderz.f1.getactivityresults.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private Button buttonDone;
    private EditText edittextName;
    private EditText edittextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initWidgets();
    }

    private void initWidgets(){
      buttonDone = findViewById(R.id.button_return);
      edittextName = findViewById(R.id.edittext_name);
      edittextEmail = findViewById(R.id.edittext_email);
      buttonDone.setOnClickListener(buttonDoneListener);
    }

    private View.OnClickListener buttonDoneListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("name", edittextName.getText().toString());
            intent.putExtra("email",edittextEmail.getText().toString());
            setResult(101,intent);
            finish();
        }
    };

}