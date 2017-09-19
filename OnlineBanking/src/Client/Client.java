package Client;

import java.io.IOException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import java.net.Socket;
import GUI.mainWindow.mainWindow;
import data.User;

/**
 *
 * @author Anchidin Bogdan
 */
public class Client {

    private String IP;

    private int port;

    private Socket socket;

    private ObjectInputStream input;

    private ObjectOutputStream output;

    private Object message;

    private MessageProcessor processor;
    
    public User user;

    public Client(String IP, int port) {

        this.IP = IP;

        this.port = port;

        this.processor = new MessageProcessor(this);

    }

    public void connectToServer() {

        try {

            socket = new Socket(IP, port);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void setUpStreams() {

        try {

            output = new ObjectOutputStream(socket.getOutputStream());

            output.flush();

            input = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public void start() {

        connectToServer();

        setUpStreams();

        System.out.println("You are connected!!");

        final Thread thread = new Thread(new Runnable() {

            @Override

            public void run() {

                while (true) {

                    try {

                        message = input.readObject();

                        if (message.equals("CloseApp")) {
                            break;
                        }

                        processor.process(message);

                    } catch (ClassNotFoundException e) {

                        e.printStackTrace();

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                }

                close();

            }

        });

        thread.start();

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

            output.close();

            input.close();

            socket.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
