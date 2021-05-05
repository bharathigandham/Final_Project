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
public class Bank {
    private String BankName;
    private ArrayList<Account> Accounts;
    public Bank(String BankName1)
    {
BankName=BankName1;
Accounts=new ArrayList<Account>();
    }
    
    //getter and setter start
      public String getBankName() {
    return BankName;
  }

  public void setBankName(String bankName1) {
   BankName=bankName1;
  }
  
    public ArrayList<Account> getAccounts() {
    return Accounts;
  }

  public void setAccounts(ArrayList<Account> accounts1) {
   Accounts=accounts1;
  }
  
  //getter and setter end
  
  
  //add new account to accounts arraylist
  public void addAccount(Account a)
  {
      Accounts.add(a);
  }
  
  //return index of account object in accounts array list if present else return -1
  public int IndexOfAccount(String accountToFind)
  {
      int index=-1;
      for (int counter = 0; counter < Accounts.size(); counter++) 
         { 		      
          Account currentAccount=Accounts.get(counter);
          if(currentAccount.getAccountName().equals(accountToFind))
          {
              index=counter;
              break;
          }
         }
      return index;
  }
  
  
  //toString method
  public String toString()
  {
      
      return("Bank : "+BankName+", Accounts : ");
  }
    
}
