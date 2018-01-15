package be.solodoukhin.controller;

import be.solodoukhin.model.Partner;
import be.solodoukhin.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    private PartnerRepository repository;

    @Autowired
    public PartnerController(PartnerRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/{id}")
    public Partner getOne(@PathVariable("id") Integer id){
        return this.repository.getOne(id);
    }

    @GetMapping(path = "/all")
    public Iterable<Partner> getAll(){
        return this.repository.findAll();
    }
}
