package web.api.nsvbank.customer;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Navjot Singh Virk
 * Date: 21st November 2016
 * Time: 4:00 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: Wed 24th November/2016 by Soffyan at 11:00am
 * Modified by Valentin Buliga on 19 December 2016
 * Modified on: 19th December/2016 by Navjot at 7:18 pm
 * Modified on: 20th December/2016 by Navjot at 1:17 am
 */
public class CustomerController {
    List <Customer> customers;
    
    public CustomerController(){
        customers = new ArrayList();
    }
     
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Customer");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();        
 
    public List<Customer> retrieveCustomers() {
        return allEntries();
    }
    
    public List<Customer> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> rootEntry = cq.from(Customer.class);
        CriteriaQuery<Customer> all = cq.select(rootEntry);
        TypedQuery<Customer> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
        public Customer retrieveCustomer(int customerid) {
        Customer customer = em.find(Customer.class, customerid);
        em.close();
        return customer;
    }
    
    public Customer createCustomer(Customer c) { 
        Customer customer = em.find(Customer.class, c.getCustomerId());
        if (customer == null) {
            tx.begin();
            em.persist(c);
            tx.commit();
            
            em.close();
        }

        return c;
    }
    
    public void deleteCustomer(int customerid) {
        Customer customer = em.find(Customer.class, customerid);
        if (customer !=null) {
            tx.begin();
            em.remove(customer);
            tx.commit();
            
            em.close();
        }
    }
    
}
