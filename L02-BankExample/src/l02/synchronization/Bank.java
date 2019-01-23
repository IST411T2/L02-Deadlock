/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l02.synchronization;
import java.util.*;
/**
 *
 * @author adam
 */
public class Bank {
    private final double[] accounts;
    
    public Bank(int n, double initialbalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialbalance);
        
    }
    
    public void transfer(int from, int to, double amount){
        if(accounts[from] < amount) return;
        System.out.print(Thread.currentThread());
        accounts[from]-= amount;
        System.out.printf(" %10.2f from %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
    }
    
    public double getTotalBalance(){
        double sum = 0;
        for (double a: accounts){
            sum+=a;
        }
        
        return sum;
    }
    
    public int size(){
        return accounts.length;
    }
}
