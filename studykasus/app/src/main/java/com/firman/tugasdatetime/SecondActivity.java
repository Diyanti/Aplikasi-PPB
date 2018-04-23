package com.firman.tugasdatetime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    TextView tanggal,waktu,billing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String bil = getIntent().getStringExtra("billing");
        String tgl = getIntent().getStringExtra("tanggal");
        String wkt = getIntent().getStringExtra("waktu");

        billing = (TextView) findViewById(R.id.tvBilling);
        tanggal = (TextView) findViewById(R.id.tvTanggal);
        waktu = (TextView) findViewById(R.id.tvWaktu);

        billing.setText("Billing: "+bil);
        tanggal.setText("Tanggal: "+tgl);
        waktu.setText("Waktu: "+wkt);

    }

}
