/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumextremep;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Axel D
 */
public class ForstaSida extends javax.swing.JFrame {

    /**
     * Creates new form Startsida
     */
    public ForstaSida() {
        initComponents();
        fetchBlognames();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBlog = new javax.swing.JTable();
        spCalender = new javax.swing.JScrollPane();
        taCalender = new javax.swing.JTextArea();
        lblBakgrundVit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblRubrik.setAlignment(java.awt.Label.CENTER);
        lblRubrik.setBackground(new java.awt.Color(255, 255, 255));
        lblRubrik.setFont(new java.awt.Font("Impact", 0, 52)); // NOI18N
        lblRubrik.setText("Informatikblogg");
        getContentPane().add(lblRubrik);
        lblRubrik.setBounds(240, 0, 480, 120);

        tfAnvNamn.setText("Användarnamn");
        tfAnvNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAnvNamnActionPerformed(evt);
            }
        });
        getContentPane().add(tfAnvNamn);
        tfAnvNamn.setBounds(770, 50, 160, 30);

        pfLosenord.setText("jPasswordField1");
        getContentPane().add(pfLosenord);
        pfLosenord.setBounds(770, 100, 160, 30);

        btnLoggaIn.setText("Logga in");
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoggaIn);
        btnLoggaIn.setBounds(840, 140, 93, 29);

        taBlogFlow.setColumns(20);
        taBlogFlow.setRows(5);
        spBlogFlow.setViewportView(taBlogFlow);

        getContentPane().add(spBlogFlow);
        spBlogFlow.setBounds(260, 210, 510, 360);

        tblBlog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titel", "Användare"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBlog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBlogMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBlog);
        if (tblBlog.getColumnModel().getColumnCount() > 0) {
            tblBlog.getColumnModel().getColumn(0).setResizable(false);
            tblBlog.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(772, 212, 210, 360);

        taCalender.setColumns(20);
        taCalender.setRows(5);
        taCalender.setText("Här ska kalendern \nligga");
        spCalender.setViewportView(taCalender);

        getContentPane().add(spCalender);
        spCalender.setBounds(30, 210, 166, 150);

        lblBakgrundVit.setBackground(java.awt.Color.white);
        lblBakgrundVit.setForeground(new java.awt.Color(255, 255, 255));
        lblBakgrundVit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scrumextremep/Namnlös.jpg"))); // NOI18N
        lblBakgrundVit.setText("jLabel1");
        getContentPane().add(lblBakgrundVit);
        lblBakgrundVit.setBounds(0, 0, 1000, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfAnvNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAnvNamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAnvNamnActionPerformed

    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
        InloggadSida ny = new InloggadSida();
        ny.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoggaInActionPerformed

    private void tblBlogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBlogMouseClicked
        tblBlog.removeAll();
        int a = tblBlog.getSelectedRow();
        int b = tblBlog.getSelectedColumn();
        String tableValue = (String) tblBlog.getModel().getValueAt(a, b);
        
        String sqlquery = "Select TEXT from BLOGGINLAGG where TITEL = '" + tableValue + "'";
        String titel = new String();
        
        try {
            titel = Databas.getDatabas().fetchSingle(sqlquery);
            
            
                taBlogFlow.setText(titel);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tblBlogMouseClicked

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
            java.util.logging.Logger.getLogger(ForstaSida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForstaSida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForstaSida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForstaSida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForstaSida().setVisible(true);
            }
        });
    }
    
        private void fetchBlognames() {
        String sqlquery = "select BLOGGINLAGG.TITEL from BLOGGINLAGG";
        ArrayList<HashMap<String, String>> blognames = new ArrayList<>();
        try {
         blognames = Databas.getDatabas().fetchRows(sqlquery);
         
         for(int i = 0; i < blognames.size(); i++) {
             String names = blognames.get(i).get("TITEL");
             
             DefaultTableModel dmt = (DefaultTableModel)tblBlog.getModel();
             
             dmt.addRow(new Object[] {names});
                 }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
         
 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBakgrundVit;
    private java.awt.Label lblRubrik;
    private javax.swing.JPasswordField pfLosenord;
    private javax.swing.JScrollPane spBlogFlow;
    private javax.swing.JScrollPane spCalender;
    private javax.swing.JTextArea taBlogFlow;
    private javax.swing.JTextArea taCalender;
    private javax.swing.JTable tblBlog;
    private javax.swing.JTextField tfAnvNamn;
    // End of variables declaration//GEN-END:variables
}
