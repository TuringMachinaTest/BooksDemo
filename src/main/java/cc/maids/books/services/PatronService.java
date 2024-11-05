package cc.maids.books.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.maids.books.models.Patron;
import cc.maids.books.repositories.PatronRepository;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

    @Cacheable("patrons")
    @Transactional(readOnly = true)
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @Cacheable("patrons")
    @Transactional(readOnly = true)
    public Patron getPatron(Long id) {
        return patronRepository.findById(id).orElse(null);
    }

    @Transactional(rollbackFor = Exception.class)
    public Patron createOrUpdatePatron(Patron patron) {
        return patronRepository.save(patron);
    }
    
}
