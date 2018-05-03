package com.koriah.study_kasus_yayu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class kirimpesan extends AppCompatActivity {
    TextView NamaPemesan, Jenistenda, Tanggal, Waktu, Alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirimpesan);

        NamaPemesan = (TextView) findViewById(R.id.teks5);
        Tanggal = (TextView) findViewById(R.id.teks9);
        Waktu = (TextView) findViewById(R.id.teks10);
        Alamat = (TextView) findViewById(R.id.teks6);

        NamaPemesan.setText("Nama Pemesan : "+ getIntent().getStringExtra("namapemesan"));
        Jenistenda.setText("Jenis Tenda : " + getIntent().getStringExtra("jenistenda"));
        Tanggal.setText("Tanggal : " + getIntent().getStringExtra("tanggal"));
        Waktu.setText("waktu : " + getIntent().getStringExtra("waktu"));
        Alamat.setText("alamat : " + getIntent().getStringExtra("alamat"));

        Button tutup = (Button) findViewById(R.id.btn7);
        tutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

    }
}
