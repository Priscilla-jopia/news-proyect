/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cl.ucn.disc.dsm.pjopia.databinding.ActivityMainBinding

public final class MainActivity : AppCompatActivity() {


    private ActivityMainBinding binding;

    private NewsViewModel newsViewModel;


    /**
     * @param savedInstanceState the instance.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(layoutInflater());
        setContentView(this.binding.getRoot());

        this.setSupportActionBar(this.binding.toolbar);

        this.newsViewModel= new ViewModelProvider(this).get(NewsViewModel class);


        this.binding.amSrRefresh.SetOnRefreshListener(() -->{
            log.debug("Refreshing  The News..")

            this.newsViewModel.refresh()
        });

        this.newsViewModel.getNews().observe(this, news--> ){
            log.debug("News: {}", news.size());

            this.binding.amSrlRefresh.setRefreshing(false);
        }

    }

    override fun onStart() {
        super.onStart();
        Log.d("TheNews", "OnStart!!!");

    }{


}