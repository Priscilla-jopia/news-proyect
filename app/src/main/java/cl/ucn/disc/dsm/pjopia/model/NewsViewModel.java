/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.model;


import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Executors;


import cl.ucn.disc.dsm.pjopia.service.newsapi.Contracts;
import cl.ucn.disc.dsm.pjopia.service.newsapi.NewsAPIService;

public final class NewsViewModel extends AndroidViewModel {

    private static final Logger log= LoggerFactory.getLogger(NewsViewModel.class)

    private Contracts contracts= new NewsAPIService();

    private final MutableLiveData<List<News>> theNews;
        return this.theNews;

    public NewsViewModel(final Application application){

        super(application);

        this.theNews = new MutableLiveData<>();

    }

    public void getNews(){

    }

    public void refresh(){

        if (this.theNews.getValue() == null|| this.theNews.getValue().size() ==0){
            log.warn("No News, fetching from Contracts..");


        }

        Executors.newSingleThreadExecutor().execute(()-> {

            List<News> news = this.contracts.retrieveNews(50);

            new Handler(Looper.getMainLooper()).post(() ->{

                // Get news from backend
                this.theNews.setValue(news);
            });
        });


    }

}
