package com.example.application_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class score extends AppCompatActivity {

    TextView tvScore;
    ProgressBar pbScore;
    Button btnTryAgain, btnExit;

    FirebaseAuth firebase;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvScore = findViewById(R.id.tvScore);
        pbScore = findViewById(R.id.progressBar2);
        btnTryAgain = findViewById(R.id.btnTryAgain);
        btnExit = findViewById(R.id.btnExit);
        firebase = FirebaseAuth.getInstance();
        Intent i1 = getIntent();
        score = i1.getIntExtra("score", 0);

        tvScore.setText(100*score/5 + "%");
        pbScore.setProgress(100*score/5 );
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(score.this, "Merci pour votre participation", Toast.LENGTH_SHORT).show();
                firebase.signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Quiz1.class));
            }
        });

    }
}   