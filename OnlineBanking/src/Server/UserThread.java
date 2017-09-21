package Server;

import Database.Database;
import Data.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.sql.SQLException;
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

    private Database db;

    public UserThread(Socket socket, Server server, Database db) {

        this.socket = socket;

        this.server = server;

        this.db = db;

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
                    String cnp = (String) readMessage();
                    String pass = (String) readMessage();
                    if (db.checkAccount(cnp, pass, 0)) {
                        sendMessage("ValidAccount");
                        sendMessage(db.getAccount(cnp));
                    } else {
                        sendMessage("InvalidAccount");
                    }
                    
                }

                if (message.equals("Transfer")) {

                }

                if (message.equals("ShowTransactions")) {

                }

                if (message.equals("CardPayment")) {

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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        close();
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

    public void close() {

        try {

            input.close();

            output.close();

            socket.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        }

    }
}
