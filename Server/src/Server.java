import zabirov.Phone;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started!");

            while (true)
                try (Phone phone = new Phone(server)) {
                    String request = phone.readLine();
                    System.out.println(request);
                    String response = (int) (Math.random() * 30 - 10) + "";
                    Thread.sleep(4000);
                    phone.writeLine(response);
                    System.out.println(response);

                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
