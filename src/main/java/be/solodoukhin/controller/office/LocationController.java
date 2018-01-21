package be.solodoukhin.controller.office;

import be.solodoukhin.model.Location;
import be.solodoukhin.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/office/location")
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

    @PostMapping(path = "/add")
    public Location addOne(@RequestBody Location location){
        return this.repository.save(location);
    }

    @PutMapping(path = "/update")
    public Location updateOne(@RequestBody Location location){
        Location fromDatabase = this.repository.findOne(location.getId());

        if(fromDatabase == null){
            //TODO LOG
            return null;
        }

        // Update
        fromDatabase.setName(location.getName());

        return this.repository.save(fromDatabase);
    }

    @DeleteMapping(path = "/{id}/delete")
    public void delete(@PathVariable("id") Integer id){
        Location fromDatabase = this.repository.getOne(id);

        if(fromDatabase == null){
            //TODO LOG
            System.out.println("");
        }
        else{
            this.repository.delete(fromDatabase);
        }
    }
}
