package Client;

import GUI.mainWindow.mainWindow;
import Data.User;
import javafx.application.Platform;

import java.util.ArrayList;

/**
 *
 * @author Anchidin Bogdan
 */
public class MessageProcessor {

    public static Client client;

    private mainWindow window = new mainWindow();

    public MessageProcessor(Client client) {

        this.client = client;

        window.start(client);

    }

    public void process(Object messageReceived) {
        if (messageReceived.equals("ValidAccount")) {
            window.p1.setVisible(false);
            mainWindow.makep2Visible();
        } else if (messageReceived.equals("InvalidAccount")) {
            mainWindow.p1.showLabel();
            System.out.println("InvalidAccount");
        }
        
        if(messageReceived instanceof ArrayList<?> && ((ArrayList) messageReceived).get(0) instanceof String){
            if(((ArrayList<String>)messageReceived).get(0).equals("User")){
                String cnp = ((ArrayList<String>)messageReceived).get(1);
                String bankAccount = ((ArrayList<String>)messageReceived).get(2);
                String firstName = ((ArrayList<String>)messageReceived).get(3);
                String lastName = ((ArrayList<String>)messageReceived).get(4);
                String password = ((ArrayList<String>)messageReceived).get(5);
                Integer amountOfMoney = Integer.getInteger(((ArrayList<String>)messageReceived).get(6));
                Client.user = new User();
                Client.user.setCNP(cnp);
            }
            
        }
    }
}
