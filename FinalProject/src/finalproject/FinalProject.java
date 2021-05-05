/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author S542001
 */
public class FinalProject {

       //check whether bank exists in Portfolio object
    //if present return that object else create new bank object and return
    public static Bank checkForBank(Portfolio object,String[] record)
    {
        if(object.getBanks().size()==0 || object.indexOfBank(record[0])==-1)
        {
            Bank newbank= new Bank(record[0]);
            object.addBank(newbank);
            return newbank;
        }
        else 
        {
            int index=object.indexOfBank(record[0]);
            Bank bankobject= object.getBanks().get(index);
            return bankobject;
            
        }
    }
    
    
    
    //check whether account present in bank
    //if present then check whether transaction exists
    //if transaction present then add transactionline and return account object
    public static Account checkForAccount(Bank object,String[] record)
    {
        //if account not present then
        if(object.getAccounts().size()==0 || object.IndexOfAccount(record[1])==-1)
        {
            //create transactionline object
            //create transaction object and add transactionline objects inside transaction
            //add this transaction to account object
            //add account object to bank object
            
            TransactionLine lineobject=new TransactionLine(record[7],record[9],Double.parseDouble(record[10]));
            Transaction transactionobject=new Transaction(record[3], record[4],Integer.parseInt(record[2]));
            transactionobject.addTransactionLine(lineobject);
            
            ArrayList<Transaction> Transactions=new ArrayList<Transaction>();
            Transactions.add(transactionobject);                        
            Account accountobject=new Account(record[1], Transactions);
            object.addAccount(accountobject);
            return accountobject;
        }
        
        //if account present
        else
        {
            int index=object.IndexOfAccount(record[1]);
            Account accountobject=object.getAccounts().get(index);
            
            //if account do not have this transaction
            //add this transaction and transactionline
            if(accountobject.getTransactions().size()==0|| accountobject.indexOfTransaction(record[2])==-1)
            {
                TransactionLine lineobject=new TransactionLine(record[7],record[9],Double.parseDouble(record[10]));
                Transaction transactionobject=new Transaction(record[3], record[4],Integer.parseInt(record[2]));
                transactionobject.addTransactionLine(lineobject);
                accountobject.addTransaction(transactionobject);
                return accountobject;
            }
            // account object have this transaction. Then simply add the transaction line to it and update the transaction details
            else
            {
                //Transaction transobject=accountobject.getTransaction(Integer.parseInt(record[2]));
                int index1=accountobject.indexOfTransaction(record[2]);
                Transaction transobject=accountobject.getTransactions().get(index1);
                TransactionLine lineobject=new TransactionLine(record[7],record[9],Double.parseDouble(record[10]));
                transobject.addTransactionLine(lineobject);
                transobject.setDate(record[3]);
                transobject.setToFrom(record[4]);
                return accountobject;
                
            }
                        
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try
        {
            Portfolio portobject=new Portfolio("Bharathi");
        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/S542001/Downloads/transactions.csv"));
String line = null;
int linenumber=1;
String bankname="";
Account accountobject=null;

//read line by line for CSV file
while ((line = reader.readLine()) != null) 
{
    //ignore the first line as it just have headings
    if(linenumber==1)
    {
        linenumber++;
        continue;
    }
    
   //Split each line by comma
String[] record = line.split(",");


// Check whether bank exists in Portfolio. If exists then just get the object else create a new 
// bank object and add this object to the Banks array list of Portfolio
Bank bankobject= checkForBank(portobject,record);

//Check for the account object exists in the bank object. If not exists then create
accountobject=checkForAccount(bankobject,record);

linenumber++;
}

//print each transaction line of each transaction for every account of each bank present in the portfolio
for (int counter = 0; counter < portobject.getBanks().size(); counter++) 
         { 		      
          Bank currentbank=portobject.getBanks().get(counter);
         System.out.println(currentbank.toString());
         
         
         for(int counter1=0;counter1<currentbank.getAccounts().size();counter1++)
         {
             Account currentaccount=currentbank.getAccounts().get(counter1);
             System.out.println(currentaccount.toString());
             
               for(int counter2=0;counter2<currentaccount.getTransactions().size();counter2++)
               {
                   Transaction currenttransaction=currentaccount.getTransactions().get(counter2);
                   System.out.println(currenttransaction.toString());
                   
                   for(int counter3=0;counter3<currenttransaction.getTransactionLines().size();counter3++)
                   {
                       TransactionLine currenttransactionline=currenttransaction.getTransactionLines().get(counter3);
                       System.out.println(currenttransactionline.toString());
                       
                   }
               }
         }
         System.out.println();
         System.out.println("-------------------------------------------------------------------");
         System.out.println();
         }
        

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
    }

}
