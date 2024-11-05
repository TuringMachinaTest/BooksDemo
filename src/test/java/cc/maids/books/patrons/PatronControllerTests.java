package cc.maids.books.patrons;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import cc.maids.books.models.Patron;
import cc.maids.books.services.PatronService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatronControllerTests {

    @Autowired 
    private TestRestTemplate restTemplate;

    @Autowired
    private PatronService patronService;

    @Test
    void testGetPatrons() {

        Patron patron = new Patron();
        patron.setName("Test");
        patron.setEmail("Test");
        patron.setAddress("Test");
        patron.setPhoneNumber("Test");
        patron = patronService.createOrUpdatePatron(patron);

        ResponseEntity<String> response = restTemplate.getForEntity("/api/patrons", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).contains("Test");

    }

    @Test
    void testGetPatronById() {
        
        Patron patron = new Patron();
        patron.setName("Test");
        patron.setEmail("Test");
        patron.setAddress("Test");
        patron.setPhoneNumber("Test");
        patron = patronService.createOrUpdatePatron(patron);

        ResponseEntity<String> response = restTemplate.getForEntity("/api/patrons/" + patron.getId(), String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).contains("Test");

    }

    @Test
    void testCreatePatron() {

        Patron patron = new Patron();
        patron.setName("Test");
        patron.setEmail("Test");
        patron.setAddress("Test");
        patron.setPhoneNumber("Test");
        patron = patronService.createOrUpdatePatron(patron);

        ResponseEntity<String> response = restTemplate.getForEntity("/api/patrons/" + patron.getId(), String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).contains("Test");
    }
    
}
