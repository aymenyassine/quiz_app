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

public class Quiz2 extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button btnNext;
    int score;
    String CorrectResp = "Tokyo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rg = findViewById(R.id.rg_answers);
        btnNext = findViewById(R.id.btn_next_question);
        Intent i1 = getIntent();
        score = i1.getIntExtra("score", 0);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(Quiz2.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                }else {
                    rb = findViewById(rg.getCheckedRadioButtonId());
                    if (rb.getText().toString().equals(CorrectResp)) {
                        score++;
                    }
                    Intent i2 = new Intent(getApplicationContext(), Quiz3.class);
                    i2.putExtra("score", score);
                    startActivity(i2);
                    finish();
                    overridePendingTransition(R.anim.exit, R.anim.entry);
                }
            }
        });
    }
}