package rmi;

import java.rmi.Naming;

public class MyClient {
    public static void main(String args[]){
        try{
            Calculator3 stub=(Calculator3) Naming.lookup("rmi://localhost:3063/MyServer");
            System.out.println("The final velocity: " + stub.calculateV(30, 45, 1));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
