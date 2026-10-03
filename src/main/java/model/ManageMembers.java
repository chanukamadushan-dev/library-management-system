package model;

public class ManageMembers {
    private String memberId;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private String memberAddress;

    public ManageMembers(String memberId, String memebrName, String memberEmail, String memberPhone, String memberAddress) {
        this.memberId = memberId;
        this.memberName = memebrName;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    @Override
    public String toString() {
        return  memberId+" - "+memberName ;
    }
}
