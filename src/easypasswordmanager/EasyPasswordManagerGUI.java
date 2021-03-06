/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypasswordmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Fintan
 */
public class EasyPasswordManagerGUI extends javax.swing.JFrame {

    /**
     * Creates new form EasyPasswordManagerGUI
     */
    public EasyPasswordManagerGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLbl = new javax.swing.JLabel();
        blrbLbl = new javax.swing.JLabel();
        passwordTFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        passwordBtn = new javax.swing.JButton();
        showPsswrdBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLbl.setText("EasyPasswordManager");

        blrbLbl.setText("The solution to your password problems");

        jLabel1.setText("Enter a password:");

        passwordBtn.setText("Submit the password");
        passwordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordBtnActionPerformed(evt);
            }
        });

        showPsswrdBtn.setText("Show Passwords");
        showPsswrdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPsswrdBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(passwordTFld, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(TitleLbl))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(blrbLbl))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(passwordBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(showPsswrdBtn)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(TitleLbl)
                .addGap(18, 18, 18)
                .addComponent(blrbLbl)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(passwordBtn)
                .addGap(30, 30, 30)
                .addComponent(showPsswrdBtn)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordBtnActionPerformed
        // TODO add your handling code here:
        File outFile;
        FileWriter fw;
        BufferedWriter bw;
        try{
            String password = passwordTFld.getText();
            
            outFile = new File("passwordfile.txt");
            
            fw = new FileWriter(outFile, true);
            bw = new BufferedWriter(fw);
            
            bw.write(password);
            
            bw.newLine();

            bw.close();
                    JOptionPane.showMessageDialog(null,"The password has been submitted.");

        }
        catch(IOException e){
            System.out.print("Error writing to file: " + e);
        }
    }//GEN-LAST:event_passwordBtnActionPerformed

    private void showPsswrdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPsswrdBtnActionPerformed
        // TODO add your handling code here:
        String password;
        File inFile;
        FileReader fr;
        BufferedReader br;
        
        try{
            inFile = new File("passwordfile.txt");
            //select file then put it in the file reader
            fr = new FileReader(inFile);
            //Keep data going into the file reader
            br = new  BufferedReader (fr);
            
            //Then start reading the file
            
            //instantiate the data as the variable in the file
            password = br.readLine();
                //use a while loop to read every word in the file
                while(password != null){           
           
                    JOptionPane.showMessageDialog(null,"Password: " + password);
                        password = br.readLine();
                }
                //then close the data stream.
                br.close();
        }
        catch(IOException e){
            System.out.println("Error reading the file: " + e);
        }
    }//GEN-LAST:event_showPsswrdBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EasyPasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EasyPasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EasyPasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EasyPasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EasyPasswordManagerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleLbl;
    private javax.swing.JLabel blrbLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton passwordBtn;
    private javax.swing.JTextField passwordTFld;
    private javax.swing.JButton showPsswrdBtn;
    // End of variables declaration//GEN-END:variables
}
