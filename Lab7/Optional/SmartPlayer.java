import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SmartPlayer extends Player {
    SmartPlayer(String name)
    {
        this.name=name;
        this.id=id_max;
        id_max++;
    }
    @Override
    public void run() {
        Random rand=new Random();
        List<Integer> ap=new ArrayList<Integer>();
        Token tmp = new Token();
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
                if(tokenSet.size()<3)
                {
                    tmp = Board.removeToken(rand.nextInt(Board.getAvailableTokens()));
                    ap.add(tmp.getNumber());
                }
                else
                {
                    Collections.sort(ap);
                    int ratio=ap.get(1)-ap.get(0),position;
                    position=Board.getTokenPositionNumber(ap.get(ap.size()-1)+ratio);
                    if(position==-1)
                        position=0;
                    tmp=Board.removeToken(position);
                }
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
