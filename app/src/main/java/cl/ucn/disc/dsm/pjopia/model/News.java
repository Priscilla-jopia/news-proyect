/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.model;

import org.threeten.bp.ZonedDateTime;

public final  class News {

    /**
     * Unique id.
     */
    private final Long id;

    /**
     * The title.
     * Restrictions:
     * -not null.
     * -size > 2.
     */
    private final String title;

    /**
     * The source.
     */
    private final String source;

    /**
     * The author.
     */
    private final String author;

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

    public News(final String title, final String source, final String author, final String url, final String urlImage, final String description, final String contnent, final ZonedDateTime publishedAt) {
        //FIXME: add the hash(title+source+author)
        this.id = 0L;
        this.title = title;
        this.source = source;
        this.author = author;
        this.url = url;
        this.urlImage = urlImage;
        this.description = description;
        this.contnent = contnent;
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



