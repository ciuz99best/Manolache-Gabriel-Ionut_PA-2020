import java.util.Scanner;
public class ManualPlayer extends Player{
    ManualPlayer(String name)
    {
        this.name=name;
        this.id=id_max;
        id_max++;
    }
    @Override
    public void run() {
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
                Scanner myObj = new Scanner(System.in);
                int number,position;
                Board.print();
                do {
                    System.out.print(name + "_ insert number: ");
                    number = myObj.nextInt();
                    position= Board.getTokenPositionNumber(number);
                }while(run==1 && position==-1);
                if(run==0)
                    break;
                tmp = Board.removeToken(position);
                notifyAll();
                tokenSet.add(tmp);
                turn = (turn + 1) % id_max;
            }
            Player.setRun(false);
        }
        lock.lock();
        print();
        lock.unlock();
    }
}
