public class ContactList {

    static final int DEFAULT_CAPACITY = 10;

    int capacity;
    int friendCount;
    Friend[] friends;

//    public ContactList() {
//        capacity = DEFAULT_CAPACITY;
//        friendCount = 0;
//        friends = new Friend[capacity];
//    }

    public ContactList() {
        // Call the constructor that
        // takes an int as param
        this(DEFAULT_CAPACITY);
    }

    public ContactList(int capacity) {
        this.capacity = capacity;
        friendCount = 0;
        friends = new Friend[capacity];
    }



}
