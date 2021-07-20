/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.model;

import com.github.javafaker.Faker;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import java.util.logging.Logger;


public final class TestNews {


    /**
     * The logger
     */

    private static final Logger log = LoggerFactory.getLogger(TestNews.class);

    private static String toString(final Object obj){
        return ToStringBuilder.reflectionToString(Obj, ToStringStyle.MULTI_LINE_STYLE);
    }
    /**
     * Testing the constructor
     */
    @Test
    public void testConstructor() {

        log.debug("Starting the Constructor..");

        Faker faker = new Faker();
        

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

         log.info("The News: {}", toString(news));

         Assertions.assertNotNull(news.getId());
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

        log.debug("Done");

    }


}
