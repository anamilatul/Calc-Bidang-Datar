package me.anamila.kalkulatorbdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtFirst, edtSecond;
    Button btnPersegi, btnSegitiga, btnLingkaran;
    TextView tvluas, tvkeliling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFirst = findViewById(R.id.editFirst);
        edtSecond = findViewById(R.id.editSecond);
        btnPersegi = findViewById(R.id.buttonPersegi);
        btnSegitiga = findViewById(R.id.buttonSegitiga);
        btnLingkaran = findViewById(R.id.buttonLingkaran);
        tvluas = findViewById(R.id.luas);
        tvkeliling = findViewById(R.id.keliling);

        btnPersegi.setOnClickListener(this);
        btnSegitiga.setOnClickListener(this);
        btnLingkaran.setOnClickListener(this);
    }

    @Override


    public void onClick(View view){
        switch(view.getId()){
            case R.id.buttonPersegi:
                persegi();
                break;
            case R.id.buttonSegitiga:
                Segitiga();
                break;
            case R.id.buttonLingkaran:
                lingkaran();
                break;
        }
    }
    private void persegi(){

        if(edtFirst.getText().toString().trim().isEmpty() || edtSecond.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Data Masih Ada yang Kosong!",Toast.LENGTH_SHORT).show();
        }
        else{
            float angka1, angka2, luas,keliling;
            angka1 = Float.parseFloat(String.valueOf(edtFirst.getText()));
            angka2 = Float.parseFloat(String.valueOf(edtSecond.getText()));
            luas = angka1 * angka2;
            keliling = 2 * angka1 + 2 * angka2;
            tvluas.setText("Luas Persegi : "+luas);
            tvkeliling.setText("Keliling Persegi : "+keliling);

        }
    }
    private void Segitiga(){
        if(edtFirst.getText().toString().trim().isEmpty() || edtSecond.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Data Masih Ada yang Kosong!",Toast.LENGTH_SHORT).show();
        }
        else{
            float angka1,angka2,luas2,keliling2;
            angka1 = Float.parseFloat(String.valueOf(edtFirst.getText()));
            angka2 = Float.parseFloat(String.valueOf(edtSecond.getText()));
            luas2 = (angka1 * angka2) / 2;
            keliling2 = angka1 + angka1 + angka1;
            tvluas.setText("Luas Segitiga : " + luas2);
            tvkeliling.setText("Keliling Segitiga : " + keliling2);
        }
    }
    private void lingkaran(){
        if(edtFirst.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Data Masih Ada yang Kosong!",Toast.LENGTH_SHORT).show();
        }
        else{
            double angka1,luas,keliling;
            angka1 = Double.parseDouble(String.valueOf(edtFirst.getText()));
            luas = (Double) (Math.PI * Math.pow((angka1/2), 2)); //angka1/2 karena diameter diubah ke jari-jari
            keliling = (Double) (Math.PI * ((angka1/2) * 2));
            tvluas.setText("Luas Lingkaran : " + luas);
            tvkeliling.setText("Keliling Lingkaran : " + keliling);
        }
    }
}