package app;
import java.util.*;

public class User {
    private Scanner in = new Scanner(System.in);
    private ArrayList<User> follower = new ArrayList<>();
    private HashMap<User,ArrayList<User>> UserFollower = new HashMap<>();
    //------------------------------------------------------------------------------------------------------------------
    private String userName;
    private String password;
    private String bio;
    //------------------------------------------------------------------------------------------------------------------
    public User(){
    }
    public void setItems(String userName, String password, String bio){
        this.userName = userName;
        this.password = CheckPasswordSecurity(password);
        this.bio = bio;
    }
    private String CheckPasswordSecurity(String password){
        int length = password.length();
        String anotherPassword;
        boolean text = password.matches(".*[a-zA-Z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[:$*;&/%!@#].*");
        while (!text){
            System.out.println("YOUR PASSWORD SHOULD HAVE AT LEAST 3 CHARACTERS\n" +
                    "INCLUDING [a-z] & [0-9] & ONE OF THESE SPECIAL CHARACTERS [:$*;&/%!@#]\n" +
                    "PLEASE ENTER YOUR PASSWORD AGAIN");
            anotherPassword = in.nextLine();
            CheckPasswordSecurity(anotherPassword);
        }
        return password;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
    public String getBio(){
        return this.bio;
    }
    public void setFollower(User user){
        follower.add(user);
    }
    public ArrayList<User> getFollower(){
        return follower;
    }
    public void setUserFollower(User user, ArrayList<User> users){
        UserFollower.put(user,users);
    }
    public HashMap<User,ArrayList<User>> getUserFollower(){
        return UserFollower;
    }
}