public class PlayingObjects {
    public static void main(String[] args) {
        ContactList myFriends = new ContactList(5);
        myFriends.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        myFriends.add(new Friend("Jane", "Doe", "jdoe@gmail.com"));
        myFriends.add(new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
        myFriends.add(new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"));
        myFriends.add(new Friend("Adam", "Fluffson", "fluffyman28@hotmail.com"));
        myFriends.add(new Friend("Adrian", "Andrews", "aandrews@hotmail.com"));

        System.out.println("Print after adds and expand");
        System.out.println(myFriends);

        System.out.println("Print after remove");
        myFriends.remove(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        System.out.println(myFriends);

        System.out.println("Print after clear");
        myFriends.clear();
        System.out.println(myFriends);

        StringBuilder stringBuilder = new StringBuilder();
    }
}
