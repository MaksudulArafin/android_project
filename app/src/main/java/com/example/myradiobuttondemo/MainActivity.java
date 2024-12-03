package com.example.myradiobuttondemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroup;
    private RadioButton genderButton;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        button = (Button) findViewById(R.id.buttonId);
        textView= (TextView)  findViewById(R.id.textViewId);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if(selectedId == -1){
            Toast.makeText(MainActivity.this,"Select gender plz.",Toast.LENGTH_SHORT).show();
        }
        else{
            genderButton = (RadioButton) findViewById(selectedId);
            //textView.setText("Selected radio button is: "+genderButton.getText().toString());
            String value = genderButton.getText().toString();
            textView.setText("Selected radio button is: "+value);
        }

    }
}