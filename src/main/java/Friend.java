import java.util.Objects;

/***
 * A plain old java class to keep track of friends. A Friend will know its first name, last name, and email address.
 * This class provides getters/accessor methods for the attributes and can be checked for equality.
 */
public final class Friend {

    // Fields for the Friend Class
    private final String firstName;
    private final String lastName;
    private final String email;

    /**
     * Create an instance of a Friend. The constructor takes the first name, last name, and email address of the Friend
     * to be created.
     *
     * @param firstName First name of the friend
     * @param lastName  Last name of the friend
     * @param email     Email address of the friend
     */
    public Friend(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return String.format("Friend(%s, %s, %s)", firstName, lastName, email);
    }

    /**
     * Checks if two Friend objects are equal. Friend objects are considered equal if all their attributes are equal.
     *
     * @param o an "object" being compared to.
     * @return True if the two objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // If o is actually in the same memory address of this
        if (o == this) {
            return true;
        }
        // If o is null, then it's not equal
        if (o == null) {
            return false;
        }
        // if o and this are of different classes, they're not the equal
        if (o.getClass() != this.getClass()) {
            return false;
        }
        // Cast o as a friend
        Friend other = (Friend) o;
        return Objects.equals(this.firstName, other.firstName) && Objects.equals(this.lastName, other.lastName) &&
                Objects.equals(this.email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }
}
