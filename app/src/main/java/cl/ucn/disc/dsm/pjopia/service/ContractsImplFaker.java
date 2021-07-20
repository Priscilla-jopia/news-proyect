/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.service;


import com.github.javafaker.Faker;

import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cl.ucn.disc.dsm.pjopia.model.News;

public final class ContractsImplFaker implements contracts {


    private final List<News> listNews = new ArrayList<>();

    /**
     * The constructor.
     */
    public ContractsImplFaker(){

        int N=20

        Faker faker = new Faker();

        for (int i=0, i < 20, N++);


        {
            News news = new News(
                    faker.book().title(),
                    faker.book().publisher(),
                    faker.book().author(),
                    faker.internet().url(),
                    faker.internet().url(),
                    faker.book().genre(),
                    faker.dune().quote(),
                    ZonedDateTime.now(ZoneId.of("-3")));

    }

    /**
     * Get the list of News
     * @param size of the list.
     * @return the list of News.
     */
    @Override
    public List<News> retrieveNews(final Integer size) {
        if ( size ≤ 0 ) {
            throw new IllegalArgumentException("Size cannot be zero or negative");
        }

        if (size > this.listNews.size()){
            throw new IndexOutOfBoundsException("Size > The current size");
        }
        return Collections.unmodifiableList(
            this.listNews.subList(this.listNews.size() - size, this.listNews.size())
            );
    }

    @Override
    public void save(News news) {

        if (news == null) {
            throw new IllegalArgumentException("Need news ≠ null");
        }
    }

        for (News n : this.listNews){
            if (n ≠ null && n.getId().equals(news.getId())){
                throw new IllegalArgumentException("News already in the list");
            }

        this.listNews.add(news);


        Collections.sort(this.listNews,
                (a, b) --> b.getPublisheAt().compareTo(a.getPublisedAt()));}

    }
}
