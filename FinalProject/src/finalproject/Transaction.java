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
public class Transaction {
    private String Date;
    private String ToFrom;
    private int TransactionID;
    private ArrayList<TransactionLine> TransactionLines;
    
    
    //constructor
    public Transaction(String date1,String tofrom1,int transactionid1)
    {
     Date=date1;
     ToFrom=tofrom1;
     TransactionID=transactionid1;
     TransactionLines=new ArrayList<TransactionLine>();
    }
    
    //getter and setter start
    
    public String getDate() {
    return Date;
  }

  public void setDate(String date1) {
   Date=date1;
  }
  
      public String getToFrom() {
    return ToFrom;
  }

  public void setToFrom(String tofrom1) {
   ToFrom=tofrom1;
  }
    
  
      public int getTransactionID() {
    return TransactionID;
  }

  public void setTransactionID(int transactionid1) {
   TransactionID=transactionid1;
  }
  
      public ArrayList<TransactionLine> getTransactionLines() {
    return TransactionLines;
  }

  public void setTransactionLines(ArrayList<TransactionLine> lines) {
   TransactionLines=lines;
  }
  //getter and setter end
  
  
  //add new trnsaction line
  public void addTransactionLine(TransactionLine tl)
  {
      TransactionLines.add(tl);
  }
    
  //return zero for no amount else sum up al the transaction lines amount and return
 public double getAmount()
 {
     if(TransactionLines!=null)
     {
         int totalamount=0;
         for (int counter = 0; counter < TransactionLines.size(); counter++) 
         { 		      
          double currentamount=TransactionLines.get(counter).getAmount();
          totalamount+=currentamount;
         }    		
         return totalamount;

     }
     return 0;
 }
 
 
 //toString method
 public String toString()
 {
     return("    ID : "+TransactionID+" , Date : "+Date+" , To/From : "+ToFrom+" , Transaction Amount : "+getAmount()+" , Lines : ");
 }
  
}
