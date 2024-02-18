/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_management_system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
//import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumn;
//mport javax.swing.table.TableColumnModel;
//import javax.swing.table.TableRowSorter;


/**
 *
 * @author hp
 */
public class EditStudent extends javax.swing.JFrame {

    
    
    /**
     * Creates new form ViewStudent
     */
    DefaultTableModel model=null;
    public EditStudent() {
        initComponents();
        setRecordsToTable();
    }
    public void setRecordsToTable()
    {
        
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/add_student", "TCET","2001");
        String sql="select * from addstudent";
        PreparedStatement pstmt= con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();            
                while(rs.next())
                {
                            String name=rs.getString("name");
                            String email=rs.getString("email");    
                            String course=rs.getString("course");
                            //String fee = jTextField4.getText();
                            

                            //String contactno=rs.getString("contactno");
                            Object[] obj ={name,email,course};
                            //jTextField4.setText("");
                            model = (DefaultTableModel)jTable1.getModel();
                            model.addRow(obj);
                }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    public void clearTable()
    {
        DefaultTableModel m=(DefaultTableModel)jTable1.getModel();
        m.setRowCount(0);
    }
    public void update(String name,String email,String course)
    {
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/add_student", "TCET","2001");
                PreparedStatement pst= con.prepareStatement("update addstudent set email=?,course=? where name=?");
                
                
                pst.setString(1,email);
                pst.setString(2,course);
                pst.setString(3,name);
                int rowCount=pst.executeUpdate();
                if(rowCount==1)
                {
                    JOptionPane.showMessageDialog(this, "records updation successfully");
                    clearTable();
                    setRecordsToTable();
                }
                else{
                    JOptionPane.showMessageDialog(this, "records updation failed");
                }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "records updation failed");
            e.printStackTrace();
        }
    }
    public void delete(String name)
    {
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/add_student", "TCET","2001");
                // Delete from addstudent table
        String deleteAddStudentQuery = "DELETE FROM addstudent WHERE name=?";
        PreparedStatement deleteAddStudentStatement = con.prepareStatement(deleteAddStudentQuery);
        deleteAddStudentStatement.setString(1, name);
        int addStudentRowCount = deleteAddStudentStatement.executeUpdate();
        
        // Delete from feedetails table
        String deleteFeeDetailsQuery = "DELETE FROM feedetails WHERE name=?";
        PreparedStatement deleteFeeDetailsStatement = con.prepareStatement(deleteFeeDetailsQuery);
        deleteFeeDetailsStatement.setString(1, name);
        int feeDetailsRowCount = deleteFeeDetailsStatement.executeUpdate();

        if (addStudentRowCount == 1 || feeDetailsRowCount == 1) {
            JOptionPane.showMessageDialog(this, "Records deleted successfully");
            clearTable();
            setRecordsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Records deletion failed");
        }
        
        // Close the statements and connection
        deleteAddStudentStatement.close();
        deleteFeeDetailsStatement.close();
        con.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Records deletion failed");
        e.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/exit.png"))); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 144, 71));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 137, 71));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "email", "course"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 400, 350));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 180, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("STUDENT NAME");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 137, 71));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Email");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 70, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 180, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Course");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, -1));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 180, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 950, 570));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("COMPUTER INSTITUTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
    }//GEN-LAST:event_formComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        home home=new home();
        home.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String name=jTextField1.getText();
        String email=jTextField2.getText();
        String course=jTextField3.getText();
        
       update(name,email,course);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
   // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
String name=jTextField1.getText();
delete(name);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
int rowno=jTable1.getSelectedRow();
TableModel md=jTable1.getModel();
jTextField1.setText((String) md.getValueAt(rowno,0));
jTextField2.setText((String) md.getValueAt(rowno,1));
jTextField3.setText((String) md.getValueAt(rowno,2));
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
