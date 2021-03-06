/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumextremep;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Axel D
 */
public class ForstaSida extends javax.swing.JFrame {

    private String anvID;
    /**
     * Creates new form Startsida
     */
    public ForstaSida() {
        initComponents();
        fetchBlognamesInformell();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRubrik = new java.awt.Label();
        tfAnvNamn = new javax.swing.JTextField();
        pfLosenord = new javax.swing.JPasswordField();
        btnLoggaIn = new javax.swing.JButton();
        spBlogFlow = new javax.swing.JScrollPane();
        taBlogFlow = new javax.swing.JTextArea();
        spBlogTitlar = new javax.swing.JScrollPane();
        tblBlogTitlar = new javax.swing.JTable();
        lblBakgrundVit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(790, 623));
        setMinimumSize(new java.awt.Dimension(790, 623));
        getContentPane().setLayout(null);

        lblRubrik.setAlignment(java.awt.Label.CENTER);
        lblRubrik.setBackground(new java.awt.Color(255, 255, 255));
        lblRubrik.setFont(new java.awt.Font("Impact", 0, 52)); // NOI18N
        lblRubrik.setText("Informatikblogg");
        getContentPane().add(lblRubrik);
        lblRubrik.setBounds(100, 20, 480, 120);

        tfAnvNamn.setText("Användarnamn");
        tfAnvNamn.setRequestFocusEnabled(false);
        tfAnvNamn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfAnvNamnFocusGained(evt);
            }
        });
        getContentPane().add(tfAnvNamn);
        tfAnvNamn.setBounds(600, 50, 160, 30);

        pfLosenord.setText("jPasswordField1");
        pfLosenord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pfLosenordFocusGained(evt);
            }
        });
        getContentPane().add(pfLosenord);
        pfLosenord.setBounds(600, 100, 160, 30);

        btnLoggaIn.setText("Logga in");
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoggaIn);
        btnLoggaIn.setBounds(680, 140, 78, 32);

        taBlogFlow.setEditable(false);
        taBlogFlow.setColumns(20);
        taBlogFlow.setRows(5);
        spBlogFlow.setViewportView(taBlogFlow);

        getContentPane().add(spBlogFlow);
        spBlogFlow.setBounds(20, 210, 510, 360);

        tblBlogTitlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBlogTitlar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBlogTitlarMouseClicked(evt);
            }
        });
        spBlogTitlar.setViewportView(tblBlogTitlar);
        if (tblBlogTitlar.getColumnModel().getColumnCount() > 0) {
            tblBlogTitlar.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(spBlogTitlar);
        spBlogTitlar.setBounds(560, 210, 210, 360);

        lblBakgrundVit.setBackground(java.awt.Color.white);
        lblBakgrundVit.setForeground(new java.awt.Color(255, 255, 255));
        lblBakgrundVit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scrumextremep/Namnlös.jpg"))); // NOI18N
        lblBakgrundVit.setText("jLabel1");
        getContentPane().add(lblBakgrundVit);
        lblBakgrundVit.setBounds(0, 0, 790, 630);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
        anvandarID();
        new InloggadSida(anvID).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoggaInActionPerformed

    private void anvandarID() {
        String anvNamn = tfAnvNamn.getText();
        String sqlFragaHamtaId = "select a_id from anvandare where anvnamn =  '" + anvNamn + "'";
        try
        {
            anvID = Databas.getDatabas().fetchSingle(sqlFragaHamtaId);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void tblBlogTitlarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBlogTitlarMouseClicked
        taBlogFlow.removeAll();
        int a = tblBlogTitlar.getSelectedRow();
        int b = tblBlogTitlar.getSelectedColumn();
        String tableValue = (String) tblBlogTitlar.getModel().getValueAt(a, b);
        
        String sqlquery = "Select TEXT from BLOGGINLAGG where TITEL = '" + tableValue + "'";
        String titel = new String();
        
        try {
            titel = Databas.getDatabas().fetchSingle(sqlquery);
            
            
                taBlogFlow.setText(titel);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tblBlogTitlarMouseClicked

    private void tfAnvNamnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAnvNamnFocusGained
        tfAnvNamn.setText("");
    }//GEN-LAST:event_tfAnvNamnFocusGained

    private void pfLosenordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfLosenordFocusGained
        pfLosenord.setText("");
    }//GEN-LAST:event_pfLosenordFocusGained
  
    private void fetchBlognamesInformell() {
        String sqlquery = "select blogginlagg.titel from blogginlagg where b_id = (select b_id from blogg where bloggnamn = 'Informell')";
        ArrayList<HashMap<String, String>> blognames = new ArrayList<>();
        try {
         blognames = Databas.getDatabas().fetchRows(sqlquery);
         
         for(int i = 0; i < blognames.size(); i++) {
             String names = blognames.get(i).get("TITEL");
             
             DefaultTableModel dmt = (DefaultTableModel)tblBlogTitlar.getModel();
             
             dmt.addRow(new Object[] {names});
                 }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
         
 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JLabel lblBakgrundVit;
    private java.awt.Label lblRubrik;
    private javax.swing.JPasswordField pfLosenord;
    private javax.swing.JScrollPane spBlogFlow;
    private javax.swing.JScrollPane spBlogTitlar;
    private javax.swing.JTextArea taBlogFlow;
    private javax.swing.JTable tblBlogTitlar;
    private javax.swing.JTextField tfAnvNamn;
    // End of variables declaration//GEN-END:variables
}
