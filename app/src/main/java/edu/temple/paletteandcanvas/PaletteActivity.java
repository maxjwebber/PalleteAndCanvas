package edu.temple.paletteandcanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;
        final String[] colors = getResources().getStringArray(R.array.colors);
        ColorAdapter colorAdapter = new ColorAdapter(this,colors);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(colorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0) {
                    Intent intent = new Intent(context, CanvasActivity.class);
                    intent.putExtra("myColor",colors[position]);
                    context.startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }
}
