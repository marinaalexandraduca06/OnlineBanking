package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.ServerSocket;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anchidin Bogdan
 */
public class Server {

    private static ServerSocket serverSocket;

    private static Socket clientSocket;

    private final int portNumber = 9999;

    private ExecutorService threadPool;

    private UserThread teacherThread;

    public Server() {

        try {
            threadPool = Executors.newCachedThreadPool();

            serverSocket = new ServerSocket(portNumber);

        } catch (IOException ioe) {

            ioe.printStackTrace();

        }

    }

    public void start() {

        System.out.println("Waiting...");

        while (true) {

            try {

                clientSocket = serverSocket.accept();

                teacherThread = new UserThread(clientSocket, this);

                threadPool.execute(teacherThread);

                System.out.println("A client has connected");

            } catch (IOException e) {

                System.out.println("No more clients can connect!");

            }
        }

    }

}
