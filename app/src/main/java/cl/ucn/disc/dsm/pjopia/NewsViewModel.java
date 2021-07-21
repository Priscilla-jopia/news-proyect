/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.Contract;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.logging.Logger;

import cl.ucn.disc.dsm.pjopia.model.News;
import cl.ucn.disc.dsm.pjopia.service.ContractsImplFaker;

public final class NewsViewModel extends AndroidViewModel {

    private static final Logger log= LoggerFactory.getLogger(NewsViewModel.class)

    private Contracts contracts= new ContractsImplFaker();

    private final MutableLiveData<List<News>> theNews;

    public NewsViewModel(final Application application){

        super(application);

        this.theNews = new MutableLiveData<>();

    }

    public LiveData<List<News>> getNews(){

    }

    public void refresh(){

        if (this.theNews.getValue()=null|| this.theNews.getValue().size()=0){
            log.warn("No News, fetching from Contracts..");


        }

        this.theNews.setValue(this.contracts.retrieveNews(10));
    }




}
