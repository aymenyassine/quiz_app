package com.example.application_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Quiz1 extends AppCompatActivity {

    Button btnNext;
    RadioGroup rg;
    RadioButton rb;

    String CorrectResp = "Thomas alva Edison";
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rg = findViewById(R.id.rg_answers);
        btnNext = findViewById(R.id.btn_next_question);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(Quiz1.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                }else{
                    rb = findViewById(rg.getCheckedRadioButtonId());
                    if(rb.getText().toString().equals(CorrectResp)){
                        score++;
                    }

                    Intent i1 = new Intent(getApplicationContext(), Quiz2.class);
                    i1.putExtra("score", score);
                    startActivity(i1);
                    finish();
                    overridePendingTransition(R.anim.exit, R.anim.entry);

                }
            }
        });

    }
}