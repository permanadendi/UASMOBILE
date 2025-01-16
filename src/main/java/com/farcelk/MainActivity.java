package com.farcelk;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etSuhu;
    Spinner Opsi;
    Button btnKonversi, btnHapus;
    LinearLayout layoutHasil;
    TextView tvhasilHitung, tvhasilKonversi, tvRumus, tvRumusnya;
    private String Pilihan[] = {"-Konversi Option-", "\u00B0Celcius to Kelvin", "\u00B0Celcius to \u00B0Fahrenheit", "\u00B0Celcius to \u00B0Reamur", "Kelvin to \u00B0Celcius",
            "Kelvin to \u00B0Fahrenheit", "Kelvin to \u00B0Reamur", "\u00B0Fahrenheit to Celcius", "\u00B0Fahrenheit to Kelvin", "\u00B0Fahrenheit to Reamur",
            "\u00B0Reamur to \u00B0Celcius", "\u00B0Reamur to Kelvin", "\u00B0Reamur to \u00B0Fahrenheit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSuhu = findViewById(R.id.etSuhu);
        Opsi = findViewById(R.id.Opsi);
        btnKonversi = findViewById(R.id.btnKonversi);
        btnHapus = findViewById(R.id.btnHapus);
        layoutHasil = findViewById(R.id.layoutHasil);
        tvhasilHitung = findViewById(R.id.tvhasilHitung);
        tvhasilKonversi = findViewById(R.id.tvhasilKonversi);
        tvRumus = findViewById(R.id.tvRumus);
        tvRumusnya = findViewById(R.id.tvRumusnya);

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                Pilihan
        );

        Opsi.setAdapter(adapter);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSuhu.setText("");
                tvhasilKonversi.setText("");
                tvhasilHitung.setText("");
                tvRumusnya.setText("");
                tvRumus.setText("");

                if(layoutHasil.getVisibility() == View.VISIBLE){
                    layoutHasil.setVisibility(View.GONE);
                }
            }
        });

        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getSuhu = etSuhu.getText().toString();

                if(getSuhu.isEmpty()){
                    Toast.makeText(MainActivity.this, "Suhu Awal Masih Kosong!",Toast.LENGTH_SHORT).show();
                }else{
                    if(layoutHasil.getVisibility() == View.GONE){
                        layoutHasil.setVisibility(View.VISIBLE);
                    }

                    double suhu = Double.valueOf(etSuhu.getText().toString());
                    double hasil;
                    String rumus, rumus1;
                    int Spinner = Opsi.getSelectedItemPosition();
                    switch (Spinner){
                        case 0 :
                            if(layoutHasil.getVisibility() == View.VISIBLE){
                                layoutHasil.setVisibility(View.GONE);
                            }
                            Toast.makeText(MainActivity.this, "Silahkan Pilih Opsi konversi!!",Toast.LENGTH_SHORT).show();
                            break;
                        case 1 ://°Celcius to Kelvin
                            hasil = suhu + 273;
                            rumus = "°Celcius + 273";
                            rumus1 = suhu+" + 273";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 2 ://°Celcius to °Fahrenheit
                            hasil = 9.0/5.0 * suhu + 32;
                            rumus = "9.0/5.0 * Celcius + 32";
                            rumus1 = "9.0/5.0 * "+suhu+" + 32";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 3 ://°Celcius to °Reamur
                            hasil = 4.0/5.0 * suhu;
                            rumus = "4.0/5.0 * \u00B0Celcius";
                            rumus1 = "4.0/5.0 * " + suhu;
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 4 ://Kelvin to °Celcius
                            hasil = suhu - 273;
                            rumus = "Kelvin - 273";
                            rumus1 = suhu+" - 273";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 5 ://Kelvin to °Fahrenheit
                            hasil = 9.0/5.0 * (suhu - 273) + 32;
                            rumus = "9.0/5.0 * (Kelvin - 273) + 32";
                            rumus1 = "9.0/5.0 * (" +suhu+" - 273) + 32";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 6 ://Kelvin to °Reamur
                            hasil = 4.0/5.0 * (suhu - 273);
                            rumus = "4.0/5.0 * (Kelvin - 273)";
                            rumus1 = "4.0/5.0 * ("+suhu+" - 273)";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 7 ://°Fahrenheit to Celcius
                            hasil = 5.0/9.0 * (suhu - 32);
                            rumus = "5.0/9.0 * (\u00B0Fahrenheit - 32)";
                            rumus1 = "5.0/9.0 * ("+suhu+" - 32)";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 8 ://°Fahrenheit to Kelvin
                            hasil = 5.0/9.0 * (suhu - 32) + 273;
                            rumus = "5.0/9.0 * (\u00B0Fahrenheit - 32) + 273";
                            rumus1 = "5.0/9.0 * ("+suhu+" - 32) + 273";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 9 ://°Fahrenheit to Reamur
                            hasil = 4.0/9.0 * (suhu - 32);
                            rumus = "4.0/9.0 * (\u00B0Fahrenheit - 32)";
                            rumus1 = "4.0/9.0 * ("+suhu+" - 32)";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 10 ://°Reamur to °Celcius
                            hasil = 5.0/4.0 * suhu;
                            rumus = "5.0/4.0 * \u00B0Reamur";
                            rumus1 = "5.0/4.0 * " + suhu;
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 11 ://°Reamur to Kelvin
                            hasil = 5.0/4.0 * suhu + 273;
                            rumus = "5.0/4.0 * \u00B0Reamur + 273";
                            rumus1 = "5.0/4.0 * "+ suhu+" + 273";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 12 ://°Reamur to °Fahrenheit
                            hasil = (9.0/4.0 * suhu) + 32;
                            rumus = "(9.0/4.0 * \u00B0Reamur) + 32";
                            rumus1 = "(9.0/4.0 * "+ suhu+") + 32";
                            tvhasilKonversi.setText("Hasil Konversi = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                }


                }
            }
        });
    }
}