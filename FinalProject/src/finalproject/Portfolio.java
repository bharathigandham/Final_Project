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
public class Portfolio {
    private String UserName;
    private ArrayList<Bank> Banks;
    
    //constructor
    public Portfolio(String username1)
    {
UserName=username1;
Banks=new ArrayList<Bank>();
    }
    
    //getter and setter start
    public String getUserName() {
    return UserName;
  }

  public void setUserName(String username1) {
   UserName=username1;
  }
  
    public ArrayList<Bank> getBanks() {
    return Banks;
  }

  public void setBankName(ArrayList<Bank> bankName1) {
   Banks=bankName1;
  }
  //getter and setter end
  
  //get all banks count
  public int getNumBanks()
  {
      return Banks.size();
  }
  
  
  //add a new bank to the banks arraylist
  public void addBank(Bank b)
  {
      Banks.add(b);
  }
  
  
  //return index of bank in Banks array list if present else return -1
  public int indexOfBank(String bankNameToFind)
  {
      int index=-1;
      for (int counter = 0; counter < Banks.size(); counter++) 
         { 		      
          Bank currentbank=Banks.get(counter);
          if(currentbank.getBankName().equals(bankNameToFind))
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
      return "";
  }
    
}
