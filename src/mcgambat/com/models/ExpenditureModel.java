/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.models;

import java.sql.Timestamp;

/**
 *
 * @author Rehan Ali Azeemi
 */
public class ExpenditureModel extends UtilityModel {
    Integer expenditureId;
    Timestamp expenditureDate;
    String payeesName;
    String chequeNo;
    String particularNo;
    Double amount;

    public Integer getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(Integer expenditureId) {
        this.expenditureId = expenditureId;
    }

    public Timestamp getExpenditureDate() {
        return expenditureDate;
    }

    public void setExpenditureDate(Timestamp expenditureDate) {
        this.expenditureDate = expenditureDate;
    }

    public String getPayeesName() {
        return payeesName;
    }

    public void setPayeesName(String payeesName) {
        this.payeesName = payeesName;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getParticularNo() {
        return particularNo;
    }

    public void setParticularNo(String particularNo) {
        this.particularNo = particularNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
