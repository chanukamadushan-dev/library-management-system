package controllers;

import db.DBConnection;

import java.sql.Connection;

public class BorrowHistoryController {

    Connection connection = DBConnection.getInstance().getConnection();

}
