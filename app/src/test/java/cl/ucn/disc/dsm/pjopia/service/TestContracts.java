/*
 * Copyright (c) 2021. Priscilla Jopia
 */

package cl.ucn.disc.dsm.pjopia.service;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import java.util.logging.Logger;

import cl.ucn.disc.dsm.pjopia.model.News;

public final class TestContracts {

    private static final Logger log = (Logger) LoggerFactory.getLogger(TestContracts.class);

    private static String toString(final Object obj){
        return ToStringBuilder.reflectionToString(Obj, ToStringStyle.MULTI_LINE_STYLE);

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

        Faker faker

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
