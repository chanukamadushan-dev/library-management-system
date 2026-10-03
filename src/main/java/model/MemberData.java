package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MemberData {
    private static ObservableList<ManageMembers> memberList = FXCollections.observableArrayList();

    public static void addMembers(ManageMembers member) {
        memberList.add(member);
    }

    public static ManageMembers searchMember(String id) {
        for (ManageMembers member : memberList) {
            if (member.getMemberId().equals(id)) {
                return member;
            }

        }
        return null;
    }
    public static ObservableList<ManageMembers> getMemberList(){
        return memberList;
    }

    public static void deleteMember(ManageMembers member) {
        memberList.remove(member);
    }
}
