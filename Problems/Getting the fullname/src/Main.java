class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = null;
        this.lastName = null;
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        } else if (firstName == null && lastName == null) {
            return "Unknown";
        } else {
            return firstName == null ? lastName : firstName;
        }
    }
}