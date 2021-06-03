public class ContactList {

    static final int DEFAULT_CAPACITY = 10;

    private int friendCount;
    private Friend[] friends;

//    public ContactList() {
//        friendCount = 0;
//        friends = new Friend[DEFAULT_CAPACITY];
//    }

    public ContactList() {
        // Call the constructor that
        // takes an int as param
        this(DEFAULT_CAPACITY);
    }

    public ContactList(int capacity) {
        friendCount = 0;
        friends = new Friend[capacity];
    }

    /**
     * Add a new friend to the friends array. Will create an instance
     * of a Friend based on parameters. If our array runs out of space
     * we will expand capacity to manage the situation.
     *
     * @param firstName     friends first name
     * @param lastName      friends last name
     * @param email         friends email address
     */
    public void add(String firstName, String lastName, String email) {
        // Create the Friend object
        Friend newFriend = new Friend(firstName, lastName, email);

        // If we have run out of space in our array
        // we need to deal with it
        if (friendCount == friends.length) {
            expandCapacity();
        }
        // Add friend to the next available spot
        friends[friendCount] = newFriend;
        friendCount++;
    }

    private void expandCapacity() {
        // Make a new array of twice the size of the previous
        Friend[] newFriends = new Friend[friends.length * 2];

        // Copy over the contents of the friends list
        // to the new bigger friends list
        for(int i = 0; i < friends.length; ++i) {
            newFriends[i] = friends[i];
        }
        // Have friends now reference the new friends
        friends = newFriends;
    }


}
