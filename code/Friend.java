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
}
