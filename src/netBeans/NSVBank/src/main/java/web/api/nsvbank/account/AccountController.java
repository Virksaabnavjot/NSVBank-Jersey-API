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
 */
public class AccountController {
    List <Account> accounts;
    
    public AccountController(){
        accounts = new ArrayList<>();
    }

    public Account getAccount() {
        Account account = new Account();
        TransactionController transactionController = new TransactionController();
        account.setAccountNumber(123456789);
        account.setCurrentBalance(299.89);
        account.setSortCode("NSV1298");
        account.setTransactions(transactionController.getTransactions());
        //accounts.add(account);
        return account;
    }

    public List<Account> getAccounts() {
        Account account = getAccount();
        accounts.add(account);
        accounts.add(account);
        return accounts;
    }
   
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
  
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
        Account test = em.find(Account.class, id);
        em.close();
        return test;
    }
    
    public Account createAccount(Account b) { 
        Account test = em.find(Account.class, b.getId());
        if (test == null) {
            tx.begin();
            em.persist(b);
            tx.commit();
            
            em.close();
        }

        return b;
    }
       
    public Account UpdateAccount(Account b, int id) { 
        Account test = em.find(Account.class, id);
        if (test != null) {
            tx.begin();
            em.remove(test);
            em.persist(b);
            tx.commit();
            em.close();
        }

        return b;
    }
    
    
    public void deleteAccount(int id) {
        Account test = em.find(Account.class, id);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            
            em.close();
        }
    }
    
}
