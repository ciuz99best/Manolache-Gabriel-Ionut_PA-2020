public class Game {

    public static void main(String[] args) {
        Board board=new Board(10);
        for(int i=0;i<20;i++)
        {
            board.addToken(new Token(1000));
        }
        board.print();
        Thread t1 = new Thread(new Player("Player1"));
        Thread t2 = new Thread(new Player("Player2"));
        t1.start();
        t2.start();
    }
}
