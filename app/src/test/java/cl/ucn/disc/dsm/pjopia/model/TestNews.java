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

        News news = new News(
                title: "The title",
                source; "The source",
                author; "The Author",
                url: "The url",
                urlImage: "TheImage Url",
                description; "The description",
                content; "The content",
                ZonedDateTime.now(ZoneId.of("-3")));
        Assertions.assertEquals( expected, news.getTitle()
        );
    }


}
