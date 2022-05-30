package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Calculator3 extends Remote{
    public double calculateV(double v0, double A, double T) throws RemoteException;
}

