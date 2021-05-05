/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;

/**
 *
 * @author S542001
 */
public class Account {
    private String Accountname;
    private ArrayList<Transaction> Transactions;
   
    //constructor
    public Account(String accountname1,ArrayList<Transaction> transactions1)
    {
Accountname=accountname1;
Transactions=transactions1;
    }
    
    //getter and setter start
     public String getAccountName() {
    return Accountname;
  }

  public void setAccountName(String accountname1) {
   Accountname=accountname1;
  }
  
   public ArrayList<Transaction> getTransactions() {
    return Transactions;
  }

  public void setTransactions(ArrayList<Transaction> transactions1) {
   Transactions=transactions1;
  }
  
  //getter and setter end
  
  //This add a transaction to transactions arraylist
  public void addTransaction(Transaction t)
  {
    Transactions.add(t);
  }
 
  
  
  //return index of transacton in the transactions array list if present else return -1
  
  public int indexOfTransaction(String transIDToFind)
  {
      int returnindex=-1;
      for (int counter = 0; counter < Transactions.size(); counter++) 
         { 		      
          Transaction currenttransaction=Transactions.get(counter);
          if(String.valueOf(currenttransaction.getTransactionID()).equals(transIDToFind))
          {
              returnindex=counter;
              break;
          }
         }
      return returnindex;
  }
  
  //sum up all the transactions amount and return
  public double getAccountBalance()
  {
      double totalamount=0;
       for (int counter = 0; counter < Transactions.size(); counter++) 
         { 		      
          Transaction currenttransaction=Transactions.get(counter);
          ArrayList<TransactionLine> currenttransactionlines=currenttransaction.getTransactionLines();
          for(int counter1=0;counter1<currenttransactionlines.size();counter1++)
          {
              totalamount+=currenttransactionlines.get(counter1).getAmount();
          }
         }
       return totalamount;
  }
  
  
  //toString method
   public String toString(){ 
       return("  Account : "+Accountname+"Account"+" Balance : "+getAccountBalance()+" , Transactions : ");
 } 
    
}