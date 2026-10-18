package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MemberData {
    private static ObservableList<Members> memberList = FXCollections.observableArrayList();

    public static void addMembers(Members member) {
        memberList.add(member);
    }

    public static Members searchMember(String id) {
        for (Members member : memberList) {
            if (member.getMemberId().equals(id)) {
                return member;
            }

        }
        return null;
    }
    public static ObservableList<Members> getMemberList(){
        return memberList;
    }

    public static void deleteMember(Members member) {
        memberList.remove(member);
    }
}
