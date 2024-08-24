package au.com.telstra.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SimCardRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iccid;
    private String CustomerEmail;


    public Long getId() {
        return id;
    }
    public boolean isActivate() {
        return activate;
    }
    private boolean activate;
    
    public String getIccid() {
        return iccid;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setActivate(boolean activate) {
        this.activate = activate;
    }
    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
    public String getCustomerEmail() {
        return CustomerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

}
