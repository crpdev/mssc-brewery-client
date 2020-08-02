package in.crpdev.msscbreweryclient.web.client;

import in.crpdev.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by rajapandian
 * Date: 02/08/20
 * Project: mssc-brewery-client
 * Package: in.crpdev.msscbreweryclient.web.client
 **/
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void createNewBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("Corona").build();
        URI uri = breweryClient.createNewBeer(beerDto);
        System.out.println(uri);
    }

    @Test
    void updateBeerInfo() {
        BeerDto beerDto = BeerDto.builder().beerName("Corona 2020").build();
        breweryClient.updateBeerInfo(UUID.randomUUID(), beerDto);
    }
}
