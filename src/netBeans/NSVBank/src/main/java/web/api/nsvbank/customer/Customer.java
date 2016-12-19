package web.api.nsvbank.customer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Navjot Singh Virk
 * Date: Mon 21st November 2016
 * Time: 4:02 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: Wed 23rd November/2016 by Navjot at 7:58 pm
 * Modified on: Mon 19th December/2016 by Navjot at 6:50 pm
 */

@Entity
@Table
@XmlRootElement
public class Customer implements Serializable{
    //declare data members

    @Id
    //    @GeneratedValue(strategy = GenerationType.TABLE)
    private int customerId;
    private String name;
    private String address;
    private String email;
    private String password;

    //constructor
    public Customer(int customerId, String name, String address, String email, String password) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }
    
    //Setters and Getters
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
