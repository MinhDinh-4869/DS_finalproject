package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator2 extends Remote {
    public double calculateVy(double v0, double A, double T) throws RemoteException;
}
