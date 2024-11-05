package cc.maids.books.borrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import cc.maids.books.models.Book;
import cc.maids.books.models.Patron;
import cc.maids.books.services.BookService;
import cc.maids.books.services.BorrowRecordService;
import cc.maids.books.services.PatronService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BorrowRecordControllerTests {

    @Autowired 
    private TestRestTemplate restTemplate;

    @Autowired
    private BookService bookService;

    @Autowired
    private PatronService patronService;

    @Autowired
    private BorrowRecordService borrowRecordService;

    @Test
    void testBorrowBook() {

        Book book = new Book();
        book.setAuthor("Test");
        book.setISBN("Test");
        book.setPublicationDate(new Date());
        book.setTitle("Test");
        book = bookService.createOrUpdateBook(book);

        Patron patron = new Patron();
        patron.setName("Test");
        patron = patronService.createOrUpdatePatron(patron);

        ResponseEntity<String> response = restTemplate.postForEntity("/api/borrow/" + book.getId() + "/patron/" + patron.getId(), null, String.class); 
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }

    @Test
    void testReturnBook() {

        Book book = new Book();
        book.setAuthor("Test");
        book.setISBN("Test");
        book.setPublicationDate(new Date());
        book.setTitle("Test");
        book = bookService.createOrUpdateBook(book);

        Patron patron = new Patron();
        patron.setName("Test");
        patron = patronService.createOrUpdatePatron(patron);

        borrowRecordService.borrowBook(book.getId(), patron.getId());

        ResponseEntity<String> response = restTemplate.postForEntity("/api/return/" + +book.getId() + "/patron/" + patron.getId(), null, String.class); 
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }
}

