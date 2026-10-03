package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IssueData {

    public static ObservableList<Issue> issueList = FXCollections.observableArrayList();

    public static ObservableList<Issue> getIssueList(){
        return issueList;
    }
}
