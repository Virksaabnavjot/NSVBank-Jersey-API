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
 * Modified on: 23rd November/2016 by Navjot at 9:23 pm
 * Modified by Valentin Buliga on 19 December 2016
 * Modified on: 19th December/2016 by Navjot at 7:20 pm
 * Modified on: 20th December/2016 by Navjot at 1:22 am
 */
public class TransactionController {
    List <Transaction> transactions;
    
    public TransactionController(){
        transactions = new ArrayList();
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
        Transaction transaction = em.find(Transaction.class, transactionId);
        em.close();
        return transaction;
    }
    
    public Transaction createTransaction(Transaction t) { 
        Transaction transaction = em.find(Transaction.class, t.getTransactionId());
        if (transaction == null) {
            tx.begin();
            em.persist(t);
            tx.commit();
            
            em.close();
        }

        return t;
    }
   
    public void deleteTransaction(int id) {
        Transaction transaction = em.find(Transaction.class, id);
        if (transaction !=null) {
            tx.begin();
            em.remove(transaction);
            tx.commit();
            
            em.close();
        }
    }
   
}
