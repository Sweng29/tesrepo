/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcgambat.com.business;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mcgambat.com.daoImpl.CheckIssueDaoImpl;
import mcgambat.com.models.CheckIssueModel;
import mcgambat.com.utility.CommonMethods;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Asif Ali
 */
public class CheckIssue extends javax.swing.JFrame {

    /**
     * Creates new form CheckIssue
     */
    public CheckIssue() {

        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        fillCheckIssueTable();
        jupdatemenu.setEnabled(false);
        jdeletemenu.setEnabled(false);
        jupdatebtn.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpopup = new javax.swing.JPopupMenu();
        Delete = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jcheckissuetable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jchequeno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jvoucherno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jdescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jchequeamount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jfavour = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jaccountinitials = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jaccountofficer = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcmo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jadministrator = new javax.swing.JTextField();
        jaddbtn = new javax.swing.JLabel();
        jupdatebtn = new javax.swing.JLabel();
        jresetbtn = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jdate = new com.toedter.calendar.JDateChooser();
        jsearch = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jaddmenu = new javax.swing.JMenuItem();
        jupdatemenu = new javax.swing.JMenuItem();
        jdeletemenu = new javax.swing.JMenuItem();
        jbackmenu = new javax.swing.JMenuItem();

        Delete.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jpopup.add(Delete);

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(53, 168, 83));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Check Issue");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("X");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(547, 547, 547)
                .addComponent(jLabel12)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12))
                .addGap(35, 35, 35))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1403, 94);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jcheckissuetable.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        jcheckissuetable.setModel(new javax.swing.table.DefaultTableModel(
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
        jcheckissuetable.setRowHeight(20);
        jcheckissuetable.setSelectionBackground(new java.awt.Color(11, 18, 29));
        jcheckissuetable.setSelectionForeground(new java.awt.Color(140, 198, 62));
        jcheckissuetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcheckissuetableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcheckissuetableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jcheckissuetable);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Cheque No");

        jchequeno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jchequeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchequenoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Voucher No");

        jvoucherno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Description Item");

        jdescription.setColumns(20);
        jdescription.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jdescription.setRows(5);
        jScrollPane2.setViewportView(jdescription);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Cheque Amount");

        jchequeamount.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("Favour");

        jfavour.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("Account Initials");

        jaccountinitials.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("Account Officer");

        jaccountofficer.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setText("Cmo");

        jcmo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setText("Administrator");

        jadministrator.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jaddbtn.setBackground(new java.awt.Color(53, 168, 83));
        jaddbtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jaddbtn.setForeground(new java.awt.Color(255, 255, 255));
        jaddbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jaddbtn.setText("Add");
        jaddbtn.setOpaque(true);
        jaddbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jaddbtnMouseClicked(evt);
            }
        });

        jupdatebtn.setBackground(new java.awt.Color(53, 168, 83));
        jupdatebtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jupdatebtn.setForeground(new java.awt.Color(255, 255, 255));
        jupdatebtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jupdatebtn.setText("Update");
        jupdatebtn.setToolTipText("");
        jupdatebtn.setOpaque(true);
        jupdatebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jupdatebtnMouseClicked(evt);
            }
        });

        jresetbtn.setBackground(new java.awt.Color(53, 168, 83));
        jresetbtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jresetbtn.setForeground(new java.awt.Color(255, 255, 255));
        jresetbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jresetbtn.setText("Reset");
        jresetbtn.setOpaque(true);
        jresetbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jresetbtnMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setText("Date");

        jsearch.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsearchActionPerformed(evt);
            }
        });
        jsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsearchKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jresetbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jupdatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addComponent(jchequeno, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jchequeamount)
                            .addComponent(jfavour)
                            .addComponent(jaccountinitials)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jaccountofficer)
                            .addComponent(jcmo)
                            .addComponent(jadministrator)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(86, 86, 86)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jvoucherno)
                            .addComponent(jdate, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jchequeno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jvoucherno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jchequeamount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jfavour, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jaccountinitials, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jaccountofficer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcmo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jadministrator, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jaddbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jupdatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jresetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 90, 1403, 680);

        jMenu1.setMnemonic('M');
        jMenu1.setText("Menu");

        jaddmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jaddmenu.setText("Add");
        jaddmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jaddmenuActionPerformed(evt);
            }
        });
        jMenu1.add(jaddmenu);

        jupdatemenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jupdatemenu.setText("Update");
        jupdatemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jupdatemenuActionPerformed(evt);
            }
        });
        jMenu1.add(jupdatemenu);

        jdeletemenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jdeletemenu.setText("Delete");
        jdeletemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdeletemenuActionPerformed(evt);
            }
        });
        jMenu1.add(jdeletemenu);

        jbackmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jbackmenu.setText("Back");
        jbackmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbackmenuActionPerformed(evt);
            }
        });
        jMenu1.add(jbackmenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jchequenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchequenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jchequenoActionPerformed

    private void jaddbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jaddbtnMouseClicked
        addCheckIssueDetails();
    }//GEN-LAST:event_jaddbtnMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jcheckissuetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcheckissuetableMouseClicked
        jupdatebtn.setEnabled(true);
        jaddbtn.setEnabled(false);
        jaddmenu.setEnabled(false);
        jupdatemenu.setEnabled(true);
        jdeletemenu.setEnabled(true);
        Date d = (Date) jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 1);
        jdate.setDate(d);
        jchequeno.setText(jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 2).toString());
        jvoucherno.setText(jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 3).toString());
        jdescription.setText(jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 4).toString());
        jchequeamount.setText(jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 5).toString());
        jfavour.setText(jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 6).toString());
        jaccountinitials.setText(jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 7).toString());
        jaccountofficer.setText(jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 8).toString());
        jcmo.setText(jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 9).toString());
        jadministrator.setText(jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 10).toString());
    }//GEN-LAST:event_jcheckissuetableMouseClicked

    private void jupdatebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jupdatebtnMouseClicked
       if(jcheckissuetable.getSelectedRow()>-1){
        updateCheckIssuesDetail();
       }else{
        new MessageForm("Error", "Please select record", "error.png").setVisible(true);
       }
    }//GEN-LAST:event_jupdatebtnMouseClicked

    private void jresetbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jresetbtnMouseClicked
        clearFields();

    }//GEN-LAST:event_jresetbtnMouseClicked

    private void jcheckissuetableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcheckissuetableMouseReleased
        if (jcheckissuetable.getSelectedRow() > -1) {
            if (evt.isPopupTrigger()) {
                jpopup.show(jcheckissuetable, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jcheckissuetableMouseReleased

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        Integer row = jcheckissuetable.getSelectedRow();

        if (row > -1) {
            Integer id = (Integer) jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 0);
            deleteEmployee(id);
        } else {
            new MessageForm("Error", "Please select record", "error.png").setVisible(true);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void jsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jsearchActionPerformed

    private void jsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jsearchKeyReleased
        CommonMethods.searchFromTable(jcheckissuetable, jsearch);
    }//GEN-LAST:event_jsearchKeyReleased

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
       jcheckissuetable.clearSelection();
       jupdatebtn.setEnabled(false);
       jaddbtn.setEnabled(true);
       jaddmenu.setEnabled(true);
       jupdatemenu.setEnabled(false);
       jdeletemenu.setEnabled(false);
       clearFields();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jaddmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jaddmenuActionPerformed
       addCheckIssueDetails();
    }//GEN-LAST:event_jaddmenuActionPerformed

    private void jupdatemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jupdatemenuActionPerformed
        if(jcheckissuetable.getSelectedRow()>-1){
        updateCheckIssuesDetail();
       }else{
        new MessageForm("Error", "Please select record", "error.png").setVisible(true);
       }

    }//GEN-LAST:event_jupdatemenuActionPerformed

    private void jdeletemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdeletemenuActionPerformed
 Integer row = jcheckissuetable.getSelectedRow();

        if (row > -1) {
            Integer id = (Integer) jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 0);
            deleteEmployee(id);
        } else {
            new MessageForm("Error", "Please select record", "error.png").setVisible(true);
        }      

    }//GEN-LAST:event_jdeletemenuActionPerformed

    private void jbackmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbackmenuActionPerformed
       this.dispose();
       new MainFrame().setVisible(true);
    }//GEN-LAST:event_jbackmenuActionPerformed

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
            java.util.logging.Logger.getLogger(CheckIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckIssue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckIssue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jaccountinitials;
    private javax.swing.JTextField jaccountofficer;
    private javax.swing.JLabel jaddbtn;
    private javax.swing.JMenuItem jaddmenu;
    private javax.swing.JTextField jadministrator;
    private javax.swing.JMenuItem jbackmenu;
    private javax.swing.JTable jcheckissuetable;
    private javax.swing.JTextField jchequeamount;
    private javax.swing.JTextField jchequeno;
    private javax.swing.JTextField jcmo;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JMenuItem jdeletemenu;
    private javax.swing.JTextArea jdescription;
    private javax.swing.JTextField jfavour;
    private javax.swing.JPopupMenu jpopup;
    private javax.swing.JLabel jresetbtn;
    private javax.swing.JTextField jsearch;
    private javax.swing.JLabel jupdatebtn;
    private javax.swing.JMenuItem jupdatemenu;
    private javax.swing.JTextField jvoucherno;
    // End of variables declaration//GEN-END:variables

    private void fillCheckIssueTable() {
        CheckIssueDaoImpl issueDaoImpl = new CheckIssueDaoImpl();
        CommonMethods.fillTables(issueDaoImpl.getAllCheckIssues(), jcheckissuetable, jScrollPane1, this);
    }

    private void addCheckIssueDetails() {
        CheckIssueModel checkIssueModel = new CheckIssueModel();
        Timestamp timestamp = new Timestamp(jdate.getDate().getTime());
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        String checkNo = jchequeno.getText();
        String voucherNo = jvoucherno.getText();
        String description = jdescription.getText();
        Double checkAmount = Double.parseDouble(jchequeamount.getText());
        String favour = jfavour.getText();
        String accountInitials = jaccountinitials.getText();
        String accountOfficer = jaccountofficer.getText();
        String cmo = jcmo.getText();
        String administrator = jadministrator.getText();
        checkIssueModel.setCheckDate(timestamp);
        checkIssueModel.setCheckNo(checkNo);
        checkIssueModel.setVoucherNo(voucherNo);
        checkIssueModel.setDesciptionItem(description);
        checkIssueModel.setChequeAmount(checkAmount);
        checkIssueModel.setFavour(favour);
        checkIssueModel.setAccountInitials(accountInitials);
        checkIssueModel.setAccountOfficer(accountOfficer);
        checkIssueModel.setCmo(cmo);
        checkIssueModel.setAdministrator(administrator);
        checkIssueModel.setCreatedDate(currentDate);
        checkIssueModel.setModifiedDate(currentDate);
        CheckIssueDaoImpl checkIssueDaoImpl = new CheckIssueDaoImpl();
        int row = checkIssueDaoImpl.insertCheckIssueRecord(checkIssueModel);
        if (row > 0) {
            new MessageForm("Success", "Added Successfully", "info.png").setVisible(true);
            fillCheckIssueTable();
            clearFields();
        } else {
            new MessageForm("Error", "Added UnSuccessfully", "error.png").setVisible(true);
        }

    }

    private void updateCheckIssuesDetail() {

        CheckIssueModel checkIssueModel = new CheckIssueModel();
        Timestamp timestamp = new Timestamp(jdate.getDate().getTime());
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        String checkNo = jchequeno.getText();
        String voucherNo = jvoucherno.getText();
        String description = jdescription.getText();
        Double checkAmount = Double.parseDouble(jchequeamount.getText());
        String favour = jfavour.getText();
        String accountInitials = jaccountinitials.getText();
        String accountOfficer = jaccountofficer.getText();
        String cmo = jcmo.getText();
        String administrator = jadministrator.getText();
        int id = (int) jcheckissuetable.getValueAt(jcheckissuetable.getSelectedRow(), 0);
        checkIssueModel.setCheckDate(timestamp);
        checkIssueModel.setCheckNo(checkNo);
        checkIssueModel.setVoucherNo(voucherNo);
        checkIssueModel.setDesciptionItem(description);
        checkIssueModel.setChequeAmount(checkAmount);
        checkIssueModel.setFavour(favour);
        checkIssueModel.setAccountInitials(accountInitials);
        checkIssueModel.setAccountOfficer(accountOfficer);
        checkIssueModel.setCmo(cmo);
        checkIssueModel.setAdministrator(administrator);
        checkIssueModel.setCreatedDate(currentDate);
        checkIssueModel.setModifiedDate(currentDate);
        checkIssueModel.setCheckIssueId(id);
        CheckIssueDaoImpl checkIssueDaoImpl = new CheckIssueDaoImpl();
        int row = checkIssueDaoImpl.updateCheckIssueRecord(checkIssueModel);
        if (row > 0) {
            new MessageForm("Success", "Updated Successfully", "info.png").setVisible(true);
            fillCheckIssueTable();
            clearFields();
        } else {
            new MessageForm("Error", "Updated UnSuccessfully", "error.png").setVisible(true);
        }

    }

    private void clearFields() {
        jdate.setDate(null);
        jchequeno.setText(" ");
        jvoucherno.setText(" ");
        jdescription.setText(" ");
        jchequeamount.setText(" ");
        jfavour.setText(" ");
        jaccountinitials.setText(" ");
        jaccountofficer.setText(" ");
        jcmo.setText(" ");
        jadministrator.setText(" ");

    }

    private void deleteEmployee(Integer id) {
        CheckIssueDaoImpl checkIssueDaoImpl = new CheckIssueDaoImpl();
        int row = checkIssueDaoImpl.deleteCheckIssueRecord(id);
        if (row > 0) {
            new MessageForm("Success", "Deleted Successfully", "info.png").setVisible(true);
            fillCheckIssueTable();
        } else {
            new MessageForm("Error", "Deleted UnSuccessfully", "error.png").setVisible(true);
        }

    }

}
