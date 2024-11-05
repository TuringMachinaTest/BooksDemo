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
import cc.maids.books.models.Patron;
import cc.maids.books.services.PatronService;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public Patron getPatron(@PathVariable Long id) {
        if(id == null) {
            throw new BadRequestException("Invalid Id");
        }
        if (id < 0) {
            throw new BadRequestException("Invalid Id");
        }
        if (id == 0) {
            throw new BadRequestException("Invalid Id");
        }

        Patron patron = patronService.getPatron(id);
        if (patron == null) {
            throw new NotFoundException("Book not Found");
        }
        return patron;
    }

    @PostMapping("/")
    public Patron createOrUpdatePatron(@RequestBody Patron patron) {
        return patronService.createOrUpdatePatron(patron);
    }
    
}
