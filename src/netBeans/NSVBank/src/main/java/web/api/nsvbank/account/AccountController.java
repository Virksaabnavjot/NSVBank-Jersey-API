package web.api.nsvbank.account;

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
import web.api.nsvbank.transaction.TransactionController;

/**
 *
 * @author Navjot Singh Virk
 * Date: 21st November 2016
 * Time: 4:00 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: 23rd November/2016 by Navjot at 8:58pm
 * Modified by Valentin Buliga on 19 December 2016
 * Modified on: 19th December/2016 by Navjot at 7:12 pm
 */
public class AccountController {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Account");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    
    
    public List<Account> retrieveAccounts() {
        return allEntries();
    }
    
    public List<Account> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Account> cq = cb.createQuery(Account.class);
        Root<Account> rootEntry = cq.from(Account.class);
        CriteriaQuery<Account> all = cq.select(rootEntry);
        TypedQuery<Account> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
    public Account retrieveAccount(int id) {
        Account account = em.find(Account.class, id);
        em.close();
        return account;
    }
    
    public Account createAccount(Account a) { 
        Account account = em.find(Account.class, a.getId());
        if (account == null) {
            tx.begin();
            em.persist(a);
            tx.commit();
            
            em.close();
        }

        return a;
    }
       
    public Account UpdateAccount(Account a, int id) { 
        Account account = em.find(Account.class, id);
        if (account != null) {
            tx.begin();
            em.remove(account);
            em.persist(a);
            tx.commit();
            em.close();
        }

        return a;
    }
    
    public void deleteAccount(int id) {
        Account account = em.find(Account.class, id);
        if (account !=null) {
            tx.begin();
            em.remove(account);
            tx.commit();
            
            em.close();
        }
    }
    
}
