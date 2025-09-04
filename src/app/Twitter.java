package app;
import java.util.*;

public class Twitter {
    private Scanner input = new Scanner(System.in);
    private ArrayList<User> AllUsers = new ArrayList<>();
    private User user1 = new User();
    private HashMap<User,ArrayList<Tweet>> UserTweet = new HashMap<>();
    private ArrayList<Tweet> tweets = new ArrayList<>();
    //------------------------------------------------------------------------------------------------------------------
    private String chosenInput;
    private String userName;
    private String password;
    private String bio;
    private String choose;
    //------------------------------------------------------------------------------------------------------------------
    private void setUser1(User user1){
        this.user1 = user1;
    }
    private User getUser1(){
        return this.user1;
    }
    private void setUserTweet(User user, ArrayList<Tweet> tweets){
        UserTweet.put(user,tweets);
    }
    //------------------------------------------------------------------------------------------------------------------
    public void Start(){
        System.out.println("HI. WELCOME TO TWITTER.");
        System.out.println("LET ME KNOW WHAT DO YOU WANT TO DO:\n    QUIT \n    SIGN UP\n");
        System.out.println("Select \"LOGIN\" if you already have an account");
        this.choose = input.nextLine().toLowerCase();
        switch (choose) {
            case "quit": {
                System.err.println("Hope you come back soon. Good Luck");
                System.err.println("************************************");
                System.exit(0);
            }
            case "sign up": {
                SignUp();
            }
            case "login": {
                Login();
            }
        }
        Continue();
    }
    private void Continue(){
        System.out.println();
        System.out.println("************************************");
        System.out.println("What do you want to do now ?");
        System.out.println("*SIGN UP" + "\t*switch account".toUpperCase() +
                "\n*login".toUpperCase() + "\t\t*logout".toUpperCase() +
                "\n*myprofile".toUpperCase() + "\t*tweet".toUpperCase() +
                "\n*follow".toUpperCase() + "\t\t*unfollow".toUpperCase() +
                "\n*followers".toUpperCase() + "\t*following".toUpperCase() +
                "\n*timeline".toUpperCase() + "\t*profile".toUpperCase() +
                "\n*like".toUpperCase() + "\t\t*quit".toUpperCase());
        System.out.println("************************************");
        choose = input.nextLine().toLowerCase();
        CheckInput(choose);
    }
    private void CheckInput(String in){
        switch (in){
            case "quit": {
                System.err.println("Hope you come back soon. Good Luck");
                System.err.println("************************************");
                System.exit(0);
            }
            case "sign up":
                SignUp();
            case "switch account": {
                SwitchAccount();
                Continue();
            }
            case "login": {
                Login();
                Continue();
            }
            case "logout":
                Logout();
            case "tweet":
                Tweet();
            case "follow":
                Follow();
            case "unfollow":
                UnFollow();
            case "followers":
                Followers();
            case "following":
                Following();
            case "myprofile": {
                MyProfile();
                Continue();
            }
            case "timeline": {
                MyProfile();
                TimeLine();
            }
            case "profile":
                Profile();
            case "like":
                Like();
            default:
                Continue();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    private void SignUp(){
        User user = new User();
        int count = 0;
        //برای اینکه یوزر نیم تکراری نداشته باشه
        do {
            System.out.println("Write your user name: ");
            userName = input.nextLine();
            if (AllUsers != null){
                for (int i = 0; i < AllUsers.size(); i++){
                    if (userName.equals(AllUsers.get(i).getUserName())){
                        count++;
                        System.out.println("This account already exists.Try again");
                    } else count = 0;
                }
            }
        } while (count > 0);
        System.out.println("Write your password: " +
                "(INCLUDING [a-z] & [0-9] & ONE OF THESE SPECIAL CHARACTERS".toLowerCase() + "[:$*;&/%!@#])");
        password = input.nextLine();
        System.out.println("Choose one of these conditions: \n" +
                "*Available" + "\n*Busy" + "\n*At School" + "\n*At the movies" +
                "\n*At Work" + "\n*In a meeting" + "\n*At the gym" + "\n*Sleeping" +
                "\n*Battery about to die");
        System.out.println("Or write  something as yor bio yourself.");
        bio = input.nextLine();
        user.setItems(userName, password, bio);
        AllUsers.add(user);
        setUser1(user);
        tweets = new ArrayList<>();
        Continue();
    }
    private void SwitchAccount(){
        System.out.println("Which one do you want to change your account to?");
        if (AllUsers != null){
            for (int i = 0; i < AllUsers.size(); i++) {
                System.out.print(AllUsers.get(i).getUserName() + "\t");
            }
            System.out.println();
        }
        chosenInput = input.nextLine();
        int count = 0;
        for (int i = 0; i < AllUsers.size(); i++) {
            if (chosenInput.equals(AllUsers.get(i).getUserName())) {
                setUser1(AllUsers.get(i));
                tweets = new ArrayList<>();
                tweets = UserTweet.get(getUser1());
                Login();
                count++;
                System.out.println("Done Successfully.");
                break;
            }
        }
        if (count == 0){
            System.out.println("This account doesn't exist.");

        }
    }
    private void Login(){
        do {
            System.out.println("Write your user name: ");
            userName = input.nextLine();
            if (!userName.equals(getUser1().getUserName())){
                System.out.println("It wasn't correct.");
            }
        } while (!userName.equals(getUser1().getUserName()));
        do {
            System.out.println("Write your password:");
            password = input.nextLine();
            if (!password.equals(getUser1().getPassword())){
                System.out.println("It wasn't correct.");
            }
        }while (!password.equals(getUser1().getPassword()));
        System.out.println("Welcome " + getUser1().getUserName().toUpperCase());
    }
    private void Logout() {
        System.out.println("Now you are in this account: " + getUser1().getUserName().toUpperCase());
        System.out.println("Do you want to delete your account? (yes,no)");
        chosenInput = input.nextLine().toLowerCase();
        if (chosenInput.equals("yes")) {
            do {
                System.out.println("Write your user name: ");
                userName = input.nextLine();
                if (!userName.equals(getUser1().getUserName())) {
                    System.out.println("It wasn't correct.");
                }
            } while (!userName.equals(getUser1().getUserName()));
            do {
                System.out.println("Write your password:");
                password = input.nextLine();
                if (!password.equals(getUser1().getPassword())) {
                    System.out.println("It wasn't correct.");
                }
            } while (!password.equals(getUser1().getPassword()));
            AllUsers.remove(getUser1());
            UserTweet.remove(getUser1());
            System.out.println("Deleted Successfully.");
            Start();
        } else {
            Continue();
        }
    }
    private void Tweet(){
        Tweet tweet  = new Tweet();
        tweet.setTweetMatnId();
        tweets.add(tweet);
        setUserTweet(getUser1(),tweets);
        Continue();
    }
    private void Follow(){
        System.out.println("Who do you want to follow? (please enter her/his id)");
        String idFollow;
        int count = 0;
        idFollow = input.nextLine();
        for (int i = 0; i < AllUsers.size(); i++){
            if (idFollow.equals(AllUsers.get(i).getUserName())){
                getUser1().setFollower(AllUsers.get(i));
                getUser1().setUserFollower(getUser1(),getUser1().getFollower());
                count++;
                System.out.println("Followed Successfully.");
                break;
            }
        }
        if (count == 0){
            System.out.println("This account doesn't exist.");
        }
        Continue();
    }
    private void UnFollow(){
        if (getUser1().getFollower().size() != 0 ){
            System.out.println("Who do you want to unfollow (Write the id)");
            String idFollow = input.nextLine();
            int count = 0;
            int cut = 0;
            for (int i = 0; i < AllUsers.size(); i++) {
                if (idFollow.equals(AllUsers.get(i).getUserName())) {
                    count++;
                    break;
                    //این یعنی اگر آیدی فوق ساین آپ کرده باشه
                }
            }
            if (count != 0){
                //حالا باید اری لیست کسایی ک فالو کرده رو بگیریم
                ArrayList<User> FollowKardeha = getUser1().getUserFollower().get(getUser1());
                if (FollowKardeha.size() != 0){
                        for (int p = 0; p < FollowKardeha.size(); p++){
                            if (idFollow.equals(FollowKardeha.get(p).getUserName())){
                                cut++;
                                FollowKardeha.remove(p);
                                getUser1().setUserFollower(getUser1(), FollowKardeha);
                                System.out.println("Unfollowed Successfully.");
                                break;
                            }
                        }
                        if (cut == 0){
                            System.out.println("You haven't followed this user before.");
                        }
                    } else {
                    System.out.println("Your following list is empty.");
                }
            } else {
                System.out.println("This account doesn't exist.");
            }
        } else {
            System.out.println("you don't have any followers to unfollow");
        }
        Continue();
    }
    private void Following(){
        if (this.getUser1().getFollower().size() != 0){
            for (int i = 0; i < this.getUser1().getFollower().size(); i++){
                System.out.print(getUser1().getFollower().get(i).getUserName() + "\t");
            }
            System.out.println();
        } else {
            System.out.println("Your following list is empty.");
        }
        Continue();
    }
    private void Followers(){
        int count = 0;
        for (int i = 0; i < AllUsers.size(); i++){
            //اگر این یوزر برابر نبود با یکی دیگه مث خودش
            if (!getUser1().getUserName().equals(AllUsers.get(i).getUserName())){
                //اومدیم یک یوزر رو با کسایی ک فالو کرده گرفتیم
                count++;
                ArrayList<User> follow = AllUsers.get(i).getFollower();
                if (follow.size() != 0){
                    for (int j = 0; j < follow.size(); j++){
                        if (this.getUser1().getUserName().equals(follow.get(j).getUserName())){
                            System.out.print(AllUsers.get(i).getUserName() + "\t");
                        }
                    }
                } else {
                    System.out.println("No one is following you.");
                }
            }
        }
        if (count == 0){
            System.out.println("you don't have any followers.");
        }
        Continue();
    }
    private void Like(){
        System.out.println("Which tweet do you want to like? (Write the TweetId)");

        for (int i = 0; i < AllUsers.size(); i++){
            if (!this.getUser1().getUserName().equals(AllUsers.get(i).getUserName())){
                ArrayList<Tweet> tweetArrayList = UserTweet.get(AllUsers.get(i));
                if (tweetArrayList != null){
                    for (int j = 0; j < tweetArrayList.size(); j++){
                        System.out.println("User Name: ".toUpperCase() + AllUsers.get(i).getUserName());
                        System.out.println("Tweet Id : ".toUpperCase() + tweetArrayList.get(j).getTweetId());
                        System.out.println("Text :".toUpperCase() + tweetArrayList.get(j).getTweetMatn());
                        System.out.println("Likes :".toUpperCase() + tweetArrayList.get(j).getLike());
                    }
                }
            }
        }
        String chosen = input.nextLine();
        int count = 0;
        for (int i = 0; i < AllUsers.size(); i++){
            if (!this.getUser1().getUserName().equals(AllUsers.get(i).getUserName())){
                ArrayList<Tweet> tweetArrayList = UserTweet.get(AllUsers.get(i));
                for (int j = 0; j < tweetArrayList.size(); j++){
                    if (chosen.equals(tweetArrayList.get(j).getTweetId())){
                        tweetArrayList.get(j).setLike();
                        setUserTweet(AllUsers.get(i),tweetArrayList);
                        count++;
                        System.out.println("Liked Successfully.");
                        break;
                    }
                }
            }
        }
        if (count == 0){
            System.out.println("This tweet doesn't exist.");
        }
        Continue();
    }
    private void MyProfile(){
        ArrayList<Tweet> tweetArrayList = UserTweet.get(getUser1());
        System.out.println("User Name: ".toUpperCase() + this.getUser1().getUserName());
        System.out.println("User Bio: ".toUpperCase() + this.getUser1().getBio());
        if (tweetArrayList != null){
            for (int j = 0; j < tweetArrayList.size(); j++){
                System.out.println("Tweet Id : ".toUpperCase() + tweetArrayList.get(j).getTweetId());
                System.out.println("Text :".toUpperCase() + tweetArrayList.get(j).getTweetMatn());
                System.out.println("Likes :".toUpperCase() + tweetArrayList.get(j).getLike());
                System.out.println("+----------------------------------------+");
            }
        } else {
         System.out.println("you have not tweeted anything yet.");
        }
    }
    private void TimeLine(){
        ArrayList<User> FollowKardeha = getUser1().getUserFollower().get(this.getUser1());
        if (FollowKardeha != null){
            for (int i = 0; i < FollowKardeha.size(); i++){
                ArrayList<Tweet> tweetArrayList = UserTweet.get(FollowKardeha.get(i));
                if (tweetArrayList.size() != 0){
                    for (int j = 0; j < tweetArrayList.size(); j++){
                        System.out.println("User Name: ".toUpperCase() + FollowKardeha.get(i).getUserName());
                        System.out.println("Tweet Id : ".toUpperCase() + tweetArrayList.get(j).getTweetId());
                        System.out.println("Text :".toUpperCase() + tweetArrayList.get(j).getTweetMatn());
                        System.out.println("Likes :".toUpperCase() + tweetArrayList.get(j).getLike());
                        System.out.println("+----------------------------------------+");
                    }
                } else {
                    System.out.println("User Name: ".toUpperCase() + FollowKardeha.get(i).getUserName());
                    System.out.println("This person has not tweeted yet.");
                }
            }
        } else {
            System.out.println("you haven't any followings to see their tweets.");
        }
        Continue();
    }
    private void Profile(){
        System.out.println("Which account do you want to see its profile? (give me the id)");
        for (int i = 0; i < this.getUser1().getFollower().size(); i++){
            System.out.print(getUser1().getFollower().get(i).getUserName() + "\t");
        }
        System.out.println();
        String id = input.nextLine();
        int count = 0;
        for (int i = 0; i < AllUsers.size(); i++){
            if (id.equals(AllUsers.get(i).getUserName())){
                count++;
                System.out.println("User Name: " + AllUsers.get(i).getUserName());
                System.out.println("User bio: " + AllUsers.get(i).getBio());
                ArrayList<Tweet> tweetArrayList = UserTweet.get(AllUsers.get(i));
                if (tweetArrayList != null){
                    for (int j = 0; j < tweetArrayList.size(); j++){
                        System.out.println("+----------------------------------------+");
                        System.out.println("Tweet Id : ".toUpperCase() + tweetArrayList.get(j).getTweetId());
                        System.out.println("Text :".toUpperCase() + tweetArrayList.get(j).getTweetMatn());
                        System.out.println("Likes :".toUpperCase() + tweetArrayList.get(j).getLike());
                        System.out.println("+----------------------------------------+");
                    }
                } else {
                    System.out.println("This person has not tweeted yet.");
                }
            }
        }
        if (count == 0){
            System.out.println("This account doesn't exist.");
        }
        Continue();
    }
}