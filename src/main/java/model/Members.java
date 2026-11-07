package model;

public class Members {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Members(String id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Members(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getMemberId() {
        return id;
    }

    public String getMemberName() {
        return name;
    }

    public String getMemberEmail() {
        return email;
    }

    public String getMemberPhone() {
        return phone;
    }

    public String getMemberAddress() {
        return address;
    }

    public void setMemberId(String id) {
        this.id = id;
    }

    public void setMemberName(String name) {
        this.name = name;
    }

    public void setMemberEmail(String email) {
        this.email = email;
    }

    public void setMemberPhone(String phone) {

        if (phone == null || phone.length() <= 10) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone number cannot exceed 20 characters.");
        }
    }

    public void setMemberAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
