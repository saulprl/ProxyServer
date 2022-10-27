import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ProxyServerTest extends UnicastRemoteObject implements ReportGenerator {

    private static final long serialVersionUID = 3107413009881629428L;
    private static ArrayList<User> users = new ArrayList<>();

    protected ProxyServerTest() throws RemoteException {

    }

//    @Override
//    public ArrayList<User> getUsers() throws RemoteException {
//        return users;
//    }

    @Override
    public void addUser(User user) throws RemoteException {
        for (User u : users) {
            if (user.getUser().equals(u.getUser())) {
                return;
            }
        }

        users.add(user);
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(9001);
            ReportGenerator reportGenerator = new ProxyServerTest();
            registry.rebind("PizzaCoRemoteGenerator", reportGenerator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
