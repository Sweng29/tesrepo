/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.models;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Lenovo
 */
public class IncomeModel extends UtilityModel{
    private Integer incomeId;
    private Timestamp incomeDate;
    private ReciptTypeModel reciptTypeModel;
    private String depositerName;
    private Double amount;
    private Double total;
    
    
    public ReciptTypeModel getReciptTypeModel() {
        return reciptTypeModel;
    }

    public void setReciptTypeModel(ReciptTypeModel reciptTypeModel) {
        this.reciptTypeModel = reciptTypeModel;
    }

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Timestamp getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Timestamp incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getDepositerName() {
        return depositerName;
    }

    public void setDepositerName(String depositerName) {
        this.depositerName = depositerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
}
