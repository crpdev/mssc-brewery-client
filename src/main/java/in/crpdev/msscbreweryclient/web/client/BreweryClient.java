package in.crpdev.msscbreweryclient.web.client;

import in.crpdev.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Created by rajapandian
 * Date: 02/08/20
 * Project: mssc-brewery-client
 * Package: in.crpdev.msscbreweryclient.web.client
 **/
@Component
@ConfigurationProperties(prefix = "mssc.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    private static final String BREWERY_PATH = "/api/v1/beer/";
    private String apiHost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId){
        return restTemplate.getForObject(apiHost + BREWERY_PATH + beerId.toString(), BeerDto.class);
    }

    public URI createNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost + BREWERY_PATH, beerDto);
    }

    public void updateBeerInfo(UUID beerId, BeerDto beerDto){
        restTemplate.put(apiHost + BREWERY_PATH + beerId.toString(), beerDto);
    }

    public void deleteBeerById(UUID beerId){
        restTemplate.delete(apiHost + BREWERY_PATH + beerId);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
