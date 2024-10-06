import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static String start(){
        String message="";
        try {
            //server Object
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Sever has started");

            //client socket   &    accepting clientSocket
            Socket clientSocket=serverSocket.accept();//should wait here for socket connection
            System.out.println("Client Connected");

            BufferedReader input=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            message = input.readLine();//should wait here for user interaction



            input.close();

            clientSocket.close();
            serverSocket.close();




        }catch(Exception e){System.out.println(e);}

        return message;
    }
}
