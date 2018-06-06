/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.business;

import com.sun.org.apache.bcel.internal.generic.D2F;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import mcgambat.com.daoImpl.CertificateDAOImpl;
import mcgambat.com.models.CertificateModel;
import mcgambat.com.utility.CommonMethods;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Intel
 */
public class CertificateFrame extends javax.swing.JFrame {
    CertificateDAOImpl certificateDAOImpl = null;
    String certificateType;
    /**
     * Creates new form CertificateFrame
     */
    public CertificateFrame() {
        initComponents();
        certificateDAOImpl = new CertificateDAOImpl();
        certificateType = comboctype.getSelectedItem().toString();
        panelBC.setVisible(false);
        fillCertificateTable(certificateType);
        showPanel(certificateType);
        dateDate.setDate(new Date());
        clearFields();
    }
    public void fillCertificateTable(String certificateType){
        CommonMethods.fillTables(certificateDAOImpl.getBoundariesCertificates(certificateType), tblCertificate, jScrollPane2, this);
    }
    public void showPanel(String certificateType){
        switch(certificateType){
            case "Boundaries Certificate" :
                panelBC.setVisible(true);
                panelNOC.setVisible(false);
                panelRd.setVisible(false);
                panelTP.setVisible(false);
                break;
            case "No Objection Certificate" :
                panelBC.setVisible(false);
                panelNOC.setVisible(true);
                panelRd.setVisible(false);
                panelTP.setVisible(false);
                break;
            case "Tax Property Certificate":
                panelBC.setVisible(false);
                panelNOC.setVisible(false);
                panelRd.setVisible(false);
                panelTP.setVisible(true);
                break;
            case "Residence Certificate":
                panelBC.setVisible(false);
                panelNOC.setVisible(false);
                panelRd.setVisible(true);
                panelTP.setVisible(false);
                break;
        }
    }
    
