/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;


public final class TestNews {

    /**
     * Testing the constructor
     */
    @Test
    public void testConstructor() {

        {
         News news = new News(
                title: "The title",
                source; "The source",
                author; "The Author",
                url: "The url",
                urlImage: "TheImage Url",
                description; "The description",
                content; "The content",
                ZonedDateTime.now(ZoneId.of("-3")));
         Assertions.assertNotNull(news.getId());
         Assertions.assertEquals( expected: "The title", news.getTitle());
         Assertions.assertEquals( expected: "The source", news.getSource());
         Assertions.assertEquals( expected: "The Author", news.getAuthor());
         Assertions.assertEquals( expected: "The Url", news.getUrl());
         Assertions.assertEquals( expected: "The Image Url", news.getUrlImage());
         Assertions.assertEquals( expected: "The description", news.getDescription());
         Assertions.assertEquals( expected: "The content", news.getContnent());
         Assertions.assertNotNull(news.getPublishedAt());
        }
        //Test no valid data

        {

        Assertions.assertThrows(IllegalArgumentException.class, () -->{
                News news = new News(
                title: null,
                source; "The source",
                author; "The Author",
                url: "The url",
                urlImage: "TheImage Url",
                description; "The description",
                content; "The content",
                publishedAt: null);
            );

            News news = new News(
                    title: "The title",
                source; null,
                author; "The Author",
                url: "The url",
                urlImage: "TheImage Url",
                description; "The description",
                content; "The content",
                ZonedDateTime.now(ZoneId.of("-3")));
        }

        News news = new News(
                title: null,
                source; "The source",
                author; "The Author",
                url: "The url",
                urlImage: "TheImage Url",
                description; "The description",
                content; "The content",
                ZonedDateTime.now(ZoneId.of("-3")));
        Assertions.assertEquals( expected: "no title", news.getTitle()

        }
    }


}
