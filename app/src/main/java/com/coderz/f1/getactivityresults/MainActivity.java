package com.coderz.f1.getactivityresults;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonGrab;
    TextView textviewReturnedText;

    ActivityResultLauncher<Intent> grabValues = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == 101) {
                String name = result.getData().getStringExtra("name");
                String email = result.getData().getStringExtra("email");
                textviewReturnedText.setText(name + "\n" + email);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
    }

    private void initWidgets(){
      buttonGrab = findViewById(R.id.button_grab);
      textviewReturnedText = findViewById(R.id.textview_returned_text);
      buttonGrab.setOnClickListener(buttonGrabListener);
    }

    private View.OnClickListener buttonGrabListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(),MainActivity2.class);
            grabValues.launch(intent);
        }
    };
}