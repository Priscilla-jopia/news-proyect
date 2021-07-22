/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import cl.ucn.disc.dsm.pjopia.databinding.ActivityMainBinding
import cl.ucn.disc.dsm.pjopia.model.News
import org.slf4j.LoggerFactory

public final class MainActivity : AppCompatActivity() {

    private val log = LoggerFactory.getLogger(MainActivity::class.java)


    private static final Log

    private ActivityMainBinding binding;

    private NewsViewModel newsViewModel;

    private NewsAdapter newsAdapter;

    /**
     * @param savedInstanceState the instance.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(layoutInflater());
        setContentView(this.binding.getRoot());

        this.setSupportActionBar(this.binding.toolbar);

        this.newsViewModel= new ViewModelProvider(this).get(News.NewsViewModel class);


        this.binding.amSrRefresh.SetOnRefreshListener(() -->{
            log.debug("Refreshing  The News..")

            this.newsViewModel.refresh()
        });

        this.newsAdapter = new NewsAdapter();

            this.binding.amRvListnews.setLayoutManager(new LinearLayoutManager(this));
            this.binding.amRvListnews.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            this.binding.amRvListnews.setAdapter(this.Adapter);

        this.newsViewModel.getNews().observe(this, news--> ){
            Log.d("News: {}", news.size());

            this.newsAdapter.setNews(news);

            this.binding.amSrlRefresh.setRefreshing(false);
        }

    }

    override fun onStart() {
        super.onStart();
        Log.d("TheNews", "OnStart!!!");

    }


}