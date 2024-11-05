package cc.maids.books.models;

import java.io.Serializable;
import java.util.Objects;

public class BorrowingRecordId implements Serializable {

    private Patron patron;
    private Book book;

    public BorrowingRecordId(Patron patron, Book book) {
        this.patron = patron;
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }
    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patron, book);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BorrowingRecordId that = (BorrowingRecordId) obj;
        return Objects.equals(patron.getId(), that.patron.getId()) && Objects.equals(book.getId(), that.book.getId());
    }
    
}
