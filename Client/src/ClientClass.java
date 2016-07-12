import java.io.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;


public class ClientClass {

    private Socket socket; // pentru conectare la server
    // informatii pt socket
    private int port ;
    private String ip;
    private ObjectInputStream input; // pentru a primi mesase de la server
    private ObjectOutputStream output; // pentru a trimite mesaje la server
    private int total;


    ClientClass(String ipToGet, int portToGet)
    {
        port = portToGet;
        ip = ipToGet;
    }
    public void play() throws ClassNotFoundException, IOException {

        String message;

        while((message = (String)input.readObject())!= "You Lost!")
        {
            Character c ;
            total = Integer.parseInt(message);
            System.out.printf("Totalul tau este %d ", total);
            System.out.println("Continue ? (y/n)");
            Scanner scan = new Scanner (System.in);
            c = (char) scan.nextInt();
            if (c == 'y')
                output.writeObject(c);
            else
                break;

        }
        message = (String)input.readObject();
        System.out.println(message);
    }
    public void run ()
    {
        try {
            int card1, card2;
            socket = new Socket(ip, port); // ne conectan la server
            System.out.println("Server connection done");
            //input = (ObjectInputStream) socket.getInputStream();
            // sus si jos sunt echivalente?
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
            card1 = (int)input.readObject();
            card2 = (int)input.readObject();
            System.out.printf("Your total is %d ", card1+card2);
            // Se disting doua cazuri :
            // 1. Jucatorul are sub 21 punctaj -> poate continua sau nu
            // 2. Jucatorul are peste 21 -> se opreste din joc


        }catch (Exception e)
        {

        }
    }

}
