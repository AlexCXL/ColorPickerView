package com.feican.ble.pointcolorpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.feican.ble.pointcolorpicker.colorpicker.ColorPickerView;
import com.feican.ble.pointcolorpicker.colorpicker.OnColorChangedListener;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> integers = new ArrayList<>();
    private ColorPickerView colorPickerView;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorPickerView = (ColorPickerView) findViewById(R.id.color_picker_view);
        colorPickerView.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                integers.add(selectedColor);
            }
        });


    }

    public void selectColor(View view) {
        if (integers.size() > 0)
            colorPickerView.setColorToSliders(integers.get(random.nextInt(integers.size())));
    }
}
