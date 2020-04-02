import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Board {
    private static List<Token> tokenList;
    Board(){
        tokenList=new ArrayList<Token>(1) ;
    }
    Board(int n)
    {
        tokenList=new ArrayList<Token>(n) ;
    }
    public static void addToken(Token token){
        if(!tokenList.contains(token))
            tokenList.add(token);
    }
    public int getFreeTokens()
    {
        return tokenList.size();
    }
    public static Token removeToken()
    {
        if(tokenList.size()<=0)
            return null;
        Token tmp = tokenList.get(0);
        tokenList.remove(0);
        return tmp;
    }
    public void print()
    {
        System.out.print("Board has tokens: ");
        for(int i=0;i<tokenList.size();i++)
            System.out.print(tokenList.get(i).getNumber()+" ");
        System.out.println("");
    }
}
