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
        Customer test = em.find(Customer.class, customerid);
        em.close();
        return test;
    }
    
    public Customer createCustomer(Customer b) { 
        Customer test = em.find(Customer.class, b.getCustomerId());
        if (test == null) {
            tx.begin();
            em.persist(b);
            tx.commit();
            
            em.close();
        }

        return b;
    }
    
    public void deleteCustomer(int customerid) {
        Customer test = em.find(Customer.class, customerid);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            
            em.close();
        }
    }
    
}
