package com.example.transitions.transitionsfun;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.transition.AutoTransition;
import android.transition.Scene;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;

/**
This is demo code to accompany the Tuts+ tutorial:
Using Android Transitions

Sue Smith
July 2014
*/

public class TransitionsActivity extends Activity {

    //scenes to transition
    private Scene scene1, scene2;
    //transition to move between scenes
    private Transition transition;
    //flag to swap between scenes
    private boolean start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);

        //get the layout ID
        RelativeLayout baseLayout = (RelativeLayout)findViewById(R.id.base);

        //first scene
        ViewGroup startViews = (ViewGroup)getLayoutInflater().inflate(R.layout.start_layout, baseLayout, false);

        //second scene
        ViewGroup endViews = (ViewGroup)getLayoutInflater().inflate(R.layout.end_layout, baseLayout, false);

        //create the two scenes
        scene1 = new Scene(baseLayout, startViews);
        scene2 = new Scene(baseLayout, endViews);

        //create transition, set properties
        transition = new AutoTransition();
        transition.setDuration(5000);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());

        //initialize flag
        start=true;
    }

    public void changeScene(View v){

        //check flag
        if(start) {
            TransitionManager.go(scene2, transition);
            start=false;
        }
        else {
            TransitionManager.go(scene1, transition);
            start=true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.transitions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
