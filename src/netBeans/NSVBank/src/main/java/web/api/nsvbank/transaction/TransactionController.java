package web.api.nsvbank.transaction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Navjot Singh Virk
 * Date: 21st November 2016
 * Time: 4:02 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: 23rd November/2016 by Navjot at 9:23pm
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
   
}
