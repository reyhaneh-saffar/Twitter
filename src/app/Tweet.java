package app;
import java.util.*;

public class Tweet {
    private Scanner input = new Scanner(System.in);
    private String TweetId;
    private String tweetMatn;
    private int like = 0;
    //------------------------------------------------------------------------------------------------------------------
    public void setLike(){
        this.like++;
    }
    public int getLike(){
        return like;
    }
    public void setTweetMatnId(){
        System.out.println("Write your tweet:");
        tweetMatn = input.nextLine();
        TweetId = generateTweetId();
    }
    public String getTweetId(){
        return this.TweetId;
    }
    public String getTweetMatn(){
        return this.tweetMatn;
    }
    private String generateTweetId(){
        String letters = "qwertyuioplkjhgfdsazxcvbnm9803512647:$*;&/%!@#";
        StringBuilder pass = new StringBuilder();
        Random rand = new Random();
        for (int p = 0; p < letters.length() / 3; p++) {
            int randompos = rand.nextInt(45);
            pass.append(letters.charAt(randompos));
        }
        String word = pass.toString();
        pass.setLength(0);
        while (!(word.matches(".*[a-z].*") &&
                word.matches(".*[0-9].*") &&
                word.matches(".*[:$*;&/%!@#].*"))){
            for (int j = 0; j < letters.length() / 3; j++) {
                int randompos = rand.nextInt(45);
                pass.append(letters.charAt(randompos));
            }
            word = pass.toString();
            pass.setLength(0);
        }
        return word;
    }
}