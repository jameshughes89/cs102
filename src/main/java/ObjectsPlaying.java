public class ObjectsPlaying {
    public static void main(String[] args) {
        ContactList myFriends = new ContactList(5);
        myFriends.add("Bob", "Smith", "bsmith@gmail.com");
        myFriends.add("Jane", "Doe", "jdoe@gmail.com");
        myFriends.add("Clarence", "Cartwrite", "treelover1523@hotmail.com");
        myFriends.add("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com");
        myFriends.add("Adam", "Fluffson", "fluffyman28@hotmail.com");
        myFriends.add("Adrian", "Andrews", "aandrews@hotmail.com");

        System.out.println("Print after adds and expand");
        System.out.println(myFriends);

        System.out.println("Print after update");
        myFriends.updateEmail("Clarence", "Cartwrite", "supertreelover1523@hotmail.com");
        System.out.println(myFriends);

        System.out.println("Print after remove");
        myFriends.remove("Bob", "Smith");
        System.out.println(myFriends);

        System.out.println("Print after clear");
        myFriends.clear();
        System.out.println(myFriends);
    }
}