    private void addCertificate(int crtId , String mode){
        if(tfNoMcg.getText().equals("") || dateDate.getDate()==null){
            new MessageForm("Information", "Please Fill All Fields", "error.png").setVisible(true);
                    return;
        }
        else if(certificateType.equalsIgnoreCase("Boundaries Certificate") &&(
                BCProperty.getText().equals("") || bcCaste.getText().equals("")
                || bcEast.getText().equals("") || bcFname.getText().equals("") 
                || bcMeasure.getText().equals("") || bcMohalla.getText().equals("") 
                || bcName.getText().equals("") || bcNorth.getText().equals("") 
                || bcNorth.getText().equals("") || bcSouth.getText().equals("") 
                || bcTax.getText().equals("") || bcWest.getText().equals(""))){
        
            new MessageForm("Information", "Please Fill All Fields", "error.png").setVisible(true);
                    return;
        }
        else if(certificateType.equalsIgnoreCase("No Objection Certificate") &&(
                nocTfFname.getText().equals("") || nocTfMohalla.getText().equals("") ||
                nocTfMuncipal.getText().equals("") || nocTfName.getText().equals(""))){
            new MessageForm("Information", "Please Fill All Fields", "error.png").setVisible(true);
                    return;
        }
        else if(certificateType.equalsIgnoreCase("Tax Property Certificate") &&(
                tpCaste.getText().equals("") || tpCommiteeNo.getText().equals("") ||
                tpConsisting.getText().equals("") || tpDetails.getText().equals("") || 
                tpFname.getText().equals("") || tpGambat.getText().equals("") || 
                tpMohalla.getText().equals("") || tpName.getText().equals("") || 
                tpTax.getText().equals("") )){
            new MessageForm("Information", "Please Fill All Fields", "error.png").setVisible(true);
                    return;
        }
        else if(certificateType.equalsIgnoreCase("Residence Certificate") &&(
            rdTfCaste.getText().equals("") || rdTfCnic.getText().trim().equals("-       -") || 
                rdTfFname.getText().equals("") || rdTfHouseNo.getText().equals("") || 
                rdTfMohalla.getText().equals("") || rdTfName.getText().equals("") ||
                rdTfRecommended.getText().equals(""))){
            new MessageForm("Information", "Please Fill All Fields", "error.png").setVisible(true);
                    return;
            
        }
         Integer crId = crtId;
         String typeOfCertificate;
     String noMcg = null;
     java.sql.Date cDate= null;
     String name = null;
     String fatherName = null;
     String caste = null;
     String cnicNo = null;
     String recommendedBy = null;
     String propertyNo = null;
     String mohalla = null;
     String muncipalCommittee = null;
     String muncipalConsisting = null;
     String consistingDescription = null;
     String north = null;
     String east = null;
     String south = null;
     String west = null;
     Double tax = 0.00;
     Double measure = 0.00;
     String houseNo = null;
     String gambat = null;
     
     
     typeOfCertificate = comboctype.getSelectedItem().toString();
     noMcg = tfNoMcg.getText();
     Date date = dateDate.getDate();
     cDate = new java.sql.Date(date.getTime());
     switch(certificateType){
            case "Boundaries Certificate" :
                propertyNo = BCProperty.getText();
                mohalla = bcMohalla.getText();
                measure = Double.parseDouble(bcMeasure.getText());
                tax = Double.parseDouble(bcTax.getText());
                name = bcName.getText();
                fatherName = bcFname.getText();
                caste = bcCaste.getText();
                north = bcNorth.getText();
                south = bcSouth.getText();
                east = bcEast.getText();
                west = bcWest.getText();
                break;
            case "No Objection Certificate" :
                name = nocTfName.getText();
                fatherName=  nocTfFname.getText();
                mohalla = nocTfMohalla.getText();
                muncipalCommittee = nocTfMuncipal.getText();
                
                break;
            case "Tax Property Certificate":
                muncipalCommittee = tpCommiteeNo.getText();
                muncipalConsisting = tpConsisting.getText();
                consistingDescription = tpDetails.getText();
                mohalla = tpMohalla.getText();
                gambat = tpGambat.getText();
                tax = Double.parseDouble(tpTax.getText());
                name = tpName.getText();
                fatherName = tpFname.getText();
                caste = tpCaste.getText();
                
                break;
            case "Residence Certificate":
                name = rdTfName.getText();
                fatherName = rdTfFname.getText();
                caste = rdTfCaste.getText();
                houseNo = rdTfHouseNo.getText();
                mohalla = rdTfMohalla.getText();
                cnicNo = rdTfCnic.getText();
                recommendedBy = rdTfRecommended.getText();
                break;
        }
        CertificateModel certificateModel = new CertificateModel(crId, typeOfCertificate, 
                noMcg, cDate, name, fatherName, caste, cnicNo, recommendedBy, 
                propertyNo, mohalla, muncipalCommittee, consistingDescription, north, 
                south, east, west, tax, measure, houseNo, muncipalConsisting, gambat);
        int re = 0;
        if(mode.equalsIgnoreCase("add") && btnAdd.isEnabled()){
            certificateModel.setCreatedBy(LoginFrame.userModel);
            re = certificateDAOImpl.insertCertificateAll(certificateModel);
        }
        else if(mode.equalsIgnoreCase("update") && btnUpdate.isEnabled()){
            certificateModel.setModifiedBy(LoginFrame.userModel);
            re = certificateDAOImpl.updateCertificate(certificateModel);
        }
        if(re>0){
            fillCertificateTable(certificateType);
            clearFields();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Error");
        }
    }
    private void clearFields(){
        tfNoMcg.setText("");
        tfSearch.setText("");
        dateDate.setDate(new Date());
        bcCaste.setText("");
        bcEast.setText("");
        bcFname.setText("");
        bcMeasure.setText("");
        bcMohalla.setText("");
        bcName.setText("");
        bcNorth.setText("");
        bcSouth.setText("");
        bcTax.setText("");
        bcWest.setText("");
        BCProperty.setText("");
        
        nocTfFname.setText("");
        nocTfMohalla.setText("");
        nocTfMuncipal.setText("");
        nocTfName.setText("");
        
        rdTfCaste.setText("");
        rdTfCnic.setText("");
        rdTfFname.setText("");
        rdTfHouseNo.setText("");
        rdTfMohalla.setText("");
        rdTfName.setText("");
        rdTfRecommended.setText("");
        
        tpCaste.setText("");
        tpCommiteeNo.setText("");
        tpConsisting.setText("");
        tpDetails.setText("");
        tpFname.setText("");
        tpGambat.setText("");
        tpMohalla.setText("");
        tpName.setText("");
        tpTax.setText("");
        
        tblCertificate.clearSelection();
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        
        btnPrintCert.setVisible(false);
        btnViewCer.setVisible(false);
    }
    
