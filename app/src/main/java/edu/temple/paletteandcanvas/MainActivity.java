package edu.temple.paletteandcanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

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

public class MainActivity extends AppCompatActivity implements PaletteFragment.OnColorSelectedListener{


    public void onColorSelected(String colorString)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container2, CanvasFragment.newInstance(colorString))
                .commit();
    }

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
        PaletteFragment paletteFragment = PaletteFragment.newInstance(colorsLocal,colors);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container1, paletteFragment)
                .commit();
    }
}
