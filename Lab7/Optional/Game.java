import java.util.ArrayList;
import java.util.List;
import java.util.Random;

        /*
        Firstly the board is created, afterwards the n tokens are added to the board having distinct values from 1 to m which are chosen randomly.
        Secondly the daemon thread is created for timekeeping and which stops the running of the players if the time is over.
        Finally the players are created and started. The main function has to join with the daemon in order to wait a given number of seconds for the game.
         */


public class Game {

    public static void main(String[] args) throws InterruptedException {
        Board board=new Board();
        int max_players,m,n,k;
        k=3;            //| size of the arithmetic progression
        max_players=1;  //| The number of players
        m=1000;         //| Maximum value of a token
        n=10;           //| Number of tokens
        for(int i=0;i<n;i++)
        {
            if(!board.addToken(new Token(m)))
                i--;
        }
        board.sort();
        board.print();
        long startTime = System.nanoTime();
        Thread timekeeper=new Thread(new DaemonTimeKeeper(100));
        timekeeper.setDaemon(true);
        timekeeper.start();
        List<Thread> threadList=new ArrayList<Thread>();
        for(int i=0;i<max_players;i++)
        {
            threadList.add(new Thread(new SmartPlayer("Player"+(i+1))));
        }
        threadList.add(new Thread(new ManualPlayer("Player"+(max_players+1))));
        for(int i=0;i<threadList.size();i++)
            threadList.get(i).start();
        timekeeper.join();

        System.out.println("Time elapsed: "+(float)(System.nanoTime()-startTime)/1000000000);
        System.exit(0);
    }
}
