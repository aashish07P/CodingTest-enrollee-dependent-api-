package metahorizon.test.coding.enrolleedependentapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import metahorizon.test.coding.enrolleedependentapi.entity.Dependent;
import metahorizon.test.coding.enrolleedependentapi.service.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("dependents")
public class DependentController {
    @Autowired
    private DependentService dependentService;

    @GetMapping(path="/{id}")
    public Dependent getDependent(@PathVariable (name = "id") int id){
        Dependent dependent  = (Dependent) dependentService.getDependent(id);
        return dependent;
        //return new Enrollee();
    }

    @PostMapping("/add/{id}")
    public String addDependent(@PathVariable (name="id") int enroleeid, @RequestBody Dependent dependent){
        //ObjectMapper jsonObjectMapper = new ObjectMapper();
        //Dependent dependent = jsonObjectMapper.treeToValue(objectNode.get("dependent")) ;
        dependentService.addDependent (dependent, enroleeid);
        return "adding dependent " + dependent.toString() + " " + enroleeid;
    }

    @DeleteMapping("/{id}")
    public void removeDependent(@PathVariable (name = "id") int id){
        dependentService.removeDependent(id);
    }

    @PatchMapping
    public void modifyDependent(@RequestBody Dependent dependent){
        dependentService.modifyDependent(dependent);
    }

}
