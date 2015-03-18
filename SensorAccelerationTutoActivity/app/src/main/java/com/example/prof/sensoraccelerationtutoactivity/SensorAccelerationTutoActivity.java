package com.example.prof.sensoraccelerationtutoactivity;

import android.app.ActionBar;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class SensorAccelerationTutoActivity  extends ActionBarActivity implements SensorEventListener
{

    SensorManager sensorManager;

    Sensor accelerometer;

    protected void onResume()
    {

        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        ;
    }

    public void onSensorChanged(SensorEvent event) {
        float x, y, z;
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
        }
        else
        {
            x = 0;
            y = 0;
            z = 0;

        }
        // On écrit dans les logs
        String tag = getClass().getSimpleName();
        Log.d(tag,String.valueOf(x));

        // Affichage de l'accélération linéaire selon les trois axes
        EditText editText = (EditText)findViewById(R.id.xText);
        editText.setText(String.valueOf(x)+" m.s-2", TextView.BufferType.EDITABLE);

        EditText editText2 = (EditText)findViewById(R.id.yText);
        editText2.setText(String.valueOf(y)+" m.s-2", TextView.BufferType.EDITABLE);

        EditText editText3 = (EditText)findViewById(R.id.zText);
        editText3.setText(String.valueOf(z)+" m.s-2", TextView.BufferType.EDITABLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_acceleration_tuto);


        // Faire quelque chose
        // Gérer les capteurs&#160;:
        // Instancier le gestionnaire des capteurs, le SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Instancier l'accéléromètre
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Faire d'autres trucs
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sensor_acceleration_tuto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
