/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.service;


import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.pjopia.model.News;

public final class ContractsImplFaker implements contracts {

    /**
     * Get the list of News
     * @param size of the list.
     * @return the list of News.
     */
    @Override
    public List<News> retrieveNews(final Integer size) {
        return new ArrayList<>();
    }

    @Override
    public void save(News news) {

    }
}
