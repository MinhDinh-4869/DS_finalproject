package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator3Remote extends UnicastRemoteObject implements Calculator3 {
    double result1 = 0;
    double result2 = 0;

    public Calculator3Remote() throws RemoteException
    {
        super();
    }

    public double calculateV(double v0, double A, double T) throws RemoteException
    {
        double result = 0;
        try {
            Thread thread1 = new Thread(new VxCalculator(v0, A));
            Thread thread2 = new Thread(new VyCalculator(v0, A, T));


            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            result = Math.sqrt(result1*result1 +result2*result2);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    class VxCalculator implements Runnable{
        public VxCalculator(double v0, double A)
        {
            this.v0 = v0;
            this.A = A;
        }
        private double v0;
        private double A;
        public void run()
        {
            System.out.println("vx is running");
            try {
                Calculator1 stub=(Calculator1) Naming.lookup("rmi://192.168.1.24/Server1");
                result1 = stub.calculateVx(v0, A);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class VyCalculator implements Runnable{
        public VyCalculator(double v0, double A, double T)
        {
            this.v0 = v0;
            this.A = A;
            this.T = T;
        }
        private double v0;
        private double A;
        private double T;
        public void run()
        {
            System.out.println("vy is running");
            try {
                Calculator2 stub=(Calculator2) Naming.lookup("rmi://192.168.1.24/Server2");
                result2 = stub.calculateVy(v0, A, T);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}