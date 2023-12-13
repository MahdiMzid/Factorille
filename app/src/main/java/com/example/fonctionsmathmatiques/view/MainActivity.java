package com.example.fonctionsmathmatiques.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fonctionsmathmatiques.R;
import com.example.fonctionsmathmatiques.controller.Controller;


public class MainActivity extends AppCompatActivity {

    private EditText etNumber;
    private Button btnCalculer;

    private final int REQUEST_CODE = 1;

    private Controller controller = Controller.getInstance() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnCalculer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int number = 0;
                boolean verif = false;

                if (!etNumber.getText().toString().isEmpty())
                    number = Integer.parseInt(etNumber.getText().toString());
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir le nombre à calculer !", Toast.LENGTH_SHORT).show();

                if (number < 0)
                    Toast.makeText(MainActivity.this, "La factorielle n'est pas définie pour les nombres négatifs", Toast.LENGTH_LONG).show();
                else
                    verif = true;

                if (verif) {

                    // Livraison de la valeur saisie par l'utilisateur au Model pour le calcule du résultat
                    controller.initFact(number);
                    int result = controller.getResult();
                    // Intent avec retour : cette Intent prend comme extra la valeur saisie et son factorielle pour les afficher dans l’activité ResultActivity
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("number", number);
                    intent.putExtra("result", result);
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE)
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "ERROR : RESULT_CANCELED", Toast.LENGTH_SHORT).show();
            }
    }

    private void init() {
        etNumber = (EditText) findViewById(R.id.etNumber);
        btnCalculer = (Button) findViewById(R.id.btnCalculer);
        // initialisation du Controlleur
    }
}