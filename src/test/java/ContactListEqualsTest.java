import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

public class ContactListEqualsTest {
    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        ContactList emptyA = new ContactList();
        ContactList emptyB = new ContactList();
        ContactList emptyC = new ContactList(100);

        ContactList singletonA = new ContactList();
        ContactList singletonB = new ContactList();
        ContactList singletonC = new ContactList(100);
        singletonA.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        singletonB.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        singletonC.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));

        ContactList manyA = new ContactList();
        ContactList manyB = new ContactList();
        ContactList manyC = new ContactList(100);
        manyA.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        manyA.add(new Friend("Jane", "Doe", "jdoe@gmail.com"));
        manyA.add(new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
        manyB.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        manyB.add(new Friend("Jane", "Doe", "jdoe@gmail.com"));
        manyB.add(new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
        manyC.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        manyC.add(new Friend("Jane", "Doe", "jdoe@gmail.com"));
        manyC.add(new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));

        ContactList unequalDifferentFriends = new ContactList();
        unequalDifferentFriends.add(new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"));
        unequalDifferentFriends.add(new Friend("Adam", "Fluffson", "fluffyman28@hotmail.com"));
        unequalDifferentFriends.add(new Friend("Adrian", "Andrews", "aandrews@hotmail.com"));

        ContactList unequalDifferentOrder = new ContactList();
        unequalDifferentOrder.add(new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
        unequalDifferentOrder.add(new Friend("Jane", "Doe", "jdoe@gmail.com"));
        unequalDifferentOrder.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));

        ContactList unequalDifferentSize = new ContactList();
        unequalDifferentSize.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        unequalDifferentSize.add(new Friend("Jane", "Doe", "jdoe@gmail.com"));

        ContactList unequalSomeEqualFriends = new ContactList();
        unequalSomeEqualFriends.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
        unequalSomeEqualFriends.add(new Friend("Jane", "Doe", "jdoe@gmail.com"));
        unequalSomeEqualFriends.add(new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
        unequalSomeEqualFriends.add(new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"));
        unequalSomeEqualFriends.add(new Friend("Adam", "Fluffson", "fluffyman28@hotmail.com"));
        unequalSomeEqualFriends.add(new Friend("Adrian", "Andrews", "aandrews@hotmail.com"));

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
}
