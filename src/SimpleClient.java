import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

 public static void start(String input){
     try{
         Socket clientSocket = new Socket("localhost", 3000);
         System.out.println("Connected to server!!!");
         PrintWriter output=new PrintWriter(clientSocket.getOutputStream(),true);
         output.println(input);  // Send user message to the server
         // Step 5: Close connections
         output.close();
         clientSocket.close();


     }catch(Exception e){System.out.println(e);}

 }



}

