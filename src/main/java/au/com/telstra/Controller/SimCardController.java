package au.com.telstra.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.Entity.SimCardRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Sim")
public class SimCardController {

   
    private final RestTemplate restTemplate = new RestTemplate();
    private final String actuatorUrl = "http://localhost:8444/actuate";

    @PostMapping("/Activate")
    public ResponseEntity<String> activatesimcard(@RequestBody SimCardRequest request) {

        String iccid = request.getIccid();

        String actuatorPayload = "{ \"iccid\": \"" + iccid + "\" }";

        ResponseEntity<String> actuatorResponse = restTemplate.postForEntity(actuatorUrl, actuatorPayload, String.class);

        if(actuatorResponse.getBody().contains("\"Success\":true")){

            return ResponseEntity.ok("Activation Successful");
        }
        else{
            
            return ResponseEntity.status(500).body("Activation faild");
        }
       
    }
    

    

}
