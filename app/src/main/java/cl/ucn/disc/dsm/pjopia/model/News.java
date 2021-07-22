/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import net.openhft.hashing.LongHashFunction;

import org.slf4j.LoggerFactory;
import org.threeten.bp.ZonedDateTime;

import java.util.List;
import java.util.logging.Logger;

import cl.ucn.disc.dsm.pjopia.service.ContractsImplFaker;

public final  class News {

    /**
     * Unique id.
     */
    private  Long id;

    /**
     * The title.
     * Restrictions:
     * -not null.
     * -size > 2.
     */
    private String title;

    /**
     * The source.
     */
    private String source;

    /**
     * The author.
     */
    private String author;

    /**
     * The url.
     */
    private final String url;

    /**
     * The urlImage.
     */
    private final String urlImage;

    /**
     * The Description.
     */
    private final String description;

    /**
     * The content.
     */
    private final String contnent;

    /**
     * The Date of Publish.
     */
    private final ZonedDateTime publishedAt;

    /**
     * The constructor.
     * @param title
     * @param source
     * @param author
     * @param url
     * @param urlImage
     * @param description
     * @param contnent
     * @param publishedAt
     */

    public News(final String title,
                final String source,
                final String author,
                final String url,
                final String urlImage,
                final String description,
                final String contnent,
                final ZonedDateTime publishedAt) {
        //FIXME: add the hash(title+source+author)

        this.title = (title != null && title.length() >0) ? title: "No Title";

        if (source == null ){
            throw new IllegalArgumentException("Source was null");
        }

        if (source.length() <= 2){
            throw new IllegalArgumentException("Source size ≤ 4 [" + source + "]");
        }

        this.source = source;

        this.author = (author !=null ) ? author : "No Author";

        this.id = LongHashFunction.xx().hashChars(
                this.getTitle() + "|" + this.getSource() + "|" + this.getAuthor()

        );



        this.url = url;
        this.urlImage = urlImage;
        this.description = description;
        this.contnent = contnent;

        if (publishedAt == null){
            throw new IllegalArgumentException("The PublishedAt needed!");
        }
        this.publishedAt = publishedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getDescription() {
        return description;
    }

    public String getContnent() {
        return contnent;
    }

    public ZonedDateTime getPublishedAt() {
        return publishedAt;
    }







}



