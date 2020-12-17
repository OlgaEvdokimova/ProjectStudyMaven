package hw16.task1;

public class User implements Comparable<User>{
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!firstName.equals(user.firstName)) return false;
        return lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public int compareTo(User o) {
        if (this.firstName.equals(o.firstName)){
            if (this.lastName.equals(o.lastName)){
                return 0;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "hw16.task1.User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

