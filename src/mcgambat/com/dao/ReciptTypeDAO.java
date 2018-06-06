/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.dao;

import java.sql.ResultSet;
import mcgambat.com.models.ReciptTypeModel;

/**
 *
 * @author Lenovo
 */
public interface ReciptTypeDAO {
    public ResultSet viewAllReciptTypes();
    public int addReciptType(ReciptTypeModel reciptTypeModel);
    public int updateReciptType(ReciptTypeModel reciptTypeModel);
    public int deleteReciptTypeById(ReciptTypeModel reciptTypeModel);
    public ReciptTypeModel getReciptTypeDetailsById(Integer reciptTypeId);
    public ReciptTypeModel getReciptTypeDetailsByName(String reciptType);    
}
