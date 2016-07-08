package server;

import server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Serverthread implements Runnable{

    private Socket socketClient;
    private Server server;

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    private volatile boolean wait;

    Serverthread(Socket socketClient, Server server){

        this.socketClient = socketClient;
        this.server = server;
        wait = true;
    }
    @Override
    public void run() {
        try {
            objectOutputStream = new ObjectOutputStream(socketClient.getOutputStream());
            objectOutputStream.flush();
            objectInputStream = new ObjectInputStream(socketClient.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ObjectOutputStream getObjectOutputStream(){
        return objectOutputStream;
    }

    public void close(){
        try {
            objectInputStream.close();
            objectOutputStream.close();
            socketClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
