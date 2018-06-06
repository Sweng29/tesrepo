/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mcgambat.com.business.LoginFrame;
import mcgambat.com.connection.DBConnection;
import mcgambat.com.dao.CheckIssue;
import mcgambat.com.models.CheckIssueModel;

/**
 *
 * @author Asif Ali
 */
public class CheckIssueDaoImpl implements CheckIssue {

    @Override
    public ResultSet getAllCheckIssues() {
        ResultSet resultSet = null;
        try {
            String query = "SELECT check_issue_id AS Id , check_date AS Date , cheque_no AS ChequeNo , vouch_no AS `Voucher No` , description_item AS Description , checque_amount AS ChecqueAmount ,favour AS Favour , account_initials AS AccountInitials , account_officer AS AccountOfficer , cmo AS Cmo , administrator AS Administartor FROM check_issue where active = 1";
            Connection conn = DBConnection.getInstance();
            resultSet = conn.prepareStatement(query).executeQuery();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int insertCheckIssueRecord(CheckIssueModel checkIssueModel) {
    String query = "INSERT INTO check_issue(check_date,cheque_no,vouch_no,description_item,checque_amount,favour,account_initials,account_officer,cmo,administrator,created_by,created_date,modified_by,modified_date,active)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    int row = 0;
    try{
        Connection conn = DBConnection.getInstance();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setTimestamp(1, checkIssueModel.getCheckDate());
        preparedStatement.setString(2, checkIssueModel.getCheckNo());
        preparedStatement.setString(3, checkIssueModel.getVoucherNo());
        preparedStatement.setString(4, checkIssueModel.getDesciptionItem());
        preparedStatement.setDouble(5, checkIssueModel.getChequeAmount());
        preparedStatement.setString(6, checkIssueModel.getFavour());
        preparedStatement.setString(7, checkIssueModel.getAccountInitials());
        preparedStatement.setString(8, checkIssueModel.getAccountOfficer());
        preparedStatement.setString(9, checkIssueModel.getCmo());
        preparedStatement.setString(10,checkIssueModel.getAdministrator());
        preparedStatement.setInt(11, LoginFrame.userModel.getUserId());
        preparedStatement.setTimestamp(12, checkIssueModel.getCreatedDate());
        preparedStatement.setInt(13, LoginFrame.userModel.getUserId());
        preparedStatement.setTimestamp(14, checkIssueModel.getModifiedDate());
        preparedStatement.setInt(15, 1);
        
        row = preparedStatement.executeUpdate();
    }catch(Exception e){
    e.printStackTrace();
    }
    return row;
    }

    @Override
    public int updateCheckIssueRecord(CheckIssueModel checkIssueModel) {
    String query = "update check_issue set check_date = ? ,cheque_no = ? ,vouch_no = ?,description_item = ?,checque_amount = ?,favour = ?,account_initials = ?,account_officer = ?,cmo = ?,administrator = ?,modified_by = ?,modified_date = ? where check_issue_id = ?";
     int row = 0;
    try{
        Connection conn = DBConnection.getInstance();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setTimestamp(1, checkIssueModel.getCheckDate());
        preparedStatement.setString(2, checkIssueModel.getCheckNo());
        preparedStatement.setString(3, checkIssueModel.getVoucherNo());
        preparedStatement.setString(4, checkIssueModel.getDesciptionItem());
        preparedStatement.setDouble(5, checkIssueModel.getChequeAmount());
        preparedStatement.setString(6, checkIssueModel.getFavour());
        preparedStatement.setString(7, checkIssueModel.getAccountInitials());
        preparedStatement.setString(8, checkIssueModel.getAccountOfficer());
        preparedStatement.setString(9, checkIssueModel.getCmo());
        preparedStatement.setString(10,checkIssueModel.getAdministrator());
        preparedStatement.setInt(11, LoginFrame.userModel.getUserId());
        preparedStatement.setTimestamp(12, checkIssueModel.getModifiedDate());
        preparedStatement.setInt(13, checkIssueModel.getCheckIssueId());
        
        row = preparedStatement.executeUpdate();
    }catch(Exception e){
    e.printStackTrace();
    }
    return row;
    
    }

    @Override
    public int deleteCheckIssueRecord(Integer id) {
    String query = "update check_issue set active = 0  where check_issue_id = ?";
         int row = 0;
    try{
        Connection conn = DBConnection.getInstance();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        
        row = preparedStatement.executeUpdate();
    }catch(Exception e){
    e.printStackTrace();
    }
    return row;
    
    
    }
    
    
}
