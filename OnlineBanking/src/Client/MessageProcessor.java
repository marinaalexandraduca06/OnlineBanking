package Client;

import GUI.mainWindow.mainWindow;
import javafx.application.Platform;

import java.util.ArrayList;

/**
 *
 * @author Anchidin Bogdan
 */
public class MessageProcessor {

    private Client client;

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
            System.out.println("InvalidAccount");
        }
    }
}
