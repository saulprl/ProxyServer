import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ReportGenerator extends Remote {

    //public ArrayList<User> getUsers() throws RemoteException;
    public void addUser(User user) throws RemoteException;

}
