/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02.synchronization;

/**
 *
 * @author adam
 */
public class L02Synchronization {

    /**
     * @param args the command line arguments
     */
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY= 10;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        System.out.println("Bank Created");
        for(int x=0;x<NACCOUNTS;x++){
            //System.out.println("Account #"+x);
            int fromAccount = x;
            
            Runnable r= () ->{
                try{
                    while(true){
                        int toAccount= (int)(bank.size() * Math.random());
                        
                        double amount = MAX_AMOUNT * Math.random();
                        //System.out.println("Transferring $"+amount+" from #"+fromAccount+" to #"+toAccount);
                        
                        bank.transfer(fromAccount, toAccount, amount);
                        //System.out.println("Total Balance: "+bank.getTotalBalance());
                        int sleep= (int) (DELAY * Math.random());
                        //System.out.println("Sleeping for "+sleep);
                        Thread.sleep(sleep);
                    }
                }catch(InterruptedException e){
                    System.out.println("Caught: "+e.getMessage());
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    
    }
    
}
