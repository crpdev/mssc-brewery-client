package in.crpdev.msscbreweryclient.web.client;

import in.crpdev.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

/**
 * Created by rajapandian
 * Date: 02/08/20
 * Project: mssc-brewery-client
 * Package: in.crpdev.msscbreweryclient.web.client
 **/
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDto customerById = customerClient.getCustomerById(UUID.randomUUID());
        System.out.println(customerById);
    }

    @Test
    void createNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Rajapandian").build();
        URI newCustomerURL = customerClient.createNewCustomer(customerDto);
        System.out.println(newCustomerURL);
    }

    @Test
    void updateCustomerInfo() {
        CustomerDto customerDto = CustomerDto.builder().name("Rajapandian C").build();
        customerClient.updateCustomerInfo(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomerById() {
        customerClient.deleteCustomerById(UUID.randomUUID());
    }
}
