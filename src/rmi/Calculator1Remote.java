package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class Calculator1Remote extends UnicastRemoteObject implements Calculator1 {
    Calculator1Remote()throws RemoteException{
        super();
    }
    public double calculateVx(double v0, double A) throws RemoteException
    {
        double radian = Math.toRadians(A);
        return v0*Math.cos(radian);
    }
}
