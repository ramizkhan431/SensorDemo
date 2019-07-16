package com.example.sensordemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.nisrulz.sensey.FlipDetector;
import com.github.nisrulz.sensey.LightDetector;
import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;
import com.github.nisrulz.sensey.SoundLevelDetector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.faded);

        Sensey.getInstance().init(this);
//
//        ShakeDetector.ShakeListener shakeListener=new ShakeDetector.ShakeListener() {
//            @Override public void onShakeDetected() {
//                // Shake detected, do something
//
//                Toast.makeText(MainActivity.this, "Test start", Toast.LENGTH_SHORT).show();
//                getWindow().getDecorView().setBackgroundColor(Color.RED);
//            }
//
//            @Override public void onShakeStopped() {
//                // Shake stopped, do something
//
//                Toast.makeText(MainActivity.this, "Test Stop", Toast.LENGTH_SHORT).show();
//                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
//            }
//        };
//
//        Sensey.getInstance().startShakeDetection(shakeListener);

//        FlipDetector.FlipListener flipListener=new FlipDetector.FlipListener() {
//            @Override public void onFaceUp() {
//                // Device Facing up
//                Toast.makeText(MainActivity.this, "Test start", Toast.LENGTH_SHORT).show();
//                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
//            }
//
//            @Override public void onFaceDown() {
//                // Device Facing down
//                Toast.makeText(MainActivity.this, "Test Stop", Toast.LENGTH_SHORT).show();
//                getWindow().getDecorView().setBackgroundColor(Color.BLACK);
//            }
//        };
//        Sensey.getInstance().startFlipDetection(flipListener);

        LightDetector.LightListener lightListener=new LightDetector.LightListener() {
            @Override public void onDark() {
                // Dark
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.faded);
                mediaPlayer.start();

            }

            @Override public void onLight() {
                // Not Dark
                getWindow().getDecorView().setBackgroundColor(Color.BLACK);
                //final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.faded);
                mediaPlayer.pause();
            }
        };

        Sensey.getInstance().startLightDetection(lightListener);


    }
}
