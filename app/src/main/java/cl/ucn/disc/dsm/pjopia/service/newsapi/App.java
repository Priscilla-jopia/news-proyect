/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.service.newsapi;
import com.facebook.drawee.backends.pipeline.Fresco;
import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Fresco.initialize(this);
    }
}
