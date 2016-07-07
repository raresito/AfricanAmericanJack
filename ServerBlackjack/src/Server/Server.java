package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;

    private ExecutorService executorService;

    private int port;
    ArrayList<Serverthread> threads;

    Server() {

        port = 7777;
        threads = new ArrayList<Serverthread>();

        executorService = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        for(int i=0; i<4; i++)
        {
            try {
                socket = serverSocket.accept();
                threads.add(new Serverthread(socket, this));
                executorService.execute(threads.get(threads.size()-1));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
