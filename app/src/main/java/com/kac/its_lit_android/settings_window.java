package com.kac.its_lit_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

/**
 * Created by Kevin on 11/29/2016.
 */

public class settings_window extends AppCompatActivity {

    private Switch modSwitch;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_window);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Settings");
        modSwitch = (Switch) findViewById(R.id.modSwitch);
        
        //set the switch to OFF
        modSwitch.setChecked(false);
        if (MapsActivity.getModeration()) {
            modSwitch.setChecked(true);
        }
        //attach a listener to check for changes in state
        modSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){
                    MapsActivity.moderationModeOn();
                    MapsActivity.updateInfoWindow();
                }
                else{
                    MapsActivity.moderationModeOff();
                    MapsActivity.updateInfoWindow();
                }
            }
        });

        //check the current state before we display the screen
        if(modSwitch.isChecked()){
            MapsActivity.moderationModeOn();
        }
        else {
            MapsActivity.moderationModeOff();
        }
    }

    //Function for when the hamburger button has been pressed:
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        //System.out.println("Test.");
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}