/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.service.newsapi;

import java.util.List;

import cl.ucn.disc.dsm.pjopia.model.News;

public interface Contracts {


    /**
     * Get the list of News
     * @param size
     * @return
     */
    List<News> retrieveNews(Integer size);


    /**
     * Save one Newsto the System
     * @param news to save.
     */
    void save(News news);
}
