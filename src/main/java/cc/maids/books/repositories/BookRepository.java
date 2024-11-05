package cc.maids.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cc.maids.books.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
