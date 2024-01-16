import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

public class ContactListEqualsTest {
    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        ContactList emptyA = of();
        ContactList emptyB = of();
        ContactList emptyC = ofCapacity();

        ContactList singletonA = of(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        ContactList singletonB = of(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        ContactList singletonC = ofCapacity(new Friend("Bob", "Smith", "bsmith@gmail.com"));

        ContactList manyA = of(new Friend("Bob", "Smith", "bsmith@gmail.com"),
                new Friend("Jane", "Doe", "jdoe@gmail.com"),
                new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
        ContactList manyB = of(new Friend("Bob", "Smith", "bsmith@gmail.com"),
                new Friend("Jane", "Doe", "jdoe@gmail.com"),
                new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
        ContactList manyC = ofCapacity(new Friend("Bob", "Smith", "bsmith@gmail.com"),
                new Friend("Jane", "Doe", "jdoe@gmail.com"),
                new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));


        ContactList unequalDifferentFriends = of(
                new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"),
                new Friend("Adam", "Fluffson", "fluffyman28@hotmail.com"),
                new Friend("Adrian", "Andrews", "aandrews@hotmail.com"));

        ContactList unequalDifferentOrder = of(
                new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"),
                new Friend("Jane", "Doe", "jdoe@gmail.com"),
                new Friend("Bob", "Smith", "bsmith@gmail.com"));

        ContactList unequalDifferentSize = of(
                new Friend("Bob", "Smith", "bsmith@gmail.com"),
                new Friend("Jane", "Doe", "jdoe@gmail.com"));

        ContactList unequalSomeEqualFriends = of(
                new Friend("Bob", "Smith", "bsmith@gmail.com"),
                new Friend("Jane", "Doe", "jdoe@gmail.com"),
                new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"),
                new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"),
                new Friend("Adam", "Fluffson", "fluffyman28@hotmail.com"),
                new Friend("Adrian", "Andrews", "aandrews@hotmail.com"));

        new EqualsTester().addEqualityGroup(ContactList.class)
                .addEqualityGroup(emptyA, emptyB, emptyC)
                .addEqualityGroup(singletonA, singletonB, singletonC)
                .addEqualityGroup(manyA, manyB, manyC)
                .addEqualityGroup(unequalDifferentFriends)
                .addEqualityGroup(unequalDifferentOrder)
                .addEqualityGroup(unequalDifferentSize)
                .addEqualityGroup(unequalSomeEqualFriends)
                .testEquals();
    }

    private ContactList of(Friend... friends) {
        ContactList contactList = new ContactList();
        for (Friend friend : friends) {
            contactList.add(friend);
        }
        return contactList;
    }

    private ContactList ofCapacity(Friend... friends) {
        ContactList contactList = new ContactList(100);
        for (Friend friend : friends) {
            contactList.add(friend);
        }
        return contactList;
    }
}
