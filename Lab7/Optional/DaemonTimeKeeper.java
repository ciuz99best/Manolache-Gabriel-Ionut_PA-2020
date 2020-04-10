import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

        /*
        the time of the game is set on the constructor of the class

        when this thread is running it goes straight to sleep mode until the game time is over or the run variable is 0
        which means the game is over, when the thread starts running again and the game is not yet over, it consumes
        all the tokens which causes the game to be over.
         */

public class DaemonTimeKeeper extends Player {
    private int time;
    DaemonTimeKeeper(int time)
    {
        this.name="Daemon";
        this.time=time;
    }
    @Override
    public void run() {
        long startTime = System.nanoTime()/1_000;
        while (startTime + time * 1_000_000 > System.nanoTime()/1_000 && run == 1)
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if(run==1) {
            while (run==1)
                Board.removeToken(0);
            System.out.println("\n" +
                    "Time has expired, the game was stopped!");
        }
    }
}
