package com.example.student.tastebud;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.Random;

public class MainActivity extends Activity {

    private SensorManager sensorManager;
    private ImageView foodChoice;

    TextView t;

    MediaPlayer bkgrdmsc;
    MediaPlayer talkingsound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TypedArray imgs = getResources().obtainTypedArray(R.array.meals);
        final Random rand = new Random();
        final int rndInt = rand.nextInt(imgs.length());
        final int resID = imgs.getResourceId(rndInt, 0);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelermeter = sensorManager.getDefaultSensor;

        t = (TextView) findViewById(R.id.my_text);
        Typeface myCustomFont=Typeface.createFromAsset(getAssets(), "fonts/Cookie-Regular.ttf");
        t.setTypeface(myCustomFont);


        float rightVol = 1;
        float leftVol  = 1;

        bkgrdmsc = MediaPlayer.create(MainActivity.this, R.raw.backgroundmusic1);
        bkgrdmsc.setLooping(true);
        bkgrdmsc.setVolume(rightVol, leftVol);
        bkgrdmsc.start();

        float talkRightVol = 2;
        float talkLeftVol  = 2;

        talkingsound = MediaPlayer.create(MainActivity.this, R.raw.talkingsound);
        talkingsound.setLooping(true);
        talkingsound.setVolume(talkRightVol,talkLeftVol);
        talkingsound.start();
    }
    @Override
    protected void onPause(){

        super.onPause();
        bkgrdmsc.release();
        talkingsound.release();
        finish();
    }
}
