//Project Github: https://github.com/Virksaabnavjot/NSVBank
//The project may contains code snippets from examples available on Moodle.
package web.api.nsvbank;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import web.api.nsvbank.account.Account;
import web.api.nsvbank.account.AccountController;
import web.api.nsvbank.customer.Customer;
import web.api.nsvbank.customer.CustomerController;
import web.api.nsvbank.transaction.Transaction;
import web.api.nsvbank.transaction.TransactionController;

/**
 *
 * @author Navjot Singh Virk
 * Date: 21st November 2016
 * Time: 4:02 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: 23rd November/2016 by Navjot at 9:02pm, 9:39pm
 * Modified on: Wed 24th November/2016 by Soffyan at 11:00am
 * Modified on: 19th December/2016 by Navjot at 5:20pm
 */

@Path("bank")
@Produces("application/json")
public class NSVBankWebServiceAPI {
    public static final String bankName = "NSV Bank Ireland";
    @GET
    @Path("/")
    @Produces("application/json")
    public Response test(@Context UriInfo info){
        List <String> list = new ArrayList<>();
        String text = "You can use our online banking.Have a Good Day!!!!";
        list.add(bankName);
        list.add(text);
        Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson(list)).build();
    }
    
    @GET
    @Path("/accounts")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> accounts(){
        AccountController accountController = new AccountController();
        List <Account> accounts = accountController.getAccounts();
        return accounts;
    }
    
    @GET
    @Path("/transactions")
    @Produces("application/json")
    public Response transactions(@Context UriInfo info){
        TransactionController transactionController = new TransactionController();
        List <Transaction> transactions = transactionController.getTransactions();
        Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson(transactions)).build();
    }
    
    @GET
    @Path("/customers")
    @Produces("application/json")
    public Response customers(@Context UriInfo info){
        CustomerController customerController = new CustomerController();
        List <Customer> customers = customerController.getCustomers();
        Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson(customers)).build();
    }
    
    
    //===========================================
    //=         REST API methods for Customers
    //===========================================
    
    CustomerController customerController = new CustomerController();
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/customers")
    public List<Customer> listCustomers() {
        List <Customer> customers = customerController.retrieveCustomers();
        return customers;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("customers/{id}")
    public Customer getCustomer(@PathParam("id") int id) {
        return customerController.retrieveCustomer(id);
    }
    
    @POST
    @Path("/customers")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Customer saveCustomer(Customer customer) {
        return customerController.createCustomer(customer);
    }
    
    @DELETE
    @Path("/customers/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeCustomer(@PathParam("id") int id) {
        customerController.deleteCustomer(id);
    }
    
    //===========================================
    //=         REST API methods for Accounts
    //===========================================

    AccountController accountController = new AccountController();
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/accounts")
    public List<Account> listAccounts() {
        List <Account> accounts = accountController.retrieveAccounts();
        return accounts;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("accounts/{id}")
    public Account getAccount(@PathParam("id") int id) {
        return accountController.retrieveAccount(id);
    }
    
    @POST
    @Path("/accounts")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Account saveAccount(Account account) {
        return accountController.createAccount(account);
    }
    
    @DELETE
    @Path("/accounts/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeBook(@PathParam("id") int id) {
        accountController.deleteAccount(id);
    }
   
    
    //===========================================
    //=    REST API methods for Transactions
    //===========================================
    
    TransactionController transactionController = new TransactionController();
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/transactions")
    public List<Transaction> listTransactions() {
        List <Transaction> transactions = transactionController.retrieveTransactions();
        return transactions;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("transactions/{id}")
    public Transaction getTransaction(@PathParam("id") int id) {
        return transactionController.retrieveTransaction(id);
    }
    
    @POST
    @Path("/transactions")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Transaction saveTransaction(Transaction transaction) {
        return transactionController.createTransaction(transaction);
    }
    
    /** Since, the transactions are kept for life we have excluded this delete method
    @DELETE
    @Path("/transactions/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeTransaction(@PathParam("id") int id) {
        transactionController.deleteTransaction(id);
    }
    **/
    
}
