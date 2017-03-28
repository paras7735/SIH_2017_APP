package app.alchemist.sih2017.alchemist;
public class User {
    public String password;
    public String email;
    public Integer ulevel;
    public String meterId;
    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String email, String password, String meterId ) {
        this.password = password;
        this.email = email;
        this.ulevel = 0;
        this.meterId = meterId;
    }
}
