package com.example.day03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // deklarasi Button
    Button btnIntent, btnProfile, btnImplisit;
    TextView tvNamaLain;

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

        btnIntent = findViewById(R.id.btnIntent);
        btnProfile = findViewById(R.id.btnProfile);
        btnImplisit = findViewById(R.id.btnImplisit);
        tvNamaLain = findViewById(R.id.tvNamaLain);

        // di klik
        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLayout = new Intent(MainActivity.this, intentLayout.class);
                startActivity(intentLayout);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfil = new Intent(MainActivity.this, Profile.class);
                // dapatkan data nama ujang
                String anotherName = tvNamaLain.getText().toString();
                // kirim data
                intentProfil.putExtra(Profile.EXTRA_TITLE, "Profil");
                intentProfil.putExtra(Profile.EXTRA_NAMA, anotherName);
                intentProfil.putExtra(Profile.EXTRA_UMUR, "18 tahun");
                intentProfil.putExtra(Profile.EXTRA_ALAMAT, "pekanbaru");

                startActivity(intentProfil);
            }
        });

        btnImplisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentImplisit = new Intent();
                intentImplisit.setAction(Intent.ACTION_SEND);
                intentImplisit.putExtra(Intent.EXTRA_TEXT, "Belajar android intent");
                intentImplisit.setType("plain/text");

                if (intentImplisit.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentImplisit);
                }
            }
        });

    }
}