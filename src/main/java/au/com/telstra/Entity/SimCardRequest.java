package au.com.telstra.Entity;


public class SimCardRequest {

    private String iccid;
    private String CustomerEmail;

    
    public String getIccid() {
        return iccid;
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
