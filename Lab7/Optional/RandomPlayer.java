import java.util.Random;

public class RandomPlayer extends Player {

    RandomPlayer(String name)
    {
        this.name=name;
        this.id=id_max;
        id_max++;
    }
    @Override
    public void run() {
        Random rand=new Random();
        Token tmp;
        synchronized (this) {
            while(true) {
                while (id != turn && run==1) {   // if the turn is not for the current thread and there are still available tokens then wait
                    try {
                        wait(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(Board.getAvailableTokens()<=0 || run==0)
                    break;
                tmp = Board.removeToken(rand.nextInt(Board.getAvailableTokens()));
                notifyAll();
                tokenSet.add(tmp);
                System.out.println(name+" took "+tmp.getNumber());
                turn = (turn + 1) % id_max;
            }
            Player.setRun(false);
        }
        lock.lock();
        print();
        lock.unlock();
    }
}
