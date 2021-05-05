/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author S542001
 */
public class TransactionLine {
    private String Category;
    private String Description;
    private double Amount;
    
    
    //constructor
     public TransactionLine(String category1,String description1,double amount1)
    {
     Category=category1;
     Description=description1;
     Amount=amount1;
    }   

     //getter and setter start
  public String getCategory() {
    return Category;
  }

  public void setCategory(String category1) {
       Category=category1;
  }
  
    public String getDescription() {
    return Description;
  }

  public void setDescription(String description1) {
       Description=description1;
  }
  
  public double getAmount() {
    return Amount;
  }

  public void setAmount(double amount1) {
       Amount=amount1;
  }
  
  //getter and setter end
           
  //toString method
  public String toString(){ 
  return("      Category : "+Category+" , Description : "+Description+" , Amount : "+Amount);

 } 
            
}
