/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    /**
     * @param savedInstanceState the instance.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TheNews", "OnCreate!!!");
    }

    override fun onStart() {
        super.onStart();
        Log.d("TheNews", "OnStart!!!");

    }


}