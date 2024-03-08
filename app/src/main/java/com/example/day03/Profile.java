package com.example.day03;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profile extends AppCompatActivity {

    // deklarasi
    TextView tvTitle, tvNama, tvUmur, tvAlamat;

    public static String EXTRA_TITLE = "extra_title";
    public static String EXTRA_NAMA = "extra_nama";
    public static String EXTRA_UMUR = "extra_umur";
    public static String EXTRA_ALAMAT = "extra_alamat";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvTitle = findViewById(R.id.tvTitle);
        tvNama = findViewById(R.id.tvNama);
        tvUmur = findViewById(R.id.tvUmur);
        tvAlamat = findViewById(R.id.tvAlamat);

        tvTitle.setText(getIntent().getStringExtra(EXTRA_TITLE));
        tvNama.setText(getIntent().getStringExtra(EXTRA_NAMA));
        tvUmur.setText(getIntent().getStringExtra(EXTRA_UMUR));
        tvAlamat.setText(getIntent().getStringExtra(EXTRA_ALAMAT));

    }
}