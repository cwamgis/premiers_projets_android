package com.example.prof.helloworld;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import android.content.Context;

import java.util.List;



public class MainActivity extends ActionBarActivity {

    private SensorManager mSensorManager;
    private Sensor mSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On écrit dans les logs
        String tag = getClass().getSimpleName();
        Log.d(tag,"CREATION");

        CheckBox pouet = (CheckBox)findViewById(R.id.checkBox);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorManager.


        pouet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub

                Context context = getApplicationContext();
                CharSequence text = "Hello toast!";

                if (isChecked)
                    text = "checked";
                else
                    text = "not checked";

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                listSensor();
            }
        });

        //listSensor();
    }


    private void listSensor() {
        // Trouver tous les capteurs de l'appareil :
        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);
        // La chaîne descriptive de chaque capteur
        StringBuffer sensorDesc = new StringBuffer();
        //pour chaque capteur trouvé, construire sa chaîne descriptive
        for (Sensor sensor : sensors) {
            sensorDesc.append("New sensor detected : \r\n");
            sensorDesc.append("\tName: " + sensor.getName() + "\r\n");
            //sensorDesc.append("\tType: " + getType(sensor.getType()) + "\r\n");
            sensorDesc.append("Version: " + sensor.getVersion() + "\r\n");
            sensorDesc.append("Resolution (in the sensor unit): " + sensor.getResolution() + "\r\n");
            sensorDesc.append("Power in mA used by this sensor while in use" + sensor.getPower() +
                    "\r\n");
            sensorDesc.append("Vendor: " + sensor.getVendor() + "\r\n");
            sensorDesc.append("Maximum range of the sensor in the sensor's unit." +
                    sensor.getMaximumRange() + "\r\n");
            sensorDesc.append("Minimum delay allowed between two events in microsecond"
                    + " or zero if this sensor only returns a value when the data it's measuring changes"
                    + sensor.getMinDelay() + "\r\n");
        }

        // Faire quelque chose de cette liste
        Toast.makeText(this, sensorDesc.toString(), Toast.LENGTH_LONG).show();

    }



    @Override
    protected void onStop()
    {
        // On écrit dans les logs
        String tag = getClass().getSimpleName();
        Log.d(tag,"on stop!");

    }
    @Override
    protected void onDestroy()
    {
        // On écrit dans les logs
        String tag = getClass().getSimpleName();
        Log.d(tag,"on destroy!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

