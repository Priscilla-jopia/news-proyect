/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.threeten.bp.DateTimeUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.ucn.disc.dsm.pjopia.databinding.RowNewsBinding;
import cl.ucn.disc.dsm.pjopia.model.News;

public final class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    private List<News> theNews= new ArrayList<>();

    public NewsAdapter(){
        //Nothing here
    }

    public void setNews(final List<News> news){
        this.theNews = news;
        this.notifyDataSetChanged();
    }


    @Override
    public NewsViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        return new NewsViewHolder(RowNewsBinding.inflate(LayoutInflater.from(parent.getContext())));

    }

    @Override
    public void onBindViewHolder(final NewsAdapter.NewsViewHolder holder, int position) {

        holder.bind(this.theNews.get(position));

    }

    @Override
    public int getItemCount() {

        return this.theNews.size();

    }





    public static class NewsViewHolder extends RecyclerView.ViewHolder{

        private final RowNewsBinding rowNewsBinding;

        public NewsViewHolder(final RowNewsBinding rowNewsBinding) {
            super(rowNewsBinding.getRoot());
            this.rowNewsBinding= rowNewsBinding;
        }

        public void bind(final News news){

            // Bind the title.
            this.rowNewsBinding.rnTvTitle.setText(news.getTitle());

            // Bind the author,
            this.rowNewsBinding.rnTvAuthor.setText(news.getAuthor());

            // Bind the source.
            this.rowNewsBinding.rnTvSource.setText(news.getSource());

            // Bind the description.
            this.rowNewsBinding.rnTvDescription.setText(news.getDescription());

            // ZonedDateTime to Date
            final Date theDate = DateTimeUtils.toDate(news.getPublishedAt().toInstant());

            // Bind the date.
            this.rowNewsBinding.rnTvPublishedAt.setText(PRETTY_TIME.format(theDate));

            //Bind the image
            if(news.getUrlImage() != null){
                //URL to URI
                final Uri uri = Uri.parse(news.getUrlImage());
                this.rowNewsBinding.rnSdvImage.setImageURI(uri);

            }else{
                // No image, use the default.
                this.rowNewsBinding.rnSdvImage.setImageResource(R.drawable.ic_launcher_foreground);
            }


        }
    }
}

