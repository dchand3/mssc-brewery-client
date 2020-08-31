package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Client Test for the {@link CustomerClient}
 * @author dchand3
 */
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getBeerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);

    }

    @Test
    void testSaveNewBeer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();

        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }

    @Test
    void testUpdateBeer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("New Custoner").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);

    }

    @Test
    void testDeleteBeer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}