package com.example.personafusioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Compendium compendium = Compendium.getInstance();

        try {
            compendium.loadPersonas(getAssets().open(getString(R.string.PersonaListFileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}