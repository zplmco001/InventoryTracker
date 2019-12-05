package Model;

import org.bson.Document;

import java.util.List;

public class User {

    private String id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private List<Document> userProduct;

    public User(String id, String firstname, String lastname, String phoneNumber, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Document> getUserProduct() {
        return userProduct;
    }

    public void setUserProduct(List<Document> userProduct) {
        this.userProduct = userProduct;
    }
}
