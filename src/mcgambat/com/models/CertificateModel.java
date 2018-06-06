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
 * @author Intel
 */
public class CertificateModel extends UtilityModel{
    private Integer crId;
    private String certificateType;
    private String noMcg;
    private Date cDate;
    private String name;
    private String fatherName;
    private String caste;
    private String cnicNo;
    private String recommendedBy;
    private String propertyNo;
    private String mohalla;
    private String muncipalCommittee;
    private String muncipalConsisting;
    private String consistingDescription;
    private String north;
    private String east;
    private String south;
    private String west;
    private Double tax;
    private Double measure;
    private String houseNo;
    private String gambat; 
    
    public CertificateModel(int crId , String certificateType ,String noMcg ,
            Date cdate , String name , String fatherName , String caste ,
            String cnic , String recommendedBy, String propertyNo ,String mohalla ,
            String muncipalCommittee , String consistingDescription , String north ,
            String south , String east , String west ,Double tax , Double measure ,
            String houseNo , String muncipalConsisting , String gambat){
    
        this.crId = crId;
        this.certificateType = certificateType;
        this.noMcg = noMcg;
        this.cDate =cdate;
        this.name = name;
        this.fatherName = fatherName;
        this.caste = caste;
        this.cnicNo = cnic;
        this.recommendedBy = recommendedBy;
        this.propertyNo = propertyNo;
        this.mohalla = mohalla;
        this.muncipalCommittee = muncipalCommittee;
        this.consistingDescription  =consistingDescription;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.tax = tax;
        this.measure = measure;
        this.houseNo = houseNo;
        this.muncipalConsisting = muncipalConsisting;
        this.gambat = gambat;
    }
    public CertificateModel(){}
    public Integer getCrId() {
        return crId;
    }

    public void setCrId(Integer crId) {
        this.crId = crId;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getNoMcg() {
        return noMcg;
    }

    public void setNoMcg(String noMcg) {
        this.noMcg = noMcg;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getCnicNo() {
        return cnicNo;
    }

    public void setCnicNo(String cnicNo) {
        this.cnicNo = cnicNo;
    }

    public String getRecommendedBy() {
        return recommendedBy;
    }

    public void setRecommendedBy(String recommendedBy) {
        this.recommendedBy = recommendedBy;
    }

    public String getPropertyNo() {
        return propertyNo;
    }

    public void setPropertyNo(String propertyNo) {
        this.propertyNo = propertyNo;
    }

    public String getMohalla() {
        return mohalla;
    }

    public void setMohalla(String mohalla) {
        this.mohalla = mohalla;
    }

    public String getMuncipalCommittee() {
        return muncipalCommittee;
    }

    public void setMuncipalCommittee(String muncipalCommittee) {
        this.muncipalCommittee = muncipalCommittee;
    }

    public String getMuncipalConsisting() {
        return muncipalConsisting;
    }

    public void setMuncipalConsisting(String muncipalConsisting) {
        this.muncipalConsisting = muncipalConsisting;
    }

    public String getConsistingDescription() {
        return consistingDescription;
    }

    public void setConsistingDescription(String consistingDescription) {
        this.consistingDescription = consistingDescription;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getMeasure() {
        return measure;
    }

    public void setMeasure(Double measure) {
        this.measure = measure;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getGambat() {
        return gambat;
    }

    public void setGambat(String gambat) {
        this.gambat = gambat;
    }
    
    
}
