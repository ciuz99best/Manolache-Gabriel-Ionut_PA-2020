import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.util.concurrent.locks.ReentrantLock;

public class Player implements Runnable {
    private String name;
    private static volatile ReentrantLock lock=new ReentrantLock();
    private static volatile int counter=0;
    private List<Token> tokenSet= new ArrayList<>();
    Player(String name)
    {
        this.name=name;
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
        System.out.print(name+" ");
        for (Token token : tokenSet)
            System.out.print(token.getNumber() + " ");
        System.out.println();
    }
    @Override
    public void run() {
        Token tmp;
        do {
            lock.lock();
            tmp = Board.removeToken();
            if (tmp != null)
                tokenSet.add(tmp);
            else
            {
                lock.unlock();
                break;
            }
            counter++;
            int privateCounter = counter;
            lock.unlock();
            while(privateCounter ==counter);
        }while(tmp!=null);
        counter++;
        lock.lock();
        print();
        lock.unlock();
    }
}
