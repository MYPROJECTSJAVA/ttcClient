public class Main {

    public static void main(String[] args){
        Player p=new Player("X");

        Client c=new Client(p);


        c.start("192.168.5.244");

    }
}
