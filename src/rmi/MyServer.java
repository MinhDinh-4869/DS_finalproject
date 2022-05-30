package rmi;


import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MyServer{
    public static void main(String[] args) {
        try {
            Calculator3 stub = new Calculator3Remote();
            LocateRegistry.createRegistry(3063);
            Naming.rebind("rmi://localhost:3063/MyServer", stub);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}