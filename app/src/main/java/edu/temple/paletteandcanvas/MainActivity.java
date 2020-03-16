package edu.temple.paletteandcanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.Locale;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static java.util.Locale.ENGLISH;
import static java.util.Locale.getDefault;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;
        final String[] colorsLocal = getResources().getStringArray(R.array.colors);
        Configuration defConfig = context.getResources().getConfiguration();
        defConfig.setLocale(ENGLISH);
        final String[] colors = context.createConfigurationContext(defConfig)
                .getResources().getStringArray(R.array.colors);
        ColorAdapter colorAdapter = new ColorAdapter(this,colors,colorsLocal);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(colorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0) {
                    Intent intent = new Intent(context, CanvasActivity.class);
                    intent.putExtra("myColor",colors[position]);
                    intent.putExtra("myLabel",colorsLocal[position]);
                    context.startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }
}
