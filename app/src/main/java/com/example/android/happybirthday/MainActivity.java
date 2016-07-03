package com.example.android.happybirthday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends Activity {

    public int currentimageindex = 0;
    //    Timer timer;
//    TimerTask task;
    ImageView slidingimage;


    private int[] IMAGE_IDS = {
            R.drawable.images, R.drawable.image6, R.drawable.happybirthdaycardsformom,
            R.drawable.loves
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Next(View view){

        display();
    }

    /**
     * Helper method to start the animation on the splash screen
     */
    private void AnimateandSlideShow() {

        slidingimage = (ImageView) findViewById(R.id.image1);
        slidingimage.setImageResource(IMAGE_IDS[currentimageindex % IMAGE_IDS.length]);

        currentimageindex++;

        Animation rotateimage = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);


        slidingimage.startAnimation(rotateimage);


    }
    public void display(){
        final Handler mHandler = new Handler();
        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {

            public void run() {

                AnimateandSlideShow();
            }

        };

        int delay = 1000; // delay for 1 sec.

        int period = 10000;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                mHandler.post(mUpdateResults);

            }

        }, delay, period);
    }

}