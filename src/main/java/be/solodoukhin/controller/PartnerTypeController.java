package be.solodoukhin.controller;

import be.solodoukhin.model.PartnerType;
import be.solodoukhin.repository.PartnerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partner-type")
public class PartnerTypeController {

    private PartnerTypeRepository repository;

    @Autowired
    public PartnerTypeController(PartnerTypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/{id}")
    public PartnerType getOne(@PathVariable("id") Integer id){
        return this.repository.getOne(id);
    }

    @GetMapping(path = "/all")
    public Iterable<PartnerType> getAll(){
        return this.repository.findAll();
    }
}
