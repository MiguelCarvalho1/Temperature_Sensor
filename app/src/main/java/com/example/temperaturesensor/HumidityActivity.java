package com.example.temperaturesensor;

import android.app.Activity;
import android.content.Context;
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
    private TextView mRelativeHumidityValue;
    private  TextView mAbsoluteHumidityValue;
    private TextView mDewPointValue;
    private  float mLasKnownRelativeHumidity = 0;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humidity_layout);
        mRelativeHumidityValue = (TextView)findViewById(R.id.relativehumiditytext);
        mAbsoluteHumidityValue = (TextView)findViewById(R.id.absolutehumiditytext);
        mSensorManager = (SensorManager)this.getSystemService(Context.SENSOR_SERVICE);
        if(mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) != null){
            mHumiditySensor = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
            isHumiditySensorPresent = true;
        }else {
            mRelativeHumidityValue.setText("Relative Humidty Sensor is not available!");
            mAbsoluteHumidityValue.setText("Cannot calculate Absolute Humity as relative humity sensor is not available!");
            mDewPointValue.setText("Cannot calculate Dew Point, as relative humity sensor is not available!");
            isHumiditySensorPresent = false;
        }
        if(mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null){
            mTemperatureSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTemperaturePresent = true;
        } else {
            mAbsoluteHumidityValue.setText("Cannot calculate Absolute Humidity, as temperature sensor is not available!");
            mDewPointValue.setText("Cannot calculate Dew Point, as temperature sensor is not available!");
            isTemperaturePresent = false;
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
