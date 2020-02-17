package edu.temple.paletteandcanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] colors = getResources().getStringArray(R.array.colors);
        ColorAdapter colorAdapter = new ColorAdapter(this,colors);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(colorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0)
                    findViewById(R.id.layout).setBackgroundColor(Color.parseColor(colors[position]));
                else
                    findViewById(R.id.layout).setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                findViewById(R.id.layout).setBackgroundColor(Color.WHITE);
            }
        });
    }
}