    private void fillFields(int id){
        btnPrintCert.setVisible(true);
        btnViewCer.setVisible(true);
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);
        CertificateModel cm = certificateDAOImpl.getCertificateModelById(id);
        dateDate.setDate(cm.getcDate());
        tfNoMcg.setText(cm.getNoMcg());
        switch(certificateType){
            case "Boundaries Certificate" :
                BCProperty.setText(cm.getPropertyNo());
                bcMohalla.setText(cm.getMohalla());
                bcMeasure.setText(cm.getMeasure().toString());
                bcTax.setText(cm.getTax().toString());
                bcName.setText(cm.getName());
                bcFname.setText(cm.getFatherName());
                bcCaste.setText(cm.getCaste());
                bcNorth.setText(cm.getNorth());
                bcSouth.setText(cm.getSouth());
                bcEast.setText(cm.getEast());
                bcWest.setText(cm.getWest());
                break;
            case "No Objection Certificate" :
                nocTfName.setText(cm.getName());
                nocTfFname.setText(cm.getFatherName());
                nocTfMohalla.setText(cm.getMohalla());
                nocTfMuncipal.setText(cm.getMuncipalCommittee());
                
                break;
            case "Tax Property Certificate":
                tpCommiteeNo.setText(cm.getMuncipalCommittee());
                tpConsisting.setText(cm.getMuncipalConsisting());
                tpDetails.setText(cm.getConsistingDescription());
                tpMohalla.setText(cm.getMohalla());
                tpGambat.setText(cm.getGambat());
                tpTax.setText(cm.getTax().toString());
                tpName.setText(cm.getName());
                tpFname.setText(cm.getFatherName());
                tpCaste.setText(cm.getCaste());
                
                break;
            case "Residence Certificate":
                rdTfName.setText(cm.getName());
                rdTfFname.setText(cm.getFatherName());
                rdTfCaste.setText(cm.getCaste());
                rdTfHouseNo.setText(cm.getHouseNo());
                rdTfMohalla.setText(cm.getMohalla());
                rdTfCnic.setText(cm.getCnicNo());
                rdTfRecommended.setText(cm.getRecommendedBy());
                break;
        }
        
    }
    private void deleteCertificate(){
        Integer id = (Integer) tblCertificate.getValueAt(tblCertificate.getSelectedRow(), 0);

        if (id > -1) {
            int option  = JOptionPane.showConfirmDialog(rootPane, "Do You Want To Delete This Record");
            if(option ==  0){
                int re =certificateDAOImpl.deleteCertificate(id);
                if(re>0){
                    fillCertificateTable(certificateType);
                    clearFields();
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Error");
                }
            }
        }
    }
    
    private void generateReport(String operation){
        Integer certificateId = (Integer) tblCertificate.getValueAt(tblCertificate.getSelectedRow(), 0);
        String path = "D:\\Gambat\\MCGambat\\src\\reports\\";
        //path = "report\\"
        switch(certificateType){
            case "Boundaries Certificate" :
                path+="Form.jrxml";
                break;
            case "No Objection Certificate" :
                path+="no_objection_certificate-final.jrxml";
                break;
            case "Tax Property Certificate":
                path+="gambat.jrxml";
                break;
            case "Residence Certificate":
                path+="govt.jrxml";
                break;
        }
        if (certificateId > -1) {
            try{
                HashMap<String, Object> hm = new HashMap<String, Object>();
                hm.put("certificateId",certificateId);
            
                JasperPrint jasperPrint;
                java.sql.Connection con = mcgambat.com.connection.DBConnection.getInstance();
                JasperReport jasperReport = JasperCompileManager.compileReport(
                path);   
                jasperPrint = JasperFillManager.fillReport(jasperReport, hm, con);
                if(operation.equals("view")){
                    JasperViewer.viewReport(jasperPrint , false);
                }
                else if(operation.equals("print")){
                    JasperPrintManager.printReport(jasperPrint, true);
                }
            }catch(JRException ex){
                ex.printStackTrace();
            }
        } else {
            new MessageForm("Error", "Please select record", "error.png").setVisible(true);
        }    
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        deleteCertificate = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCertificate = new javax.swing.JTable();
        btnAdd = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboctype = new javax.swing.JComboBox<>();
        panelNOC = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        nocTfName = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        nocTfFname = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        nocTfMohalla = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        nocTfMuncipal = new javax.swing.JTextField();
        panelRd = new javax.swing.JPanel();
        rdTfName = new javax.swing.JTextField();
        rdTfFname = new javax.swing.JTextField();
        rdTfCaste = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        rdTfHouseNo = new javax.swing.JTextField();
        rdTfMohalla = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        rdTfRecommended = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        rdTfCnic = new javax.swing.JFormattedTextField();
        panelTP = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        tpCommiteeNo = new javax.swing.JTextField();
        tpDetails = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        tpMohalla = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        tpGambat = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        tpTax = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tpName = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        tpFname = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        tpCaste = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        tpConsisting = new javax.swing.JTextField();
        panelBC = new javax.swing.JPanel();
        BCProperty = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        bcMohalla = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        bcMeasure = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        bcTax = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        bcName = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        bcFname = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        bcCaste = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        bcNorth = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        bcSouth = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        bcEast = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        bcWest = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfNoMcg = new javax.swing.JTextField();
        dateDate = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        btnPrintCert = new javax.swing.JLabel();
        btnViewCer = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        deleteCertificate.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        deleteCertificate.setText("Delete User");
        deleteCertificate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteCertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCertificateActionPerformed(evt);
            }
        });
        jPopupMenu1.add(deleteCertificate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search Certificates");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, 26));

        tfSearch.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });
        jPanel2.add(tfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, 220, -1));

        tblCertificate.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        tblCertificate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCertificate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblCertificate.setRowHeight(20);
        tblCertificate.setSelectionBackground(new java.awt.Color(11, 18, 29));
        tblCertificate.setSelectionForeground(new java.awt.Color(140, 198, 62));
        tblCertificate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCertificateMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCertificateMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblCertificate);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 75, 920, 610));

        btnAdd.setBackground(new java.awt.Color(53, 168, 83));
        btnAdd.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAdd.setText("Add Certificate");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setOpaque(true);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 138, 34));

        btnUpdate.setBackground(new java.awt.Color(53, 168, 83));
        btnUpdate.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUpdate.setText("Update Certificate");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setOpaque(true);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, 152, 34));

        jLabel10.setBackground(new java.awt.Color(53, 168, 83));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Reset");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 620, 70, 34));

        comboctype.setBackground(new java.awt.Color(204, 204, 255));
        comboctype.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        comboctype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boundaries Certificate", "No Objection Certificate", "Tax Property Certificate", "Residence Certificate" }));
        comboctype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboctypeItemStateChanged(evt);
            }
        });
        jPanel2.add(comboctype, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 200, 30));

        panelNOC.setBackground(new java.awt.Color(255, 255, 255));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel48.setText("Name :");

        nocTfName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        nocTfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nocTfNameActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel49.setText("Father Name :");

        nocTfFname.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        nocTfFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nocTfFnameActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel50.setText("Mohalla :");

        nocTfMohalla.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        nocTfMohalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nocTfMohallaActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel51.setText("Municipal :");

        nocTfMuncipal.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        nocTfMuncipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nocTfMuncipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNOCLayout = new javax.swing.GroupLayout(panelNOC);
        panelNOC.setLayout(panelNOCLayout);
        panelNOCLayout.setHorizontalGroup(
            panelNOCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNOCLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelNOCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNOCLayout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nocTfMohalla, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNOCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelNOCLayout.createSequentialGroup()
                            .addComponent(jLabel49)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(nocTfFname))
                        .addGroup(panelNOCLayout.createSequentialGroup()
                            .addComponent(jLabel48)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nocTfName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelNOCLayout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nocTfMuncipal, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        panelNOCLayout.setVerticalGroup(
            panelNOCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNOCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNOCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nocTfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelNOCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nocTfFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelNOCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nocTfMohalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelNOCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nocTfMuncipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(267, Short.MAX_VALUE))
        );

        jPanel2.add(panelNOC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 390, 440));

        panelRd.setBackground(new java.awt.Color(255, 255, 255));

        rdTfName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        rdTfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTfNameActionPerformed(evt);
            }
        });

        rdTfFname.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        rdTfFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTfFnameActionPerformed(evt);
            }
        });

        rdTfCaste.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        rdTfCaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTfCasteActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel41.setText("Name :");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel42.setText("Father Name :");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel43.setText("Bycaste :");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel44.setText("House No :");

        rdTfHouseNo.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        rdTfHouseNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTfHouseNoActionPerformed(evt);
            }
        });

        rdTfMohalla.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        rdTfMohalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTfMohallaActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel45.setText("Mohalla :");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel46.setText("Cnic No :");

        rdTfRecommended.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        rdTfRecommended.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTfRecommendedActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel47.setText("Recommended By :");

        try {
            rdTfCnic.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        rdTfCnic.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N

        javax.swing.GroupLayout panelRdLayout = new javax.swing.GroupLayout(panelRd);
        panelRd.setLayout(panelRdLayout);
        panelRdLayout.setHorizontalGroup(
            panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRdLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRdLayout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdTfMohalla, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRdLayout.createSequentialGroup()
                        .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRdLayout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdTfHouseNo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelRdLayout.createSequentialGroup()
                                    .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel42)
                                        .addComponent(jLabel43))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(rdTfFname)
                                        .addComponent(rdTfCaste, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelRdLayout.createSequentialGroup()
                                    .addComponent(jLabel41)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdTfName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25))
                    .addGroup(panelRdLayout.createSequentialGroup()
                        .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRdLayout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdTfRecommended, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRdLayout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdTfCnic)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelRdLayout.setVerticalGroup(
            panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdTfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdTfFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdTfCaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdTfHouseNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdTfMohalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRdLayout.createSequentialGroup()
                        .addComponent(rdTfCnic)
                        .addGap(1, 1, 1)))
                .addGroup(panelRdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdTfRecommended, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        jPanel2.add(panelRd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 390, 440));

        panelTP.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel31.setText("Commitee No:");

        tpCommiteeNo.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tpCommiteeNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpCommiteeNoActionPerformed(evt);
            }
        });

        tpDetails.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tpDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpDetailsActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel32.setText("Details :");

        tpMohalla.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tpMohalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpMohallaActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel33.setText("Mohalla :");

        tpGambat.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tpGambat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpGambatActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel34.setText("Gambat :");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel36.setText("Tax :");

        tpTax.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tpTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpTaxActionPerformed(evt);
            }
        });
        tpTax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tpTaxKeyTyped(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel37.setText("Name :");

        tpName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tpName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpNameActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel38.setText("Father Name :");

        tpFname.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tpFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpFnameActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel39.setText("Consisting Of :");

        tpCaste.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tpCaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpCasteActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel40.setText("Bycaste :");

        tpConsisting.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tpConsisting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpConsistingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTPLayout = new javax.swing.GroupLayout(panelTP);
        panelTP.setLayout(panelTPLayout);
        panelTPLayout.setHorizontalGroup(
            panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTPLayout.createSequentialGroup()
                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTPLayout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tpFname)
                            .addComponent(tpCaste, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelTPLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTPLayout.createSequentialGroup()
                                    .addComponent(jLabel37)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tpName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTPLayout.createSequentialGroup()
                                    .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel36)
                                        .addComponent(jLabel34))
                                    .addGap(48, 48, 48)
                                    .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tpGambat)
                                        .addComponent(tpTax)))
                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTPLayout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(tpMohalla, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelTPLayout.createSequentialGroup()
                                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tpDetails)
                                    .addComponent(tpCommiteeNo, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(tpConsisting, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))))))
                .addGap(25, 25, 25))
        );
        panelTPLayout.setVerticalGroup(
            panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpCommiteeNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpConsisting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpMohalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpGambat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tpTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpCaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2.add(panelTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 390, 440));

        panelBC.setBackground(new java.awt.Color(255, 255, 255));

        BCProperty.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        BCProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCPropertyActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel18.setText("Property No :");

        bcMohalla.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        bcMohalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcMohallaActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel19.setText("Mohalla :");

        bcMeasure.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        bcMeasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcMeasureActionPerformed(evt);
            }
        });
        bcMeasure.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bcMeasureKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel20.setText("Measuring :");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel21.setText("Sq:Ft");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel22.setText("Tax :");

        bcTax.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        bcTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcTaxActionPerformed(evt);
            }
        });
        bcTax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bcTaxKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel23.setText("Name :");

        bcName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        bcName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcNameActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel24.setText("Father Name :");

        bcFname.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        bcFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcFnameActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel25.setText("Bycaste :");

        bcCaste.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        bcCaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcCasteActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel26.setText("North :");

        bcNorth.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        bcNorth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcNorthActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel27.setText("South :");

        bcSouth.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        bcSouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcSouthActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel28.setText("East :");

        bcEast.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        bcEast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcEastActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel29.setText("West :");

        bcWest.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        bcWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcWestActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel30.setText("Rupees");

        javax.swing.GroupLayout panelBCLayout = new javax.swing.GroupLayout(panelBC);
        panelBC.setLayout(panelBCLayout);
        panelBCLayout.setHorizontalGroup(
            panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBCLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBCLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(20, 20, 20)
                        .addComponent(BCProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelBCLayout.createSequentialGroup()
                            .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelBCLayout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addGap(26, 26, 26)
                                    .addComponent(bcEast, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelBCLayout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addGap(18, 18, 18)
                                    .addComponent(bcNorth, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(26, 26, 26)
                            .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelBCLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bcSouth, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelBCLayout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addGap(14, 14, 14)
                                    .addComponent(bcWest, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBCLayout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bcName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelBCLayout.createSequentialGroup()
                                    .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(panelBCLayout.createSequentialGroup()
                                            .addComponent(jLabel22)
                                            .addGap(49, 49, 49))
                                        .addComponent(jLabel20))
                                    .addGap(30, 30, 30)
                                    .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bcTax)
                                        .addComponent(bcMeasure, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                    .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelBCLayout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(bcMohalla)))
                            .addGroup(panelBCLayout.createSequentialGroup()
                                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bcFname)
                                    .addComponent(bcCaste, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBCLayout.setVerticalGroup(
            panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcMohalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcMeasure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bcTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcCaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcNorth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcSouth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcEast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcWest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel2.add(panelBC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 390, 440));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel3.setText("Certificate Type");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 45, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel17.setText("No/MCG:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 90, -1, 27));

        tfNoMcg.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tfNoMcg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNoMcgActionPerformed(evt);
            }
        });
        jPanel2.add(tfNoMcg, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 90, 220, -1));

        dateDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jPanel2.add(dateDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 133, 220, 27));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel16.setText("Date :");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 133, -1, 27));

        btnPrintCert.setBackground(new java.awt.Color(53, 168, 83));
        btnPrintCert.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        btnPrintCert.setForeground(new java.awt.Color(255, 255, 255));
        btnPrintCert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPrintCert.setText("Print Certificate");
        btnPrintCert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintCert.setOpaque(true);
        btnPrintCert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintCertMouseClicked(evt);
            }
        });
        jPanel2.add(btnPrintCert, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 138, 34));

        btnViewCer.setBackground(new java.awt.Color(53, 168, 83));
        btnViewCer.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        btnViewCer.setForeground(new java.awt.Color(255, 255, 255));
        btnViewCer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnViewCer.setText("View Certificate");
        btnViewCer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewCer.setOpaque(true);
        btnViewCer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewCerMouseClicked(evt);
            }
        });
        jPanel2.add(btnViewCer, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 138, 34));

        jPanel1.setBackground(new java.awt.Color(53, 168, 83));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Certificate");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(550, 550, 550)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Add");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Update");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Delete");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Reset");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Back");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Exit");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed

    }//GEN-LAST:event_tfSearchActionPerformed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        // TODO add your handling code here:
        CommonMethods.searchFromTable(tblCertificate, tfSearch);
    }//GEN-LAST:event_tfSearchKeyReleased

    private void tblCertificateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCertificateMouseReleased
                // TODO add your handling code here:
                if (evt.isPopupTrigger()) {
                    jPopupMenu1.show(tblCertificate, evt.getX(), evt.getY());
                }
    }//GEN-LAST:event_tblCertificateMouseReleased

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        addCertificate(0, "add");        
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        Integer id = (Integer) tblCertificate.getValueAt(tblCertificate.getSelectedRow(), 0);

        if (id > -1) {
            addCertificate(id, "update");

        } else {
            new MessageForm("Error", "Please select record", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        clearFields();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void comboctypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboctypeItemStateChanged
        // TODO add your handling code here:
        certificateType = comboctype.getSelectedItem().toString();
        fillCertificateTable(certificateType);
        showPanel(certificateType);
        clearFields();
    }//GEN-LAST:event_comboctypeItemStateChanged

    private void tfNoMcgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNoMcgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNoMcgActionPerformed

    private void BCPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCPropertyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BCPropertyActionPerformed

    private void bcMohallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcMohallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcMohallaActionPerformed

    private void bcMeasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcMeasureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcMeasureActionPerformed

    private void bcTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcTaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcTaxActionPerformed

    private void bcNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcNameActionPerformed

    private void bcFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcFnameActionPerformed

    private void bcCasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcCasteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcCasteActionPerformed

    private void bcNorthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcNorthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcNorthActionPerformed

    private void bcSouthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcSouthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcSouthActionPerformed

    private void bcEastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcEastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcEastActionPerformed

    private void bcWestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcWestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcWestActionPerformed

    private void tpCommiteeNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpCommiteeNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpCommiteeNoActionPerformed

    private void tpDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpDetailsActionPerformed

    private void tpMohallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpMohallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpMohallaActionPerformed

    private void tpGambatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpGambatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpGambatActionPerformed

    private void tpTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpTaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpTaxActionPerformed

    private void tpNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpNameActionPerformed

    private void tpFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpFnameActionPerformed

    private void tpCasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpCasteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpCasteActionPerformed

    private void tpConsistingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpConsistingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpConsistingActionPerformed

    private void rdTfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTfNameActionPerformed

    private void rdTfFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTfFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTfFnameActionPerformed

    private void rdTfCasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTfCasteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTfCasteActionPerformed

    private void rdTfHouseNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTfHouseNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTfHouseNoActionPerformed

    private void rdTfMohallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTfMohallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTfMohallaActionPerformed

    private void rdTfRecommendedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTfRecommendedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTfRecommendedActionPerformed

    private void nocTfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nocTfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nocTfNameActionPerformed

    private void nocTfFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nocTfFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nocTfFnameActionPerformed

    private void nocTfMohallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nocTfMohallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nocTfMohallaActionPerformed

    private void nocTfMuncipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nocTfMuncipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nocTfMuncipalActionPerformed

    private void tblCertificateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCertificateMouseClicked
        // TODO add your handling code here:
        Integer id = (Integer) tblCertificate.getValueAt(tblCertificate.getSelectedRow(), 0);

        if (id > -1) {
            fillFields(id);
        }
    }//GEN-LAST:event_tblCertificateMouseClicked

    private void deleteCertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCertificateActionPerformed
        deleteCertificate();
    }//GEN-LAST:event_deleteCertificateActionPerformed

    private void tpTaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpTaxKeyTyped
        // TODO add your handling code here:
        char ch = evt.getKeyChar();
        if(Character.isAlphabetic(ch) || Character.isWhitespace(ch))
        {
            evt.consume();
        }
    }//GEN-LAST:event_tpTaxKeyTyped

    private void bcMeasureKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bcMeasureKeyTyped
        // TODO add your handling code here:
        char ch = evt.getKeyChar();
        if(Character.isAlphabetic(ch) || Character.isWhitespace(ch))
        {
            evt.consume();
        }
    }//GEN-LAST:event_bcMeasureKeyTyped

    private void bcTaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bcTaxKeyTyped
        // TODO add your handling code here:
        char ch = evt.getKeyChar();
        if(Character.isAlphabetic(ch) || Character.isWhitespace(ch))
        {
            evt.consume();
        }
    }//GEN-LAST:event_bcTaxKeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        addCertificate(0,"add");

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Integer id = (Integer) tblCertificate.getValueAt(tblCertificate.getSelectedRow(), 0);

        if (id > -1) {
            addCertificate(id, "update");

        } else {
            new MessageForm("Error", "Please select record", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        deleteCertificate();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnPrintCertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintCertMouseClicked
        // TODO add your handling code here:
        generateReport("print");
    }//GEN-LAST:event_btnPrintCertMouseClicked

    private void btnViewCerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewCerMouseClicked
        // TODO add your handling code here:
        generateReport("view");
    }//GEN-LAST:event_btnViewCerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CertificateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CertificateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CertificateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CertificateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CertificateFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BCProperty;
    private javax.swing.JTextField bcCaste;
    private javax.swing.JTextField bcEast;
    private javax.swing.JTextField bcFname;
    private javax.swing.JTextField bcMeasure;
    private javax.swing.JTextField bcMohalla;
    private javax.swing.JTextField bcName;
    private javax.swing.JTextField bcNorth;
    private javax.swing.JTextField bcSouth;
    private javax.swing.JTextField bcTax;
    private javax.swing.JTextField bcWest;
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnPrintCert;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JLabel btnViewCer;
    private javax.swing.JComboBox<String> comboctype;
    private com.toedter.calendar.JDateChooser dateDate;
    private javax.swing.JMenuItem deleteCertificate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nocTfFname;
    private javax.swing.JTextField nocTfMohalla;
    private javax.swing.JTextField nocTfMuncipal;
    private javax.swing.JTextField nocTfName;
    private javax.swing.JPanel panelBC;
    private javax.swing.JPanel panelNOC;
    private javax.swing.JPanel panelRd;
    private javax.swing.JPanel panelTP;
    private javax.swing.JTextField rdTfCaste;
    private javax.swing.JFormattedTextField rdTfCnic;
    private javax.swing.JTextField rdTfFname;
    private javax.swing.JTextField rdTfHouseNo;
    private javax.swing.JTextField rdTfMohalla;
    private javax.swing.JTextField rdTfName;
    private javax.swing.JTextField rdTfRecommended;
    private javax.swing.JTable tblCertificate;
    private javax.swing.JTextField tfNoMcg;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tpCaste;
    private javax.swing.JTextField tpCommiteeNo;
    private javax.swing.JTextField tpConsisting;
    private javax.swing.JTextField tpDetails;
    private javax.swing.JTextField tpFname;
    private javax.swing.JTextField tpGambat;
    private javax.swing.JTextField tpMohalla;
    private javax.swing.JTextField tpName;
    private javax.swing.JTextField tpTax;
    // End of variables declaration//GEN-END:variables
}
