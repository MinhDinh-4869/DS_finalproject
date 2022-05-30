package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator2Remote extends UnicastRemoteObject implements Calculator2 {
    public Calculator2Remote() throws RemoteException
    {
        super();
    }

    public double calculateVy(double v0, double A, double T) throws RemoteException
    {
        double radian = Math.toRadians(A);
        return (v0*Math.sin(radian) - 9.81*T);
    }
}
