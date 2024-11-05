package cc.maids.books.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import cc.maids.books.models.Book;
import cc.maids.books.services.BookService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTests {

    @Autowired 
    private TestRestTemplate restTemplate;

    @Autowired 
    private BookService bookService;

    @Test
    void testGetBooks() { 

        Book book = new Book();
        book.setAuthor("Test");
        book.setISBN("Test");
        book.setPublicationDate(new Date());
        book.setTitle("Test");
        book = bookService.createOrUpdateBook(book);

        ResponseEntity<String> response = restTemplate.getForEntity("/api/books", String.class);
        
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).contains("Test");
    }

    @Test
    void testGetBookById() { 

        Book book = new Book();
        book.setAuthor("Test");
        book.setISBN("Test");
        book.setPublicationDate(new Date());
        book.setTitle("Test");
        book = bookService.createOrUpdateBook(book);

        ResponseEntity<String> response = restTemplate.getForEntity("/api/books/" + book.getId(), String.class);
        
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).contains("Test");
    }

    @Test
    void testCreateBook() { 

        Book book = new Book();
        book.setAuthor("Test");
        book.setISBN("Test");
        book.setPublicationDate(new Date());
        book.setTitle("Test");

        ResponseEntity<String> response = restTemplate.postForEntity("/api/books", book, String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }
}
