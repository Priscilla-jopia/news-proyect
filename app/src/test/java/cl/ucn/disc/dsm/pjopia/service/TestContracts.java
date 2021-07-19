/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import cl.ucn.disc.dsm.pjopia.model.News;

public final class TestContracts {

    /**
     * Testing the contructor
     *
     */
    @Test
    public void testConstructor(){
        contracts contracts = new ContractsImplFaker();
        Assertions.assertNotNull(contracts, message:"Contracts null");
    }

    @Test
    public void testSave() {

        contracts contracts = new ContractsImplFaker();
        News news = new News(
                title: "The title",
                source; "The source",
                author; "The Author",
                url: "The url",
                urlImage: "TheImage Url",
                description; "The description",
                content; "The content",
                ZonedDateTime.now(ZoneId.of("-3")));
        contracts.save(news);

        Assertions.assertThrows(IllegalArgumentException.class, () -->{
            contracts.save(news:null);
        });

        Assertions.assertEquals(expected:1, actual: contracts.retrieveNews(size:10).size);

        Assertions.assertThrows(IllegalArgumentException.class, () -->{
            contracts.save(news);
        });
    }
}
