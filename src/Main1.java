public class Main1 {

    public static void main(String[] args){
        Player p=new Player("O");

        Client c=new Client(p);


        c.start("192.168.5.244");

    }
}
