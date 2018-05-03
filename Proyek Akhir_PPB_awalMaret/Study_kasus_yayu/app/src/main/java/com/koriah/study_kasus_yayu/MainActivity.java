package com.koriah.study_kasus_yayu;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnwaktu, btntanggal, btnpesan;
    int mYear, mMonth, mDay, mHour, mMinute;
    EditText tekswaktu, tekstanggal, nama, alamat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnwaktu = (Button) findViewById(R.id.waktu);
        btntanggal = (Button) findViewById(R.id.tanggal);
        btnpesan = (Button) findViewById(R.id.pesan);
        nama = (EditText) findViewById(R.id.editnamapemesan);
        alamat = (EditText) findViewById(R.id.editalamat);
        tekswaktu = (EditText) findViewById(R.id.editwaktu);
        tekstanggal = (EditText) findViewById(R.id.edittanggal);

    }

public void btnwaktu(View view) {
    final Calendar c = Calendar.getInstance();
    mHour = c.get(Calendar.HOUR_OF_DAY);
    mMinute = c.get(Calendar.MINUTE);

    TimePickerDialog timePickerDialog = new TimePickerDialog(this,
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                    tekswaktu.setText(hourOfDay + ":" + minute);
                }
            }, mHour, mMinute, false);
    timePickerDialog.show();
}

    public void btntgl(View view) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        tekstanggal.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void btnpesan (View view){
        Intent intent = new Intent(this, kirimpesan.class);
        intent.putExtra("NmPemesan", nama.getText().toString());
        intent.putExtra("alamat", alamat.getText().toString());
        intent.putExtra("Waktu", tekswaktu.getText().toString());
        intent.putExtra("Tanggal", tekstanggal.getText().toString());
        intent.putExtra("Jenistenda", getIntent().getStringExtra("Jenis Tenda"));
        startActivity(intent);
        finish();
    }
}