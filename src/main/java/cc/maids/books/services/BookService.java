package cc.maids.books.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.maids.books.models.Book;
import cc.maids.books.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Cacheable("books")
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Cacheable("books")
    @Transactional(readOnly = true)
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional(rollbackFor = Exception.class)
    public Book createOrUpdateBook(Book book) {
        return bookRepository.save(book);
    }
    
}
