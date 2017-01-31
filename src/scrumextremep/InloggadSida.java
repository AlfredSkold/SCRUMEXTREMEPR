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
 * @author Alfred
 */
public class InloggadSida extends javax.swing.JFrame {

    private String anvID;
    /**
     * Creates new form InloggadSida
     */
    public InloggadSida(String anvandarID) {
        initComponents();
        fetchBlognamesForskning();
        anvID = anvandarID;
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
        spBlogtitlar = new javax.swing.JScrollPane();
        tblBlogTitlar = new javax.swing.JTable();
        spCalender = new javax.swing.JScrollPane();
        taCalender = new javax.swing.JTextArea();
        tpBloggar = new javax.swing.JTabbedPane();
        spForskning = new javax.swing.JScrollPane();
        taForskning = new javax.swing.JTextArea();
        spUtbildning = new javax.swing.JScrollPane();
        taUtbildning = new javax.swing.JTextArea();
        btnLoggaUt = new javax.swing.JButton();
        btn_skapaInlagg = new javax.swing.JButton();
        lblBakgrundVit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        lblRubrik.setAlignment(java.awt.Label.CENTER);
        lblRubrik.setBackground(new java.awt.Color(255, 255, 255));
        lblRubrik.setFont(new java.awt.Font("Impact", 0, 52)); // NOI18N
        lblRubrik.setText("Informatikblogg");
        getContentPane().add(lblRubrik);
        lblRubrik.setBounds(270, 10, 480, 120);

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
        spBlogtitlar.setViewportView(tblBlogTitlar);

        getContentPane().add(spBlogtitlar);
        spBlogtitlar.setBounds(772, 212, 210, 360);

        taCalender.setColumns(20);
        taCalender.setRows(5);
        taCalender.setText("Här ska kalendern \nligga");
        spCalender.setViewportView(taCalender);

        getContentPane().add(spCalender);
        spCalender.setBounds(30, 210, 163, 150);

        spForskning.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                spForskningComponentShown(evt);
            }
        });

        taForskning.setColumns(20);
        taForskning.setRows(5);
        spForskning.setViewportView(taForskning);

        tpBloggar.addTab("Forskning", spForskning);

        spUtbildning.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                spUtbildningComponentShown(evt);
            }
        });

        taUtbildning.setColumns(20);
        taUtbildning.setRows(5);
        spUtbildning.setViewportView(taUtbildning);

        tpBloggar.addTab("Utbildning", spUtbildning);

        getContentPane().add(tpBloggar);
        tpBloggar.setBounds(270, 190, 490, 440);

        btnLoggaUt.setText("Logga ut");
        btnLoggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaUtActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoggaUt);
        btnLoggaUt.setBounds(20, 20, 90, 25);

        btn_skapaInlagg.setText("Skapa blogginlägg");
        btn_skapaInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_skapaInlaggActionPerformed(evt);
            }
        });
        getContentPane().add(btn_skapaInlagg);
        btn_skapaInlagg.setBounds(770, 580, 140, 25);

        lblBakgrundVit.setBackground(java.awt.Color.white);
        lblBakgrundVit.setForeground(new java.awt.Color(255, 255, 255));
        lblBakgrundVit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scrumextremep/Namnlös.jpg"))); // NOI18N
        lblBakgrundVit.setText("jLabel1");
        getContentPane().add(lblBakgrundVit);
        lblBakgrundVit.setBounds(0, 0, 1000, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spForskningComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_spForskningComponentShown
        fetchBlognamesForskning();
    }//GEN-LAST:event_spForskningComponentShown

    private void spUtbildningComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_spUtbildningComponentShown
        fetchBlognamesUtbildning();
    }//GEN-LAST:event_spUtbildningComponentShown

    private void tblBlogTitlarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBlogTitlarMouseClicked
        taForskning.removeAll();
        taUtbildning.removeAll();
        int a = tblBlogTitlar.getSelectedRow();
        int b = tblBlogTitlar.getSelectedColumn();
        String tableValue = (String) tblBlogTitlar.getModel().getValueAt(a, b);
        
        String sqlquery = "Select TEXT from BLOGGINLAGG where TITEL = '" + tableValue + "'";
        String titel = new String();
        
        try {
            titel = Databas.getDatabas().fetchSingle(sqlquery);
                       
            taForskning.setText(titel);
            taUtbildning.setText(titel);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tblBlogTitlarMouseClicked

    private void btnLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaUtActionPerformed
        new ForstaSida().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoggaUtActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setExtendedState(InloggadSida.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void btn_skapaInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_skapaInlaggActionPerformed
     
    }//GEN-LAST:event_btn_skapaInlaggActionPerformed

    private void fetchBlognamesUtbildning() {
        String sqlquery = "select BLOGGINLAGG.TITEL from BLOGGINLAGG where b_id = 2";
        ArrayList<HashMap<String, String>> blognames = new ArrayList<>();
        DefaultTableModel dmt = (DefaultTableModel)tblBlogTitlar.getModel();
        dmt.getDataVector().removeAllElements();
        revalidate();
        try {
         blognames = Databas.getDatabas().fetchRows(sqlquery);
         
         for(int i = 0; i < blognames.size(); i++) {
             String names = blognames.get(i).get("TITEL");
                                      
             dmt.addRow(new Object[] {names});
                 }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void fetchBlognamesForskning() {
        String sqlquery = "select BLOGGINLAGG.TITEL from BLOGGINLAGG where b_id = 1";
        ArrayList<HashMap<String, String>> blognames = new ArrayList<>();
        DefaultTableModel dmt = (DefaultTableModel)tblBlogTitlar.getModel();
        dmt.getDataVector().removeAllElements();
        revalidate();
        try {
         blognames = Databas.getDatabas().fetchRows(sqlquery);
         
         for(int i = 0; i < blognames.size(); i++) {
             String names = blognames.get(i).get("TITEL");
             
             dmt.addRow(new Object[] {names});
                 }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String id(String anvID) {
        String dettaID = anvID;
        return dettaID;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoggaUt;
    private javax.swing.JButton btn_skapaInlagg;
    private javax.swing.JLabel lblBakgrundVit;
    private java.awt.Label lblRubrik;
    private javax.swing.JScrollPane spBlogtitlar;
    private javax.swing.JScrollPane spCalender;
    private javax.swing.JScrollPane spForskning;
    private javax.swing.JScrollPane spUtbildning;
    private javax.swing.JTextArea taCalender;
    private javax.swing.JTextArea taForskning;
    private javax.swing.JTextArea taUtbildning;
    private javax.swing.JTable tblBlogTitlar;
    private javax.swing.JTabbedPane tpBloggar;
    // End of variables declaration//GEN-END:variables
}
