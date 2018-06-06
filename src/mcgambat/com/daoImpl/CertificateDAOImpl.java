/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mcgambat.com.connection.DBConnection;
import mcgambat.com.models.CertificateModel;

/**
 *
 * @author Intel
 */
public class CertificateDAOImpl {
    private Connection con = DBConnection.getInstance();
    private PreparedStatement pst;
    private ResultSet rs;
    public ResultSet getBoundariesCertificates(String certificateType){
        String query = "";
        switch(certificateType){
            case "Boundaries Certificate" :
                query = "SELECT `certificate_id`, no_mcg AS 'No MCG' , date(`cdate`) AS 'Date' , \n" +
"`property_no` AS 'Property No' , mohalla AS 'Mohalla' , `name` AS 'Name' ,\n" +
"father_name AS 'Father' , `caste` AS caste , \n" +
"north AS 'North' , south AS 'South' , east AS 'East' , west AS 'West' \n" +
" FROM `certificate` \n" +
"WHERE `certificate_type_id` = 'Boundaries Certificate' AND active = 1";
                break;
            case "No Objection Certificate" :
                query = "SELECT `certificate_id`, no_mcg AS 'No MCG' , date(`cdate`) AS 'Date' , \n" +
"`name` AS 'Name' ,\n" +
"father_name AS 'Father Name' , mohalla AS 'Mohalla' , \n" +
"`muncipal_committee` AS 'Muncipal Committee' \n" +
"FROM `certificate` \n" +
"WHERE `certificate_type_id` = 'No Objection Certificate' AND active = 1";
                break;
            case "Tax Property Certificate":
                query ="SELECT `certificate_id`, no_mcg AS 'No MCG' , date(`cdate`) AS 'Date' , \n" +
"`muncipal_committee` AS 'Muncipal Committee' , \n" +
"`muncipal_consisting` AS 'Muncipal Consisting' , \n" +
"`consisting_description` AS 'Description' , mohalla AS 'Mohalla' , \n" +
"`name` AS 'Name' ,\n" +
"father_name AS 'Son Of' , `caste` AS caste \n" +
"FROM `certificate` \n" +
"WHERE `certificate_type_id` = 'Tax Property Certificate' AND active = 1";
                break;
            case "Residence Certificate":
                query = "SELECT `certificate_id`, no_mcg AS 'No MCG' , date(`cdate`) AS 'Date' , \n" +
"`name` AS 'Name' ,\n" +
"father_name AS 'Father Name' , `caste` AS Caste ,  mohalla AS 'Mohalla' , \n" +
"`nic_no` AS \"Cnic No\" , `recomended_by` AS 'Recomended By'\n" +
"FROM `certificate` \n" +
"WHERE `certificate_type_id` = 'Residence Certificate' AND active = 1";
                break;
        }
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet NoObjectionCertificates(String certificateType){
        try {
            pst = con.prepareStatement("SELECT `certificate_id`, no_mcg AS 'No MCG' , `cdate` AS 'Date' , \n" +
"`name` AS 'Name' ,\n" +
"father_name AS 'Father Name' , mohalla AS 'Mohalla' , \n" +
"`muncipal_committee` AS 'Muncipal Committee' \n" +
"FROM `certificate` \n" +
"WHERE `certificate_type_id` = ? AND active = 1");
            pst.setString(1,certificateType);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
   public CertificateModel getCertificateById(int id , String certificateType){
       CertificateModel cfModel = new CertificateModel();
       String query = "";
       switch(certificateType){
            case "Boundaries Certificate" :
                query = "SELECT no_mcg , cdate , property_no , mohalla , measure , tax , `name` , \n" +
"father_name , caste , south , east ,west , north \n" +
"FROM certificate WHERE certificate_id = ? AND certificate_type_id = 'Boundaries Certificate'";
                break;
            case "No Objection Certificate" :
                query = "SELECT no_mcg AS 'No MCG' , `cdate` AS 'Date' , \n" +
"`name` AS 'Name' ,\n" +
"father_name AS 'Father Name' , mohalla AS 'Mohalla' , \n" +
"`muncipal_committee` AS 'Muncipal Committee' \n" +
"FROM `certificate` \n" +
"WHERE `certificate_type_id` = 'No Objection Certificate' AND certificate_id = ?";
                break;
            case "Tax Property Certificate":
                query ="SELECT no_mcg AS 'No MCG' , `cdate` AS 'Date' , \n" +
"`muncipal_committee` AS 'Muncipal Committee' , \n" +
"`muncipal_consisting` AS 'Muncipal Consisting' , \n" +
"`consisting_description` AS 'Description' , mohalla AS 'Mohalla' , \n" +
"`name` AS 'Name' ,\n" +
"father_name AS 'Son Of' , `caste` AS caste \n" +
"FROM `certificate` \n" +
"WHERE `certificate_type_id` = 'Tax Property Certificate' AND certificate_id = ?";
                break;
            case "Residence Certificate":
                query = "SELECT no_mcg AS 'No MCG' , `cdate` AS 'Date' , \n" +
"`muncipal_committee` AS 'Muncipal Committee' , \n" +
"`muncipal_consisting` AS 'Muncipal Consisting' , \n" +
"`consisting_description` AS 'Description' , mohalla AS 'Mohalla' , \n" +
"gambat AS 'Gambat',tax AS 'Tax',`name` AS 'Name' ,\n" +
"father_name AS 'Son Of' , `caste` AS caste \n" +
"FROM `certificate` \n" +
"WHERE `certificate_type_id` = 'Tax Property Certificate' AND certificate_id = ?";
                break;
       }
       return cfModel;
   } 
   
   public CertificateModel getCertificateModelById(int id){
       CertificateModel cfModel = null; 
       try {
            pst = con.prepareStatement("Select * from certificate where certificate_id = ? and active = 1");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if(rs.next()){
                String certifcateType = rs.getString(2);
                String noMcg = rs.getString(3);
                Date cDate = rs.getDate(4);
                String name = rs.getString(5);
                String fname = rs.getString(6);
                String caste = rs.getString(7);
                String nic = rs.getString(8);
                String recom = rs.getString(9);
                String propertyNo =rs.getString(10);
                String mohalla = rs.getString(11);
                String committee = rs.getString(12);
                String muncipalConsisting = rs.getString(13);
                String consistingDesc = rs.getString(14);
                String north = rs.getString(15);
                String south = rs.getString(16);
                String east = rs.getString(17);
                String west = rs.getString(18);
                Double measure =rs.getDouble(19);
                Double tax = rs.getDouble(20);
                String houseNo = rs.getString(21);
                String gambat = rs.getString(22);
                
                cfModel = new CertificateModel(id, certifcateType, noMcg, cDate, name, fname, caste, nic, recom, propertyNo, mohalla, committee, consistingDesc, north, south, east, west, tax, measure, houseNo , muncipalConsisting , gambat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return cfModel;
   }
   public int updateCertificate(CertificateModel certificateModel){
       String query = "UPDATE `certificate` SET no_mcg = ? , cdate = ? , `"
               + "name` =? , father_name = ? , \n" +
"caste = ? , nic_no = ? , `recomended_by` = ? , property_no = ? , "
               + "mohalla = ? , \n" +
"`muncipal_committee` = ? , muncipal_consisting = ? , consisting_description = ? , "
               + "north = ? ,\n" +
"south = ? , east = ? , west = ? ,measure = ? , tax = ? , house_no = ? , "
               + "gambat = ?, \n" +
"modified_by = ? , modified_date = NOW() WHERE certificate_id = ?;";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, certificateModel.getNoMcg());
            pst.setDate(2, certificateModel.getcDate());
            pst.setString(3, certificateModel.getName());
            pst.setString(4,certificateModel.getFatherName());
            pst.setString(5,certificateModel.getCaste());
            pst.setString(6,certificateModel.getCnicNo());
            pst.setString(7,certificateModel.getRecommendedBy());
            pst.setString(8,certificateModel.getPropertyNo());
            pst.setString(9,certificateModel.getMohalla());
            pst.setString(10,certificateModel.getMuncipalCommittee());
            pst.setString(11,certificateModel.getMuncipalConsisting());
            pst.setString(12,certificateModel.getConsistingDescription());
            pst.setString(13,certificateModel.getNorth());
            pst.setString(14,certificateModel.getSouth());
            pst.setString(15,certificateModel.getEast());
            pst.setString(16,certificateModel.getWest());
            pst.setDouble(17,certificateModel.getMeasure());
            pst.setDouble(18, certificateModel.getTax());
            pst.setString(19, certificateModel.getHouseNo());
            pst.setString(20, certificateModel.getGambat());
            pst.setInt(21, certificateModel.getModifiedBy().getUserId());
            pst.setInt(22, certificateModel.getCrId());
            
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return 0;
   }
   public int addBoundariesCertificate(CertificateModel certificateModel){
        try {
            pst =con.prepareStatement("INSERT INTO `certificate` (certificate_type_id , "
                    + "no_mcg , cdate , \n" +
"property_no  , mohalla , measure , tax , `name` ,father_name , caste , \n" +
"north , south , east , west , created_by , created_date) \n" +
"VALUES(? , ? , ? , ? ,?\n" +
", ? , ? , ? , ? , ? , ?, ? , ? , ? , ? , now());");
            pst.setString(1, certificateModel.getCertificateType());
            pst.setString(2, certificateModel.getNoMcg());
            pst.setDate(3, certificateModel.getcDate());
            pst.setString(4, certificateModel.getPropertyNo());
            pst.setString(5, certificateModel.getMohalla());
            pst.setDouble(6, certificateModel.getMeasure());
            pst.setDouble(7, certificateModel.getTax());
            pst.setString(8, certificateModel.getName());
            pst.setString(9, certificateModel.getFatherName());
            pst.setString(10, certificateModel.getCaste());
            pst.setString(11, certificateModel.getNorth());
            pst.setString(12, certificateModel.getSouth());
            pst.setString(13, certificateModel.getEast());
            pst.setString(14, certificateModel.getWest());
            pst.setInt(15, certificateModel.getCreatedBy().getUserId());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return 0;
   }
   public int updateBoundariesCertificate(CertificateModel certificateModel){
       return 0;
   }
    public int addNoBCertificate(CertificateModel certificateModel){
        try {
            pst = con.prepareStatement("INSERT INTO `certificate` (certificate_type_id , "
                    + "no_mcg , cdate , \n" +
"`name` , father_name , mohalla , muncipal_committee, created_by ,created_date ) \n" +
"VALUES (? , ? , ? , \n" +
"? , ? , ? ,?,?, now());");
            pst.setString(1,certificateModel.getCertificateType());
            pst.setString(2,certificateModel.getNoMcg());
            pst.setDate(3, certificateModel.getcDate());
            pst.setString(4 , certificateModel.getName());
            pst.setString(5 , certificateModel.getFatherName());
            pst.setString(6 , certificateModel.getMohalla());
            pst.setString(7 , certificateModel.getMuncipalCommittee());
            pst.setInt(8 , certificateModel.getCreatedBy().getUserId());
            return pst.executeUpdate();
            
                    } catch (SQLException ex) {
            Logger.getLogger(CertificateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int addResCertificate(CertificateModel certificateModel){
        try {
            pst = con.prepareStatement("INSERT INTO `certificate` (certificate_type_id , "
                    + "no_mcg , cdate , \n" +
"`name` , father_name , caste , house_no , mohalla , nic_no , \n" +
"recomended_by , created_by , created_date) \n" +
"VALUES(? , ? , ? , \n" +
"? , ? , ?, ?, ? , \n" +
"? , ? , ? , NOW());");
            pst.setString(1,certificateModel.getCertificateType());
            pst.setString(2,certificateModel.getNoMcg());
            pst.setDate(3, certificateModel.getcDate());
            pst.setString(4 , certificateModel.getName());
            pst.setString(5 , certificateModel.getFatherName());
            pst.setString(6, certificateModel.getCaste());
            pst.setString(7 , certificateModel.getHouseNo());
            pst.setString(8 , certificateModel.getMohalla());
            pst.setString(9 , certificateModel.getCnicNo());
            pst.setString(10 , certificateModel.getRecommendedBy());
            pst.setInt(11 , certificateModel.getCreatedBy().getUserId());
            
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int addTPCertificate(CertificateModel certificateModel){
        try {
            pst = con.prepareStatement("INSERT INTO `certificate` (certificate_type_id , "
                    + "no_mcg , cdate , \n" +
"`muncipal_committee` , `muncipal_consisting` , consisting_description ,\n" +
"mohalla , gambat , tax , `name` , father_name , caste , created_by , \n" +
"created_date)\n" +
"VALUES(? , ? , ? , ? , \n" +
"? , ? , ? , ? , \n" +
"? , ? , ? , ? , ? , NOW())");
            
            pst.setString(1,certificateModel.getCertificateType());
            pst.setString(2,certificateModel.getNoMcg());
            pst.setDate(3, certificateModel.getcDate());
            pst.setString(4 , certificateModel.getMuncipalCommittee());
            pst.setString(5 , certificateModel.getMuncipalConsisting());
            pst.setString(6, certificateModel.getConsistingDescription());
            pst.setString(7 , certificateModel.getMohalla());
            pst.setString(8 , certificateModel.getGambat());
            pst.setDouble(9 , certificateModel.getTax());
            pst.setString(10 , certificateModel.getName());
            pst.setString(11 , certificateModel.getFatherName());
            pst.setString(12, certificateModel.getCaste());
            pst.setInt(13 , certificateModel.getCreatedBy().getUserId());
            
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }
    public int insertCertificateAll(CertificateModel certificateModel){
       String query = "INSERT INTO certificate ( "
               + "no_mcg , cdate , `name` , \n" +
"`father_name` , `caste` , `nic_no` , `recomended_by` , `property_no` , `mohalla`\n" +
", muncipal_committee , muncipal_consisting , consisting_description , north ,\n" +
"south , east , west , measure , tax , house_no , gambat , created_by ,`certificate_type_id` , created_date)\n" +
"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? , NOW())";
        try {
            pst = con.prepareStatement(query);
            
            pst.setString(1, certificateModel.getNoMcg());
            pst.setDate(2, certificateModel.getcDate());
            pst.setString(3, certificateModel.getName());
            pst.setString(4,certificateModel.getFatherName());
            pst.setString(5,certificateModel.getCaste());
            pst.setString(6,certificateModel.getCnicNo());
            pst.setString(7,certificateModel.getRecommendedBy());
            pst.setString(8,certificateModel.getPropertyNo());
            pst.setString(9,certificateModel.getMohalla());
            pst.setString(10,certificateModel.getMuncipalCommittee());
            pst.setString(11,certificateModel.getMuncipalConsisting());
            pst.setString(12,certificateModel.getConsistingDescription());
            pst.setString(13,certificateModel.getNorth());
            pst.setString(14,certificateModel.getSouth());
            pst.setString(15,certificateModel.getEast());
            pst.setString(16,certificateModel.getWest());
            pst.setDouble(17,certificateModel.getMeasure());
            pst.setDouble(18, certificateModel.getTax());
            pst.setString(19, certificateModel.getHouseNo());
            pst.setString(20, certificateModel.getGambat());
            pst.setInt(21, certificateModel.getCreatedBy().getUserId());
            pst.setString(22 , certificateModel.getCertificateType());
            
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return 0;
   }
    
    public int deleteCertificate(int id){
        try {
            pst = con.prepareStatement("update certificate set active  = 0 where certificate_id = ?");
            pst.setInt(1,id);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}

