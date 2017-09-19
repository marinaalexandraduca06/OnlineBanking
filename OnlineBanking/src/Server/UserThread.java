package Server;

import data.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anchidin Bogdan
 */
public class UserThread implements Runnable {

    private ObjectOutputStream output;

    private ObjectInputStream input;

    private Socket socket;

    private Server server;
    
    private User user;

    public UserThread(Socket socket, Server server) {

        this.socket = socket;

        this.server = server;

    }

    @Override

    public void run() {

        try {

            input = new ObjectInputStream(socket.getInputStream());

            output = new ObjectOutputStream(socket.getOutputStream());

            output.flush();

            Object message = "";

            // sendMessage("Congratulation! It works!");
            while (true) {

                // sendMessage("Say something except Finish");
                message = readMessage();

                if (message.equals("LogIn")) {
                    String correctPass = Arrays.toString("dada".toCharArray());
                    Object userName = readMessage();
                    Object pass = readMessage();
                    if (correctPass.equals(pass)) {
                        sendMessage("ValidAccount");
                        user = new User();
                    } else {
                        sendMessage("InvalidAccount");
                    }
                }
                
                if(message.equals("Transfer")){
                    
                }
                
                if(message.equals("ShowTransactions")){
                    
                }
                
                if(message.equals("CardPayment")){
                    
                }

                if (message.equals("CloseApp")) {
                    sendMessage("CloseApp");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public Object readMessage() throws IOException, ClassNotFoundException {

        return input.readObject();

    }

    public void sendMessage(Object message) {

        try {

            output.writeObject(message);

            output.flush();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
