package cc.maids.books.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.maids.books.models.Book;
import cc.maids.books.models.BorrowingRecord;
import cc.maids.books.models.Patron;
import cc.maids.books.repositories.BorrowRecordRepository;

@Service
public class BorrowRecordService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private PatronService patronService;

    @Transactional
    public Boolean borrowBook(Long bookId, Long patronId) {
        if (borrowRecordRepository.findByBookIdAndPatronId(bookId, patronId) == null) {
            return false;
        }

        Book book = bookService.getBook(bookId);
        if (book == null) {
            return false;
        }

        Patron patron = patronService.getPatron(patronId);
        if (patron == null) {
            return false;
        }

        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowedAt(new Date());
        borrowingRecord.setReturnedAt(null);
        borrowRecordRepository.save(borrowingRecord);
        return true;
    }

    @Transactional
    public Boolean returnBook(Long bookId, Long patronId) {
        BorrowingRecord borrowingRecord = borrowRecordRepository.findByBookIdAndPatronId(bookId, patronId);
        if (borrowingRecord == null) {
            return false;
        }
        borrowingRecord.setReturnedAt(new Date());
        borrowRecordRepository.save(borrowingRecord);
        return true;
    }
    
}
