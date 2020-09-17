package metahorizon.test.coding.enrolleedependentapi.controller;

import metahorizon.test.coding.enrolleedependentapi.entity.Dependent;
import metahorizon.test.coding.enrolleedependentapi.entity.Enrollee;
import metahorizon.test.coding.enrolleedependentapi.service.EnrolleeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enrollees")
public class EnrolleeController  {
    @Autowired
    private EnrolleeService enrolleeService;

    @GetMapping(path="/{id}")
    public Enrollee getEnrollee(@PathVariable (name = "id") int id){
        Enrollee enrollee  = (Enrollee) enrolleeService.getEnrollee(id);
        return enrollee;
    }

    @PostMapping
    public String addEnrollee(@RequestBody Enrollee enrollee){
        enrolleeService.addEnrollee (enrollee);
        return "adding enrollee " + enrollee.toString();
    }
    @PostMapping(path = "/add/dependent/{enrolleeId}")
    public String addEnrollee(@PathVariable (name = "enrolleeId") int enrolleeID, @RequestBody Dependent dependent){
        enrolleeService.addDependent (dependent, enrolleeID);
        return "adding enrollee " + enrolleeID;
    }

    @DeleteMapping("/{id}")
    public void removeEnollee(@PathVariable (name = "id") int id){
        enrolleeService.removeEnrollee(id);
    }

    @PatchMapping
    public void modifyEnrollee(@RequestBody Enrollee enrollee){
        enrolleeService.modifyEnrollee(enrollee);
    }

}
