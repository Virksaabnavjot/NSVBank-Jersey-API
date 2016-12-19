package web.api.nsvbank.transaction;

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
 * Time: 4:02 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: 23rd November/2016 by Navjot at 9:23pm
 * Modified by Valentin Buliga on 19 December 2016
 */
public class TransactionController {
    List <Transaction> transactions;
    
    public TransactionController(){
        transactions = new ArrayList();
    }

    public List<Transaction> getTransactions() {
        Transaction transaction = new Transaction();
        transactions.add(transaction);
        return transactions;
    }
    
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Transaction");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();        
    

    public List<Transaction> retrieveTransactions() {
        return allEntries();
    }
    
    public List<Transaction> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);
        Root<Transaction> rootEntry = cq.from(Transaction.class);
        CriteriaQuery<Transaction> all = cq.select(rootEntry);
        TypedQuery<Transaction> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
    public Transaction retrieveTransaction(int transactionId) {
        Transaction test = em.find(Transaction.class, transactionId);
        em.close();
        return test;
    }
    
    public Transaction createTransaction(Transaction b) { 
        Transaction test = em.find(Transaction.class, b.getTransactionId());
        if (test == null) {
            tx.begin();
            em.persist(b);
            tx.commit();
            
            em.close();
        }

        return b;
    }
   
        

    public void deleteTransaction(int id) {
        Transaction test = em.find(Transaction.class, id);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            
            em.close();
        }
    }
   
}
