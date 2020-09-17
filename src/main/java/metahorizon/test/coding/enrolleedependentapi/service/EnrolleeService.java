package metahorizon.test.coding.enrolleedependentapi.service;

import jdk.nashorn.internal.ir.EmptyNode;
import metahorizon.test.coding.enrolleedependentapi.entity.Dependent;
import metahorizon.test.coding.enrolleedependentapi.entity.Enrollee;
import metahorizon.test.coding.enrolleedependentapi.repository.EnrolleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EnrolleeService  {
    @Autowired
    private EnrolleeRepository enrolleeRepository;

    public void addEnrollee(Enrollee enrollee){
        //System.out.println("service addenrollee called");
        enrolleeRepository.save(enrollee);
    }

    public Enrollee getEnrollee(int id){
        //return enrolleeRepository.findById(id);
        return enrolleeRepository.getOne(id);
    }

    public void removeEnrollee(int id){
        enrolleeRepository.deleteById(id);
    }
    public void modifyEnrollee(Enrollee enrollee){
        Optional<Enrollee> enrolleeOptional = enrolleeRepository.findById(enrollee.getId());
        if(enrolleeOptional.isPresent()){
            Enrollee enrolleeInDb = enrolleeOptional.get();
            enrolleeInDb.setName(enrollee.getName());
            enrolleeInDb.setDob(enrollee.getDob());
            enrolleeInDb.setActivation(enrollee.isActivation());
            enrolleeInDb.setPhone(enrollee.getPhone());
            enrolleeRepository.save(enrolleeInDb);
        }
     }

     public void addDependent(Dependent dependent, int enroleeId){
         Enrollee enrollee = enrolleeRepository.getOne(enroleeId);
         dependent.setEnrollee(enrollee);
         enrollee.getDependentList().add(dependent);
         enrolleeRepository.save(enrollee);
     }


}
