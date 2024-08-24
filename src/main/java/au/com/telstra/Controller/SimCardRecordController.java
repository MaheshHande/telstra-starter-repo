package au.com.telstra.Controller;

import org.springframework.http.ResponseEntity;

import au.SimCardRepo.SimCardRepo;
import au.com.telstra.Entity.SimCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/simcards")
public class SimCardRecordController {

    @Autowired
    private SimCardRepo repository;

    @PostMapping("/activate")
    public ResponseEntity<String> activateSimCard(@RequestParam String email, @RequestParam String iccid) {
        // Send the ICCID to the SimCardActuator and get the activation result (Simulated here)
        boolean activationResult = sendActivationRequest(iccid);

        // Save the result to the database
       SimCardRequest record = new SimCardRequest();
        record.setIccid(iccid);
        record.setCustomerEmail(email);
        record.setActivate(activationResult);

        repository.save(record);

        return ResponseEntity.ok("SIM Card activation processed");
    }

    @GetMapping("/{simCardId}")
    public ResponseEntity<?> getSimCardRecord(@PathVariable Long simCardId) {
        Optional<SimCardRequest> record = repository.findById(simCardId);
        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Simulate sending request to SimCardActuator and getting result
    private boolean sendActivationRequest(String iccid) {
        // Simulate a response from the actuator
        return Math.random() > 0.5;  // Randomly returns true or false
    }
}


    
   
    


