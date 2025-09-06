# Java Twitter Console Simulation

A lightweight console-based Java application that simulates a mini version of Twitter.  
Users can create accounts, post tweets, follow or unfollow others, like tweets, and view personalized timelines — all within the terminal. (completed in 2021)

---

##  Features

###  User Authentication
- Sign up with username, password, and bio
- Login and switch between accounts
- Delete account (logout with removal)

###  Tweeting System
- Post tweets with automatically generated unique Tweet IDs
- Like tweets from other users

###  Social Features
- Follow and unfollow users
- View your list of followers and following

###  Timeline & Profiles
- View your own tweets and profile
- Explore other users’ profiles
- See tweets from people you follow in your timeline

---

##  Technologies Used
- Java SE
- Object-Oriented Programming (OOP)
- Data Structures: `ArrayList`, `HashMap`

---

##  Project Structure

├── Main.java → Application entry point

├── Twitter.java → Core logic (menus, actions, workflows)

├── User.java → User entity with account and following system

└── Tweet.java → Tweet entity with likes and ID generation

## Future Improvements

- Persistent data storage (saving users and tweets in files or database)
- Graphical User Interface (GUI)
- Private direct messaging between users
