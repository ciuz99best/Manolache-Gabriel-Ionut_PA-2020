import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.util.concurrent.locks.ReentrantLock;

        /*
        lock variable is used by the players when they print their tokens, avoiding multiple players printing at the same time.

        run is the global variable between the players which means that the game is running and there are still tokens on the board
        and the time has not exceeded.

        turn is a global variable between players that contains the id of the player which has the current turn
         */

public abstract class Player implements Runnable {
    protected int id;
    protected String name;
    protected static volatile ReentrantLock lock=new ReentrantLock();
    protected static volatile int turn=0,id_max=0,run=1;
    protected List<Token> tokenSet= new ArrayList<>();
    Player()
    {

    }
    public static void setRun(boolean bool)
    {
        if(bool)
            run=1;
        else
            run=0;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public void print()
    {
        System.out.print(name+"- "+tokenSet.size()+": ");
        for (Token token : tokenSet)
            System.out.print(token.getNumber() + " ");
        System.out.println();
    }
    @Override
    public abstract void run();
}
