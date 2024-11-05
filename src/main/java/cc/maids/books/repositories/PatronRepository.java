package cc.maids.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cc.maids.books.models.Patron;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
    
}
