package com.feican.ble.colorpicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.feican.ble.colorpicker.view.ColorPicker;
import com.feican.ble.colorpicker.view.OpacityBar;
import com.feican.ble.colorpicker.view.SVBar;
import com.feican.ble.colorpicker.view.SaturationBar;
import com.feican.ble.colorpicker.view.ValueBar;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements ColorPicker.OnColorChangedListener {
    ArrayList<Integer> integers = new ArrayList<>();
    private ColorPicker picker;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        picker = (ColorPicker) findViewById(R.id.picker);
        SVBar svBar = (SVBar) findViewById(R.id.svbar);
        OpacityBar opacityBar = (OpacityBar) findViewById(R.id.opacitybar);
        SaturationBar saturationBar = (SaturationBar) findViewById(R.id.saturationbar);
        ValueBar valueBar = (ValueBar) findViewById(R.id.valuebar);

        picker.addSVBar(svBar);
        picker.addOpacityBar(opacityBar);
        picker.addSaturationBar(saturationBar);
        picker.addValueBar(valueBar);

//To get the color
        picker.getColor();

//To set the old selected color u can do it like this
        picker.setOldCenterColor(picker.getColor());
// adds listener to the colorpicker which is implemented
//in the activity
        picker.setOnColorChangedListener(this);

//to turn of showing the old color
        picker.setShowOldCenterColor(false);
    }

    @Override
    public void onColorChanged(int color) {
        integers.add(color);
    }

    public void click(View view) {
        if (integers.size() > 0) {
            picker.setColor(integers.get(random.nextInt(integers.size())));
        }
    }

}
