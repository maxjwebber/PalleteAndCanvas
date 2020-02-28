package edu.temple.paletteandcanvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        String myColor = getIntent().getStringExtra("myColor");
        String myLabel = getIntent().getStringExtra("myLabel");
        findViewById(R.id.layout2).setBackgroundColor(Color.parseColor(myColor));
        TextView colorDisplay = findViewById(R.id.colorDisplay);
        colorDisplay.setText(myLabel);

    }
}
