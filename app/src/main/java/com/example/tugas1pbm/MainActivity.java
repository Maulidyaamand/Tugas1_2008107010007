package com.example.tugas1pbm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNama;
    private EditText editTextNPM;
    private EditText editTextJurusan;
    private Button buttonSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNama = findViewById(R.id.editTextNama);
        editTextNPM = findViewById(R.id.editTextNPM);
        editTextJurusan = findViewById(R.id.editTextJurusan);
        buttonSimpan = findViewById(R.id.buttonSimpan);

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editTextNama.getText().toString();
                String npm = editTextNPM.getText().toString();
                String jurusan = editTextJurusan.getText().toString();

                saveToStringsXML(nama, npm, jurusan);
                Toast.makeText(MainActivity.this, "Data tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveToStringsXML(String nama, String npm, String jurusan) {
        String stringsXMLContent = "<resources>\n" +
                "    <string name=\"nama\">" + nama + "</string>\n" +
                "    <string name=\"npm\">" + npm + "</string>\n" +
                "    <string name=\"jurusan\">" + jurusan + "</string>\n" +
                "</resources>";

        String stringsXMLPath = getResources().getString(R.string.config_strings_file_path);
        FileHelper.saveToFile(this, stringsXMLContent, stringsXMLPath);
    }
}
