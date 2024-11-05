package cc.maids.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cc.maids.books.models.BorrowingRecord;
import cc.maids.books.models.BorrowingRecordId;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowingRecord, BorrowingRecordId> {

    @Query("SELECT b FROM BorrowingRecord b WHERE b.book.id = ?1 AND b.patron.id = ?2")
    public BorrowingRecord findByBookIdAndPatronId(Long bookId, Long patronId);
    
}
