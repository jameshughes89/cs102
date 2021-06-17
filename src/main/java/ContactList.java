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
     * @param firstName friends first name
     * @param lastName  friends last name
     * @param email     friends email address
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
        for (int i = 0; i < friends.length; ++i) {
            newFriends[i] = friends[i];
        }
        // Have friends now reference the new friends
        friends = newFriends;
    }

    public int indexOf(String firstName, String lastName) {
        // Create a temp friend object for easy
        // use of the Friend class' equals()
        Friend toFind = new Friend(firstName, lastName, "");

        // Linear search for the friend we are trying to find
        for (int i = 0; i < friendCount; ++i) {
            if (toFind.equals(friends[i])) {
                return i;
            }
        }
        // -1 will signify that we didn't find
        // what we were looking for
        return -1;
    }

    public Friend get(int index) {
        // Make sure the index provided is valid
        if (index > -1 && index < friendCount) {
            return friends[index];
        } else {
            return null;
        }
    }

    public Friend get(String firstName, String lastName) {
        int index = indexOf(firstName, lastName);
        return get(index);
    }


//    public void remove(String firstName, String lastName) {
//        // Create a temp friend object for easy
//        // use of the Friend class' equals()
//        Friend toDelete = new Friend(firstName, lastName, "");
//
//        // Linear search for the friend we are trying to delete
//        for (int i = 0; i < friendCount; ++i) {
//            if (toDelete.equals(friends[i])) {
//                // Have friend at the end of the array be referenced
//                // by the array index we removed from
//                friends[i] = friends[friendCount - 1];
//                friends[friendCount - 1] = null;
//                friendCount--;
//            }
//        }
//    }

    public void remove(String firstName, String lastName) {
        int friendIndex = indexOf(firstName, lastName);
        if (friendIndex != -1) {
            // Have friend at the end of the array be referenced
            // by the array index we removed from
            friends[friendIndex] = friends[friendCount - 1];
            friends[friendCount - 1] = null;
            friendCount--;
        }
    }


//    public void updateEmail(String firstName, String lastName, String newEmail) {
//        // Create a temp friend object for easy
//        // use of the Friend class' equals()
//        Friend toUpdate = new Friend(firstName, lastName, "");
//
//        // Linear search for the friend we are trying to update
//        for (int i = 0; i < friendCount; ++i) {
//            if (toUpdate.equals(friends[i])) {
//                friends[i].setEmail(newEmail);
//            }
//        }
//    }


    public void updateEmail(String firstName, String lastName, String newEmail) {
        int friendIndex = indexOf(firstName, lastName);
        if (friendIndex != -1) {
            friends[friendIndex].setEmail(newEmail);
        }
    }

    public void clear() {
        friends = new Friend[friends.length];
        friendCount = 0;
    }

    public int size() {
        return friendCount;
    }


//    public String toString() {
//        String s = "";
//        for (int i = 0; i < friendCount; ++i) {
//            s = s + friends[i].toString() + "\n";
//        }
//        return s;
//    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < friendCount; ++i) {
            builder.append(friends[i].toString());
            builder.append("\n");
        }
        return builder.toString();
    }

}


