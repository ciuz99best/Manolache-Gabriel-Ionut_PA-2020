import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

        /*
        Board has two lists, one containing tokens and one  containing numbers, the list of the tokens is used by the players from where they can extract tokens
        and the numbers list has the numbers from the tokens in order to find a given token from the number, and when a token is added to the list, its number
        is added to the number list.

        removeToken deletes a token from the list and its corresponding number from the number list and returns that token, only if the position is correct otherwise
        null is returned.
         */

public class Board implements Comparator<Token> {
    private static List<Token> tokenList = new ArrayList<Token>();
    private static List<Integer> numbers = new ArrayList<Integer>();

    public boolean addToken(Token token) {
        if (numbers.contains(token.getNumber()))
            return false;
        numbers.add(token.getNumber());
        tokenList.add(token);
        return true;
    }

    public static int getAvailableTokens() {
        return tokenList.size();
    }

    public static Token removeToken(int position) {
        if (tokenList.size() <= 0) {
            Player.setRun(false);
            return null;
        }
        if (tokenList.size() <= position)
            return null;
        Token tmp = tokenList.get(position);
        numbers.remove(position);
        tokenList.remove(position);
        return tmp;
    }

    public static int getTokenPositionNumber(int number) {
        if (!numbers.contains(number))
            return -1;
        return numbers.indexOf(number);
    }
    public static void sort(){
        tokenList.sort(new Board());
        Collections.sort(numbers);
    }
    public static void print() {
        System.out.print("Available tokens: ");
        for (int i = 0; i < tokenList.size(); i++)
            System.out.print(tokenList.get(i).getNumber() + ", ");
        System.out.println("");
    }

    @Override
    public int compare(Token o1, Token o2) {
        if (o1.getNumber() == o2.getNumber())
            return 0;
        if (o1.getNumber() < o2.getNumber())
            return -1;
        return 1;
    }
}
