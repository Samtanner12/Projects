import java.util.ArrayList;
public class TheTweeter{
    public static void add(String author,String tweet){
        tweetHolder.add(author);
        tweetHolder.add(tweet);
    }
    public static void  remove(int authour){
        tweetHolder.remove(authour);
        tweetHolder.remove(authour+1);
    }
    public static void get(Object author){
        tweetHolder.get(authour);
        tweetHolder.get(authour+1);

    }
}
