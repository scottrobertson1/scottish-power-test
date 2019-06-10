package main.java.rest.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import main.java.rest.domain.Meter;
import main.java.rest.repo.MeterRepo;
import main.java.rest.resource.MeterResource;
import main.java.rest.resource.MeterResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Meter.class)
@RequestMapping(value = "/account", produces = "application/json")
public class MeterController {

    @Autowired
    private MeterRepo repository;

    @Autowired
    private MeterResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<MeterResource>> findAllAccounts() {
        List<Meter> accounts = repository.findAll();
        return new ResponseEntity<>(assembler.toResourceCollection(accounts), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<MeterResource> createAccount(@RequestBody Meter account) {
        Meter createdAccount= repository.create(account);
        return new ResponseEntity<>(assembler.toResource(createdAccount), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MeterResource> findAccountById(@PathVariable Long id) {
        Optional<Meter> account= repository.findById(id);

        if (account.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(account.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        boolean wasDeleted = repository.delete(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<MeterResource> updateAccount(@PathVariable Long id, @RequestBody Meter updatedAccount) {
        boolean wasUpdated = repository.update(id, updatedAccount);

        if (wasUpdated) {
            return findAccountById(id);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}