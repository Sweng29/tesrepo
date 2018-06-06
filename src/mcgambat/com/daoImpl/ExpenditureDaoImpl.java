/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import mcgambat.com.business.MessageForm;
import mcgambat.com.connection.DBConnection;
import mcgambat.com.dao.ExpenditureDao;
import mcgambat.com.models.ExpenditureModel;

/**
 *
 * @author Rehan Ali Azeemi
 */
public class ExpenditureDaoImpl implements ExpenditureDao {

    @Override
    public Integer addExpenditureWithCash(ExpenditureModel expenditureModel) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Insert into expenditure(expenditure_date,payees_name,particular_no,amount,created_by,created_date) values(?,?,?,?,?,?)");
            ps.setTimestamp(1, expenditureModel.getExpenditureDate());
            ps.setString(2, expenditureModel.getPayeesName());
            ps.setString(3, expenditureModel.getParticularNo());
            ps.setDouble(4, expenditureModel.getAmount());
            ps.setInt(5, expenditureModel.getCreatedBy().getUserId());
            ps.setTimestamp(6, expenditureModel.getCreatedDate());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            new MessageForm("Error", ex.toString(), "error.png");
        }

        return 0;
    }

    @Override
    public ResultSet getAllExpenditure() {
        PreparedStatement ps;
        try {
            ps = DBConnection.getInstance().prepareStatement("SELECT `expenditure_id` AS id, `expenditure_date` AS \"Expenditure date\",`payees_name` AS \"Payees Name\",`cheque_no` AS \"Checque No\",`particular_no` AS \"Particular Name\",`amount` AS \"Amount\" FROM expenditure WHERE active = 1");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            new MessageForm("Error", ex.toString(), "error.png").setVisible(true);
        }
        return null;
    }
    
    public ResultSet getAllExpenditure(String from,String to) {
        PreparedStatement ps;
        try {
            ps = DBConnection.getInstance().prepareStatement("SELECT `expenditure_id` AS id, `expenditure_date` AS \"Expenditure date\",`payees_name` AS \"Payees Name\",`cheque_no` AS \"Checque No\",`particular_no` AS \"Particular Name\",`amount` AS \"Amount\" FROM expenditure WHERE active = 1 and `expenditure_date` >= ? and `expenditure_date` <= ?");
            ps.setString(1,from);
            ps.setString(2, to);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            new MessageForm("Error", ex.toString(), "error.png").setVisible(true);
        }
        return null;
    }

    @Override
    public Integer updateExpenditureWithChecque(ExpenditureModel expenditureModel) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("update expenditure set expenditure_date = ?,payees_name = ?,cheque_no = ?,particular_no = ?,modified_by = ?,modified_date = ? where expenditure_id = ?");
            ps.setTimestamp(1, expenditureModel.getExpenditureDate());
            ps.setString(2, expenditureModel.getPayeesName());
            ps.setString(3, expenditureModel.getChequeNo());
            ps.setString(4, expenditureModel.getParticularNo());
            ps.setInt(5, expenditureModel.getModifiedBy().getUserId());
            ps.setTimestamp(6, expenditureModel.getModifiedDate());
            ps.setInt(7, expenditureModel.getExpenditureId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            new MessageForm("Error", ex.toString(), "error.png").setVisible(true);
        }
        return 0;
    }
    
     @Override
    public Integer updateExpenditureWithCash(ExpenditureModel expenditureModel) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("update expenditure set expenditure_date = ?,payees_name = ?,amount = ?,particular_no = ?,modified_by = ?,modified_date = ? where expenditure_id = ?");
            ps.setTimestamp(1, expenditureModel.getExpenditureDate());
            ps.setString(2, expenditureModel.getPayeesName());
            ps.setDouble(3, expenditureModel.getAmount());
            ps.setString(4, expenditureModel.getParticularNo());
            ps.setInt(5, expenditureModel.getModifiedBy().getUserId());
            ps.setTimestamp(6, expenditureModel.getModifiedDate());
            ps.setInt(7, expenditureModel.getExpenditureId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            new MessageForm("Error", ex.toString(), "error.png").setVisible(true);
        }
        return 0;
    }

    @Override
    public Integer deleteExpenditure(Integer id) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("update expenditure set active = 0 where expenditure_id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExpenditureDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Integer addExpenditureWithChecque(ExpenditureModel expenditureModel) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("Insert into expenditure(expenditure_date,payees_name,cheque_no,particular_no,created_by,created_date) values(?,?,?,?,?,?)");
            ps.setTimestamp(1, expenditureModel.getExpenditureDate());
            ps.setString(2, expenditureModel.getPayeesName());
            ps.setString(3, expenditureModel.getChequeNo());
            ps.setString(4, expenditureModel.getParticularNo());
            ps.setInt(5, expenditureModel.getCreatedBy().getUserId());
            ps.setTimestamp(6, expenditureModel.getCreatedDate());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            new MessageForm("Error", ex.toString(), "error.png");
        }

        return 0;
    }

    public boolean checqueNoIsAvailable(String checqueNo) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("select * from check_issue where cheque_no = ? and active = 1");
            ps.setString(1, checqueNo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpenditureDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean isChecqueAssigned(String checqueNo) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("select * from expenditure where cheque_no = ? and active = 1");
            ps.setString(1, checqueNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpenditureDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
    
    public boolean isChecqueAssigned(String checqueNo,Integer id) {
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement("select * from expenditure where cheque_no = ? and active = 1 and expenditure_id != ?");
            ps.setString(1, checqueNo);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpenditureDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
}
