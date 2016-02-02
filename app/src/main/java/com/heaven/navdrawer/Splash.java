package com.heaven.navdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Heaven on 10/1/16.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Thread myThread = new Thread() {
           @Override
        public void run(){
               try {
                   sleep(3000);
                   Intent mainScreen = new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(mainScreen);
                   finish();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        };
        myThread.start();
    }
}
