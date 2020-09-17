package metahorizon.test.coding.enrolleedependentapi.service;

import metahorizon.test.coding.enrolleedependentapi.entity.Dependent;
import metahorizon.test.coding.enrolleedependentapi.entity.Enrollee;
import metahorizon.test.coding.enrolleedependentapi.repository.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DependentService {
    @Autowired
    private DependentRepository dependentRepository;
    @Autowired
    private EnrolleeService enrolleeService;

    public void addDependent(Dependent dependent, int enrolleeId){
        Enrollee enrollee = enrolleeService.getEnrollee(enrolleeId);
        dependent.setEnrollee(enrollee);
        dependentRepository.save(dependent);
    }

    public Dependent getDependent(int id){
        //return enrolleeRepository.findById(id);
        return dependentRepository.getOne(id);
    }

    public void removeDependent(int id){
        if(dependentRepository.existsById(id))
            dependentRepository.deleteById(id);
        else
            System.out.println("removeDependent: id not found");
    }
    public void modifyDependent(Dependent dependent){
        Optional<Dependent> dependentOptional = dependentRepository.findById(dependent.getId());
        if(dependentOptional.isPresent()){
            Dependent dependentInDb = dependentOptional.get();
            dependentInDb.setName(dependent.getName());
            dependentInDb.setDob(dependent.getDob());
            dependentRepository.save(dependentInDb);
        }

    }

}
