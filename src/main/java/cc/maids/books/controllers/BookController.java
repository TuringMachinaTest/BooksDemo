package cc.maids.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.maids.books.exceptions.BadRequestException;
import cc.maids.books.exceptions.NotFoundException;
import cc.maids.books.models.Book;
import cc.maids.books.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        if(id == null) {
            throw new BadRequestException("Invalid Id");
        }
        if (id < 0) {
            throw new BadRequestException("Invalid Id");
        }
        if (id == 0) {
            throw new BadRequestException("Invalid Id");
        }
        
        Book book = bookService.getBook(id);
        if (book == null) {
            throw new NotFoundException("Book not Found");
        }
        return book;
    }

    @PostMapping("/")
    public Book createOrUpdateBook(@RequestBody Book book) {
        return bookService.createOrUpdateBook(book);
    }
    
}
