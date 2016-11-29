package web.api.nsvbank.account;

import java.util.ArrayList;
import java.util.List;
import web.api.nsvbank.transaction.TransactionController;

/**
 *
 * @author Navjot Singh Virk
 * Date: 21st November 2016
 * Time: 4:00 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: 23rd November/2016 by Navjot at 8:58pm
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
  
}
