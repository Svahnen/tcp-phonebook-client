import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//Client getting messages from user and sending to server 

public class Client {

    Client() {
        String hostName = "127.0.0.1"; // localhost
        int portNumber = 12345;

        try (
                Socket addressSocket = new Socket(hostName, portNumber);
                BufferedReader in = new BufferedReader(new InputStreamReader(addressSocket.getInputStream()));
                PrintWriter out = new PrintWriter(addressSocket.getOutputStream(), true);) {
            String fromUser;
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("What name do you want to search for?");

            while ((fromUser = stdIn.readLine()) != null) {

                System.out.println("What name do you want to search for?");
                if (fromUser != null) {
                    out.println(fromUser);
                }
                String inputLine;

                inputLine = in.readLine();
                if (inputLine != null) {
                    System.out.println("Server: " + inputLine);
                }
                inputLine = null;
                fromUser = null;
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}