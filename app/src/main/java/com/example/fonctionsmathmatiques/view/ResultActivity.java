package com.example.fonctionsmathmatiques.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fonctionsmathmatiques.R;


public class ResultActivity extends AppCompatActivity {

    private TextView tvFactorielle;
    private Button btnReturn;
    private long factorielle;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();


        // Récupérer la valeur saisie et son factorielle et les afficher dans le TextView TvFactorielle.
        tvFactorielle.setText("Factorielle de "+getIntent().getIntExtra("number",0)+" est : "+getIntent().getIntExtra("result",0));

        btnReturn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(ResultActivity.this, MainActivity.class);
               startActivity(intent);
               finish();
            }
        });
    }

    private void init()
    {
        tvFactorielle = (TextView) findViewById(R.id.tvFactorielle);
        btnReturn = (Button) findViewById(R.id.btnReturn);
    }
}