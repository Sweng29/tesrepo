/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.dao;

import java.sql.ResultSet;
import mcgambat.com.models.ExpenditureModel;

/**
 *
 * @author Rehan Ali Azeemi
 */
public interface ExpenditureDao {
    public Integer addExpenditureWithCash(ExpenditureModel expenditureModel);
    public Integer addExpenditureWithChecque(ExpenditureModel expenditureModel);
    public Integer updateExpenditureWithCash(ExpenditureModel expenditureModel);
    public ResultSet getAllExpenditure();
    public Integer updateExpenditureWithChecque(ExpenditureModel expenditureModel);
    public Integer deleteExpenditure(Integer id);
}
