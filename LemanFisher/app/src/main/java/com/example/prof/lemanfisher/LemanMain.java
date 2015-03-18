package com.example.prof.lemanfisher;

import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import businessmodel.Famille;
import businessmodel.Fish;
import dataaccess.DataSource;
import dataaccess.FishDAO;


public class LemanMain extends ActionBarActivity {
    private Fish monPoisson;
    private DataSource ds;
    private FishDAO fishDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Bd
        ds = new DataSource(this);
        fishDao = ds.newFishDAO();

        ds.open();


        setContentView(R.layout.activity_leman_main);

        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Famille f = new Famille(-1,"famille bidon");
                EditText editText2 = (EditText)findViewById(R.id.editText);

                Fish monPoisson = new Fish(-1,editText2.getText().toString(),f);

                fishDao.create(monPoisson);

               Log.d(getClass().getSimpleName(),monPoisson.toString());
               // read all
               Fish monPoissonRecupere = fishDao.read(monPoisson);
               // Log.d(getClass().getSimpleName(),monPoissonRecupere.toString());


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leman_main, menu);
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
