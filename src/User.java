public class User {
    private int userId;
    private String name;
    private String email;
    // constructor
    public User(int userId, String name, String email){
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
    // getter for user id
    public int getUserId(){
        return userId;
    }
     // Setter for user ID
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }
     //Display user details
    public void displayUserDetails() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }

}
