package com.ferrysaptawan.biodatamahasiswa;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Biodata extends AppCompatActivity {
    private DBHelper dbHelper;
    private TextView textViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        dbHelper = new DBHelper(this);
        textViewData = findViewById(R.id.textViewData);

        Cursor res = dbHelper.tampildata();
        if (res.getCount() == 0) {
            Toast.makeText(Biodata.this, "Tidak Ada Data", Toast.LENGTH_SHORT).show();
        } else {
            StringBuilder data = new StringBuilder();
            while (res.moveToNext()) {
                String nim = res.getString(0);
                String nama = res.getString(1);
                String jeniskelamin = res.getString(2);
                String alamat = res.getString(3);
                String email = res.getString(4);

                data.append("NIM Mahasiswa: ").append(nim).append("\n");
                data.append("Nama Mahasiswa: ").append(nama).append("\n");
                data.append("Jenis Kelamin: ").append(jeniskelamin).append("\n");
                data.append("Alamat: ").append(alamat).append("\n");
                data.append("Email: ").append(email).append("\n\n");
            }
            textViewData.setText(data.toString());
        }

        res.close();
    }
}
