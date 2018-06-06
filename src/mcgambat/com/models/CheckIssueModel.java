/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.models;

import java.sql.Timestamp;

public class CheckIssueModel extends UtilityModel {

    private Integer checkIssueId;
    private Timestamp checkDate;
    private String checkNo;
    private String voucherNo;
    private String desciptionItem;
    private double chequeAmount;
    private String favour;
    private String accountInitials;
    private String accountOfficer;
    private String cmo;
    private String administrator;

    public Integer getCheckIssueId() {
        return checkIssueId;
    }

    public void setCheckIssueId(Integer checkIssueId) {
        this.checkIssueId = checkIssueId;
    }

    public Timestamp getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Timestamp checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getDesciptionItem() {
        return desciptionItem;
    }

    public void setDesciptionItem(String desciptionItem) {
        this.desciptionItem = desciptionItem;
    }

    public double getChequeAmount() {
        return chequeAmount;
    }

    public void setChequeAmount(double chequeAmount) {
        this.chequeAmount = chequeAmount;
    }

    public String getFavour() {
        return favour;
    }

    public void setFavour(String favour) {
        this.favour = favour;
    }

    public String getAccountInitials() {
        return accountInitials;
    }

    public void setAccountInitials(String accountInitials) {
        this.accountInitials = accountInitials;
    }

    public String getAccountOfficer() {
        return accountOfficer;
    }

    public void setAccountOfficer(String accountOfficer) {
        this.accountOfficer = accountOfficer;
    }

    public String getCmo() {
        return cmo;
    }

    public void setCmo(String cmo) {
        this.cmo = cmo;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

}
