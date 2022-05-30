package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Calculator1 extends Remote{
    public double calculateVx(double v0, double A) throws RemoteException;
}

