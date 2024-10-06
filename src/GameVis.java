import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GameVis {
    static JButton[] Button;
    static ImageIcon cross = new ImageIcon("C:/Users/Avishkar Shrestha/Downloads/cross.jpeg");
    static ImageIcon zero = new ImageIcon("C:/Users/Avishkar Shrestha/Downloads/zero.jpeg");
    public static void createBoard(JFrame frame) {
        //maing a jframe


        // make various button components
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        // array to store all buttons

        Button = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};
        //set the buttons in an order using layout manager
        frame.setLayout(new GridLayout(3, 3));
        Arrays.stream(Button).forEach(x -> frame.add(x));
        frame.setSize(500, 500);
        frame.setLocation(100,100);

        // adding actionListeners and actionEvents to the buttons
        Arrays.stream(Button).forEach(button -> button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(button.getText());
                // make a client and join the server
                SimpleClient.start(button.getText());
            }
        }));
    }

    public static void setBoardVisible(JFrame frame, boolean b) {
        frame.setVisible(b);

    }
    public  void start() {

        JFrame frame = new JFrame("TICTACTOE");
        createBoard(frame);
        setBoardVisible(frame, true);


        // making player objects

    }

}
