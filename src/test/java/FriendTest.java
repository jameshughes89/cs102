import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FriendTest {

    // [start-getFirstName_test]
    @Test
    void getFirstName_generalCase_returnsFirstName() {
        Friend friend = new Friend("qwerty", "asdfgh", "zxcvbn");
        assertEquals("qwerty", friend.getFirstName());
    }
    // [end-getFirstName_test]

    @Test
    void getLastName_generalCase_returnsLastName() {
        Friend friend = new Friend("qwerty", "asdfgh", "zxcvbn");
        assertEquals("asdfgh", friend.getLastName());
    }

    @Test
    void getEmail_generalCase_returnsEmail() {
        Friend friend = new Friend("qwerty", "asdfgh", "zxcvbn");
        assertEquals("zxcvbn", friend.getEmail());
    }

    // [start-equals_test]
    @Test
    void equals_equalFriendObjects_areEqual() {
        Friend aFriend = new Friend("qwerty", "asdfgh", "zxcvbn");
        Friend bFriend = new Friend("qwerty", "asdfgh", "zxcvbn");
        assertEquals(aFriend, bFriend);
    }
    // [end-equals_test]

    @Test
    void equals_unequalFriendObjects_areNotEqual() {
        Friend aFriend = new Friend("qwerty", "asdfgh", "zxcvbn");
        Friend bFriend = new Friend("ytrewq", "hgfdsa", "nbvcxz");
        assertNotEquals(aFriend, bFriend);
    }

    @Test
    void toString_generalCase_returnsCorrectString() {
        Friend friend = new Friend("qwerty", "asdfgh", "zxcvbn");
        assertEquals("Friend(qwerty, asdfgh, zxcvbn)", friend.toString());
    }

    // [start-better_equals_test]
    @Test
    void equals_verify_contract() {
        EqualsVerifier.forClass(Friend.class)
                .withNonnullFields("firstName")
                .withNonnullFields("lastName")
                .withNonnullFields("email")
                .verify();
    }
    // [end-better_equals_test]
}
