package cc.maids.books.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "borrowing_records")
@IdClass(BorrowingRecordId.class)
public class BorrowingRecord implements Serializable {

    @Id
    @ManyToOne
    private Book book;

    @Id
    @ManyToOne
    private Patron patron;

    @Column
    private Date borrowedAt;

    @Column
    private Date returnedAt;

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }
    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Date getBorrowedAt() {
        return borrowedAt;
    }
    public void setBorrowedAt(Date borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public Date getReturnedAt() {
        return returnedAt;
    }
    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }
    
}
