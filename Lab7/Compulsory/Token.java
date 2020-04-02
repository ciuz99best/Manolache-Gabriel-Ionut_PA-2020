
import java.util.Random;
public class Token {
    private int number;
    Token()
    {
        Random rand = new Random();
        number=rand.nextInt(1000000)+1;
    }
    Token(int m)
    {
        Random rand = new Random();
        number=rand.nextInt(m)+1;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int number)
    {
        this.number=number;
    }
}
