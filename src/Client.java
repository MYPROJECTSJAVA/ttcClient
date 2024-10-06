import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.Integer.parseInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

    public  class Client {
        Player pHome;
        GameVis gameVis;
        static ImageIcon cross = new ImageIcon("C:/Users/Avishkar Shrestha/Downloads/cross.jpeg");
        static ImageIcon zero = new ImageIcon("C:/Users/Avishkar Shrestha/Downloads/zero.jpeg");
        public Client(Player p){

            pHome=p;
            gameVis=new GameVis();
        }
        public void start(String serverIp){
            gameVis.start();//makes the gui visible and continuous
            try{
                Socket clientSocket = new Socket(serverIp, 6000);
                System.out.println("Connected to server!!!");

                BufferedReader input=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output=new PrintWriter(clientSocket.getOutputStream(),true);
                output.println(pHome.letter);//registering player

                // Step 4: Read and display the response from the server
                new Thread(() -> {
                    try {
                        String messageFromServer;
                        while ((messageFromServer = input.readLine()) != null) {
                            //send the messageFromServer to the GameVis
                            if(messageFromServer=="O" || messageFromServer =="X" || messageFromServer=="OX"){
                                clientSocket.close();
                            }
                            else if(messageFromServer.length()==2) {
                                gameVis.Button[((int) messageFromServer.charAt(0)) - 48 - 1].setIcon('X' == messageFromServer.charAt(1) ? cross : zero);
                            }

                            System.out.println("Server: " + messageFromServer);
                        }
                    } catch (IOException e) {
                        System.out.println("Connection lost. Exiting listener thread.");
                    }
                }).start();

                String userMessage;//takes input from the gui
                while (true) {
                    //create a server and wait for client to join
                    userMessage = SimpleServer.start();
                    System.out.println("The simpleclient connection works "+userMessage);// Read user input
                    output.println(userMessage);  // Send user message to the server NEXT COMPUTER
                    if (userMessage.equalsIgnoreCase("exit")) {
                        break;  // Exit loop if user types "exit"
                    }
                }





                // Step 5: Close connections

                input.close();
                output.close();
                clientSocket.close();


            }catch(Exception e){System.out.println(e);}
        }

        public static void main(String [] args){

        }
    }
