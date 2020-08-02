package in.crpdev.msscbreweryclient.web.client;

import in.crpdev.msscbreweryclient.web.model.CustomerDto;
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
@ConfigurationProperties(prefix = "mssc.customer", ignoreUnknownFields = false)
public class CustomerClient {
    private static final String CUSTOMER_URI_PATH = "/api/v1/customer/";
    private String apiHost;
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID customerId){
        return restTemplate.getForObject(apiHost + CUSTOMER_URI_PATH + customerId, CustomerDto.class);
    }

    public URI createNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost + CUSTOMER_URI_PATH, customerDto);
    }

    public void updateCustomerInfo(UUID customerId, CustomerDto customerDto){
        restTemplate.put(apiHost + CUSTOMER_URI_PATH + customerId, customerDto);
    }

    public void deleteCustomerById(UUID customerId){
        restTemplate.delete(apiHost + CUSTOMER_URI_PATH + customerId);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
