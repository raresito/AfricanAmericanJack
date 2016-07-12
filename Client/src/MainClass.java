import java.io.IOException;


public class MainClass {
    public static void main (String[] argc) throws IOException, ClassNotFoundException {
        ClientClass client = new ClientClass("192.168.1.1", 69); // momentan ar trebui sa fim conectati
        client.run();
        try {
            client.play();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
