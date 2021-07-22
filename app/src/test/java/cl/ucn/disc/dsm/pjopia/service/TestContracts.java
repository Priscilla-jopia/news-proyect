/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.service;

import com.github.javafaker.Faker;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import cl.ucn.disc.dsm.pjopia.BaseTest;
import cl.ucn.disc.dsm.pjopia.model.News;
import cl.ucn.disc.dsm.pjopia.service.newsapi.Contracts;

public final class TestContracts extends BaseTest {

   private static final Logger log = (Logger) LoggerFactory.getLogger(TestContracts.class);

    private static String toString(final Object obj){
        return ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE);

    /**
     * Testing the contructor
     *
     */
    @Test
    public void testConstructor(){

        Contracts contracts = new ContractsImplFaker();
        Assertions.assertNotNull(Contracts,"Contracts null");
    }

    @Test
    public void testSave(){

        Contracts contracts = new ContractsImplFaker();

        Faker faker = new Faker();

        final int N=20;

        for (int i=0; i<N; i++){

        News news = new News(
                faker.book().title(),
                faker.book().publisher(),
                faker.book().author(),
                faker.internet().url(),
                faker.internet().url(),
                faker.book().genre(),
                faker.dune().quote(),
                ZonedDateTime.now(ZoneId.of("-3")));

        log.info("TheNews {}: {}.",i, toString(news));
        contracts.save(news);

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            contracts.save(news:null);
        });

        Assertions.assertEquals(10,  contracts.retrieveNews(10).size());
        Assertions.assertEquals(1, contracts.retrieveNews(1).size());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->{
            Assertions.assertEquals(100, contracts.retrieveNews(100).size());
        });


        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            contracts.retrieveNews(-100);
            contracts.retrieveNews( 0);
        });

        News news = contracts.retrieveNews(1).get(0);
        Assertions.assertNotNull(news);

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            contracts.save(news);
             });
        /*
        Assertions.assertThrows(IllegalArgumentException.class, () -->{
         contracts.save(news);

        });*/
            }
        }
    }
}
