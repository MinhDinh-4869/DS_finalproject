package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {
    public static void main(String args[]){
        try{
            Registry reg = LocateRegistry.getRegistry("192.168.1.17", 8080);
            Calculator1 stub=(Calculator1) reg.lookup("Server1");
            //Calculator1 stub=(Calculator1) Naming.lookup("rmi://192.168.1.17/Server1");
            System.out.println("The final velocity: " + stub.calculateVx(13, 12));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
