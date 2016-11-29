package web.api.nsvbank.customer;

import java.util.Date;

/**
 *
 * @author Navjot Singh Virk
 * Date: Mon 21st November 2016
 * Time: 4:02 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: Wed 23rd November/2016 by Navjot at 7:58pm
 */

public class Customer {
    //declare data members
    int customerId;
    String name;
    String address;
    String email;
    String password;
    
    //constructor
    public Customer(){
        customerId = 0;
        name = "";
        address = "";
        email = "";
        password = "";
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
