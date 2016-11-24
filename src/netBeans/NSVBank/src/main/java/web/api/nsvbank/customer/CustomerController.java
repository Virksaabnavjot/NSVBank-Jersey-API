package web.api.nsvbank.customer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Navjot Singh Virk
 * Date: 21st November 2016
 * Time: 4:00 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: Wed 24th November/2016 by Soffyan at 11:00am
 */
public class CustomerController {
    List <Customer> customers;
    
    public CustomerController(){
        customers = new ArrayList();
    }
    
    public List<Customer> getCustomers() {
        Customer customer = new Customer();
        customers.add(customer);
        return customers;
    }
}
