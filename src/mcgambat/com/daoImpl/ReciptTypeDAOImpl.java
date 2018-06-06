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
import mcgambat.com.dao.ReciptTypeDAO;
import mcgambat.com.models.ReciptTypeModel;

/**
 *
 * @author Lenovo
 */
public class ReciptTypeDAOImpl implements ReciptTypeDAO{

    Connection conn = DBConnection.getInstance();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String query = "";
    Integer result = 0;
    
    @Override
    public ResultSet viewAllReciptTypes() {
           resultSet = null;
        try{
            query = "Select recipt_type_id as 'Recipt Type ID',`recipt_type` as 'Recipt Type' from recipt_type where active=1;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int addReciptType(ReciptTypeModel reciptTypeModel) {
            result = 0;
        try{
            query = "insert into recipt_type (`recipt_type`,created_by,created_date,modified_by,modified_date)\n" +
                    "values (?,?,?,?,?);";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, reciptTypeModel.getReciptType());
            preparedStatement.setInt(2, LoginFrame.userModel.getUserId());
            preparedStatement.setTimestamp(3, reciptTypeModel.getCreatedDate());
            preparedStatement.setInt(4, LoginFrame.userModel.getUserId());
            preparedStatement.setTimestamp(5, reciptTypeModel.getModifiedDate());
            result = preparedStatement.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateReciptType(ReciptTypeModel reciptTypeModel) {
    result = 0;
        try{
            query = "update recipt_type set `recipt_type`=?,modified_by=?,modified_date=? " +
                    " where recipt_type_id = ? AND active=1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, reciptTypeModel.getReciptType());
            preparedStatement.setInt(2, LoginFrame.userModel.getUserId());
            preparedStatement.setTimestamp(3, reciptTypeModel.getModifiedDate());
            preparedStatement.setInt(4, reciptTypeModel.getReciptTypeId());
            result = preparedStatement.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;    
    }

    @Override
    public int deleteReciptTypeById(ReciptTypeModel reciptTypeModel) {
    result = 0;
        try{
            query = "update recipt_type set active=0,modified_by=?,modified_date=? " +
                    " where recipt_type_id = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, LoginFrame.userModel.getUserId());
            preparedStatement.setTimestamp(2, reciptTypeModel.getModifiedDate());
            preparedStatement.setInt(3, reciptTypeModel.getReciptTypeId());
            result = preparedStatement.executeUpdate();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ReciptTypeModel getReciptTypeDetailsById(Integer reciptTypeId) {
        ReciptTypeModel reciptTypeModel = null;  
        try{
            query = "select recipt_type_id as 'Recipt Type ID',`recipt_type` as 'Recipt Type' from recipt_type where recipt_type_id = ? AND active=1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, reciptTypeId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
               reciptTypeModel = new ReciptTypeModel();
               reciptTypeModel.setReciptType(resultSet.getString("Recipt Type"));
               reciptTypeModel.setReciptTypeId(resultSet.getInt("Recipt Type ID"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return reciptTypeModel;  
    }

    @Override
    public ReciptTypeModel getReciptTypeDetailsByName(String reciptType) {
        ReciptTypeModel reciptTypeModel = null;  
        try{
            query = "select recipt_type_id as 'Recipt Type ID',`recipt_type` as 'Recipt Type' from recipt_type where recipt_type = ? AND active=1";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, reciptType);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
               reciptTypeModel = new ReciptTypeModel();
               reciptTypeModel.setReciptType(resultSet.getString("Recipt Type"));
               reciptTypeModel.setReciptTypeId(resultSet.getInt("Recipt Type ID"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return reciptTypeModel;  
    }    
}
