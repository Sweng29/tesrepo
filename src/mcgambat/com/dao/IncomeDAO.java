/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.dao;

import java.sql.ResultSet;
import mcgambat.com.models.IncomeModel;

/**
 *
 * @author Lenovo
 */
public interface IncomeDAO {
    public ResultSet viewAllIncomeDetails();
    public int addIncome(IncomeModel incomeModel);
    public int updateIncome(IncomeModel incomeModel);
    public int deleteIncomeById(IncomeModel incomeModel);
    public IncomeModel getIncomeDetailsById(Integer incomeId);
}
