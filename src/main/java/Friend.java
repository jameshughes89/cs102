public class Friend {

    // Class Attribute Declaration
    private String firstName;
    private String lastName;
    private String email;

    // Constructor and assigning attributes
    public Friend(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Update the email address. Will only work if the email address
     * contains the @ symbol for simple data correctness check
     *
     * @param email     new email address
     */
    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        }
    }

    public String toString() {
        return firstName + " " + lastName + ":\t" + email;
    }

//      This is what is included in topic3
//    /**
//     * Sample equals method for comparing two friend objects.
//     * In this example, we will simply compare first and last
//     * names
//     *
//     * This example is deliberately kept very simple and does
//     * not actually override the toString properly.
//     *
//     * @return      if the two friend objects are equal
//     */
//    public boolean equals(Friend other) {
//        return this.firstName.equals(other.firstName)
//                && this.lastName.equals(other.lastName);
//    }


    /**
     * Sample equals method for comparing two friend objects.
     * In this example, we will simply compare first and last
     * names.
     *
     * @param o     an "object" being compared to
     *
     * @return      if the two friend objects are equal
     */
    public boolean equals(Object o) {
        // If o is actually in the same memory address of this
        if (o == this) {
            return true;
        }
        // If o is null, then it's not equal
        if (o == null) {
            return false;
        }
        // if o and this are of different classes, they're not the same
        if (o.getClass() != this.getClass()) {
            return false;
        }
        // Cast o as a friend
        Friend other = (Friend) o;
        return this.firstName.equals(other.firstName)
                && this.lastName.equals(other.lastName);
    }


}
