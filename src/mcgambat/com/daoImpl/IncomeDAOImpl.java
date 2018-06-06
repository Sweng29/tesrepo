/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mcgambat.com.business.LoginFrame;
import mcgambat.com.connection.DBConnection;
import mcgambat.com.dao.IncomeDAO;
import mcgambat.com.models.IncomeModel;
import mcgambat.com.models.ReciptTypeModel;

/**
 *
 * @author Lenovo
 */
public class IncomeDAOImpl implements IncomeDAO{

    Connection conn = DBConnection.getInstance();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String query = "";
    Integer result = 0;
    
    @Override
    public ResultSet viewAllIncomeDetails() {
       resultSet = null;
        try{
            query = "select i.`income_id` as 'Income ID',i.`income_date` as 'Income Date',i.`depositer_name` as 'Depositer Name',\n" +
                    "r.`recipt_type` as 'Receipt Type',i.`amount` as 'Amount',i.`total` as 'Total' \n" +
                    "from income i inner join `recipt_type` r on i.`receipt_type_id` = r.`recipt_type_id` where i.`active` = 1 AND r.active=1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }
    
        public ResultSet viewAllIncomeDetails(String from, String to) {
       resultSet = null;
        try{
            query = "select i.`income_id` as 'Income ID',i.`income_date` as 'Income Date',i.`depositer_name` as 'Depositer Name',\n" +
                    "r.`recipt_type` as 'Receipt Type',i.`amount` as 'Amount',i.`total` as 'Total' \n" +
                    "from income i inner join `recipt_type` r on i.`receipt_type_id` = r.`recipt_type_id` where i.`active` = 1 AND r.active=1 AND i.income_date >= ? and i.income_date <= ?;";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, from);
            preparedStatement.setString(2, to);
            resultSet = preparedStatement.executeQuery();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }
    @Override
    public int addIncome(IncomeModel incomeModel) {
        result = 0;
        try{
            query = "insert into income (income_date,depositer_name,receipt_type_id,amount,total,created_by,created_date,modified_by,modified_date)\n" +
                    "values (?,?,?,?,?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setTimestamp(1, incomeModel.getIncomeDate());
            preparedStatement.setString(2, incomeModel.getDepositerName());
            preparedStatement.setInt(3, incomeModel.getReciptTypeModel().getReciptTypeId());
            preparedStatement.setDouble(4, incomeModel.getAmount());
            preparedStatement.setDouble(5, incomeModel.getTotal());
            preparedStatement.setInt(6, LoginFrame.userModel.getUserId());
            preparedStatement.setTimestamp(7, incomeModel.getCreatedDate());
            preparedStatement.setInt(8, LoginFrame.userModel.getUserId());
            preparedStatement.setTimestamp(9, incomeModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateIncome(IncomeModel incomeModel) {
        result = 0;
        try{
            query = "update income set income_date=?,depositer_name=?,receipt_type_id=?,amount=?,total=?,modified_by=?,modified_date=? " +
                    " where income_id = ? AND active=1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setTimestamp(1, incomeModel.getIncomeDate());
            preparedStatement.setString(2, incomeModel.getDepositerName());
            preparedStatement.setInt(3, incomeModel.getReciptTypeModel().getReciptTypeId());
            preparedStatement.setDouble(4, incomeModel.getAmount());
            preparedStatement.setDouble(5, incomeModel.getTotal());
            preparedStatement.setInt(6, LoginFrame.userModel.getUserId());
            preparedStatement.setTimestamp(7, incomeModel.getModifiedDate());
            preparedStatement.setInt(8, incomeModel.getIncomeId());
            result = preparedStatement.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteIncomeById(IncomeModel incomeModel) {
        result = 0;
        try{
            query = "update income set active=0,modified_by=?,modified_date=? " +
                    " where income_id = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, LoginFrame.userModel.getUserId());
            preparedStatement.setTimestamp(2, incomeModel.getModifiedDate());
            preparedStatement.setInt(3, incomeModel.getIncomeId());
            result = preparedStatement.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public IncomeModel getIncomeDetailsById(Integer incomeId) {
        IncomeModel incomeModel = null;
        try{
            query = "select i.`income_id` as 'Income ID',i.`receipt_type_id` as 'Recipt Type ID',i.`income_date` as 'Income Date',i.`depositer_name` as 'Depositer Name',\n" +
                    "r.`receipt_type` as 'Receipt Type',i.`amount` as 'Amount',i.`total` as 'Total' \n" +
                    "from income i inner join recipt_type r on i.receipt_type_id = r.recipt_type_id where i.income_id=? i.`active` = 1 AND r.active=1;";            preparedStatement = conn.prepareStatement(query);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, incomeId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
               incomeModel = new IncomeModel();
               ReciptTypeModel reciptTypeModel = new ReciptTypeModel();
               incomeModel.setAmount(resultSet.getDouble("Amount"));
               incomeModel.setDepositerName(resultSet.getString("Depositer Name"));
               incomeModel.setIncomeDate(resultSet.getTimestamp("Income Date"));
               reciptTypeModel.setReciptType(resultSet.getString("Recipt Type"));
               reciptTypeModel.setReciptTypeId(resultSet.getInt("Recipt Type ID"));
               incomeModel.setTotal(resultSet.getDouble("Total"));
               incomeModel.setIncomeId(resultSet.getInt("Income ID"));
               incomeModel.setReciptTypeModel(reciptTypeModel);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return incomeModel;
    }
    
}
