package com.example.temperaturesensor;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class HumidityActivity extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mHumiditySensor;
    private Sensor mTemperatureSensor;
    private  boolean isHumiditySensorPresent;
    private boolean isTemperaturePresent;
    private TextView isRelativeHumidityValue;
    private  TextView mAbsoluteHumidityValue;
    private TextView mDewPointValue;
    private  float mLasKnownRelativeHumidity = 0;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humidity_layout);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
