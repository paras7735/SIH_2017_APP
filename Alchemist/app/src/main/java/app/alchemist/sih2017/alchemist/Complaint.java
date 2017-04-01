package app.alchemist.sih2017.alchemist;
public class Complaint {
    public String contact;
    public String email;
    public String message;
    public String type;

    public Complaint() {
    }

    public Complaint(String contact, String email, String message,String type ) {
        this.contact = contact;
        this.email = email;
        this.message = message;
        this.type = type;
    }
}
