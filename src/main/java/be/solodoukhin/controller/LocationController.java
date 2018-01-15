package be.solodoukhin.controller;

import be.solodoukhin.model.Location;
import be.solodoukhin.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {

    private LocationRepository repository;

    @Autowired
    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/{id}")
    public Location getOne(@PathVariable("id") Integer id){
        return this.repository.getOne(id);
    }

    @GetMapping(path = "/all")
    public Iterable<Location> getAll(){
        return this.repository.findAll();
    }
}
