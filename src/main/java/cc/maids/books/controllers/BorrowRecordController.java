package cc.maids.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.maids.books.exceptions.BadRequestException;
import cc.maids.books.services.BorrowRecordService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api") 
public class BorrowRecordController {
    
    @Autowired
    private BorrowRecordService borrowRecordService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public Boolean borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        if(bookId == null || patronId == null) {
            throw new BadRequestException("Invalid Id");
        }
        if (bookId < 0 || patronId < 0) {
            throw new BadRequestException("Invalid Id");
        }
        if (bookId == 0 || patronId == 0) {
            throw new BadRequestException("Invalid Id");
        }
        return borrowRecordService.borrowBook(bookId, patronId);
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public Boolean returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        if(bookId == null || patronId == null) {
            throw new BadRequestException("Invalid Id");
        }
        if (bookId < 0 || patronId < 0) {
            throw new BadRequestException("Invalid Id");
        }
        if (bookId == 0 || patronId == 0) {
            throw new BadRequestException("Invalid Id");
        }
        return borrowRecordService.returnBook(bookId, patronId);
    }
    
}
