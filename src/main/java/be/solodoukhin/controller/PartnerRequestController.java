package be.solodoukhin.controller;

import be.solodoukhin.model.PartnerRequest;
import be.solodoukhin.repository.PartnerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partner-request")
public class PartnerRequestController {

    private PartnerRequestRepository repository;

    @Autowired
    public PartnerRequestController(PartnerRequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/{id}")
    public PartnerRequest getOne(@PathVariable("id") Integer id){
        return this.repository.getOne(id);
    }

    @GetMapping(path = "/all")
    public Iterable<PartnerRequest> getAll(){
        return this.repository.findAll();
    }
}
