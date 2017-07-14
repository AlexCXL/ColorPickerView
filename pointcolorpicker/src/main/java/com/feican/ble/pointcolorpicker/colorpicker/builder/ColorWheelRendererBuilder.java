package com.feican.ble.pointcolorpicker.colorpicker.builder;


import com.feican.ble.pointcolorpicker.colorpicker.ColorPickerView;
import com.feican.ble.pointcolorpicker.colorpicker.renderer.ColorWheelRenderer;
import com.feican.ble.pointcolorpicker.colorpicker.renderer.FlowerColorWheelRenderer;
import com.feican.ble.pointcolorpicker.colorpicker.renderer.SimpleColorWheelRenderer;

public class ColorWheelRendererBuilder {
	public static ColorWheelRenderer getRenderer(ColorPickerView.WHEEL_TYPE wheelType) {
		switch (wheelType) {
			case CIRCLE:
				return new SimpleColorWheelRenderer();
			case FLOWER:
				return new FlowerColorWheelRenderer();
		}
		throw new IllegalArgumentException("wrong WHEEL_TYPE");
	}
}