package be.solodoukhin.controller.office;

import be.solodoukhin.model.PartnerRequest;
import be.solodoukhin.repository.PartnerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/office/partner-request")
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

    @PostMapping(path = "/add")
    public PartnerRequest addOne(@RequestBody PartnerRequest request){
        return this.repository.save(request);
    }

    @PutMapping(path = "/update")
    public PartnerRequest update(@RequestBody PartnerRequest request){
        PartnerRequest fromDatabase = this.repository.findOne(request.getId());

        if (fromDatabase == null){
            //TODO LOG
            return null;
        }

        // Update
        fromDatabase.setEmail(request.getEmail());
        fromDatabase.setName(request.getName());
        fromDatabase.setPhone(request.getPhone());

        return this.repository.save(fromDatabase);
    }

    @DeleteMapping(path = "/{id}/delete")
    public void delete(@PathVariable("id") Integer id){
        PartnerRequest fromDatabase = this.repository.findOne(id);

        if(fromDatabase == null){
            //TODO LOG
            System.out.println("");
        }else{
            this.repository.delete(fromDatabase.getId());
        }
    }
}
