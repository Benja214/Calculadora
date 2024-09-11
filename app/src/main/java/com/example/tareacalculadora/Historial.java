package com.example.tareacalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Historial extends AppCompatActivity {

    private ListView listViewHistorial;
    private ArrayAdapter<String> adapter;
    private List<String> historial;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listViewHistorial= findViewById(R.id.listView);
        btnVolver= findViewById(R.id.btnVolver);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("historial")){
            historial = intent.getStringArrayListExtra("historial");
            Log.d("listadoActivity","historial recibido: "+ historial.toString());
        }else {
            historial= new ArrayList<>();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, historial);
        listViewHistorial.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Historial.this, com.example.tareacalculadora.MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
