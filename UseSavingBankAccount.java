
/**
 *
 * @author feebisharma1
 */
// Assignment 2 - G18
// Ivan Sanchez - R11542896
// Feebi Sharma - R11564981
// Haroon Saeed - R11548066
//
// We (G18) were assigned the parts 5, 6, 7, and 7b which were completed following the completion of the base question
// which assigned us to create three different classes and incorporate GUI components to write a program that would
// allow a user to perform certain actions on bank accounts. We were meant to utilize four radio buttons, three text
// fields and one push button GUI components. We were meant to create the GUI and implement methods that would allow the
// user to do multiple things including: search for a balance by entering the name of the customer(5), adding interest
// to a customer's account by entering their name(6), displaying all of the customer's info by entering their name(7),
// and allowing the user to exit by choice(7b). All of the assigned GUI components were used to achieve this.
/*Question::
Provide four radio Buttons (title same as operations in the question), three labels(Name, Name, and AccountType), three text fields (to input ‘max’ or ‘min’, to input Amount, and to input AccType) and a “submit” push Button for the following four operations
 (5) Provide a method searchBalancebyName(….) of an account holder and display the result by JOptionPane. Note initially the “text box to input Name” is disabled. But if we select this radio button then the “text box” is enabled. searchBalanceByName(SavingAccount[]   ……, String   name)
(6) Add interest to the account holder’s balance by Name. addInterest method should call deposit(…).Note initially the “text boxes for inputting Name”and rate are disabled. But if we select this radio button then the “text boxes” are enabled. Provide a method:addInterestByName(SavingAccount[ ], String name, double rate)
(7) Display all information about account holders by accountType using JOptionPane. Provide a method: displayAllByAccountType(SavingAccount[ ], accountType); 
(7b) Exit
(Note initially the “text boxes for inputting Name, Name and interest rate , and accountType” are disabled. But if we select this radio button then the “text boxes” are enabled.). */

import javax.swing.*;

class Account {
    private String strName;
    private int id;
    private char accountType;
    private double balance;

    Account(){
        strName = " ";
        id = 0;
        accountType = ' ';
        balance = 0.0;
    }

    Account (String strName, int id, char accountType, double balance) {
        this.strName = strName;
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
    }

    String getstrName() {
        return strName;
    }

    void setstrName( String name) {
        this.strName = name;
    }

    int getid() {
        return id;
    }

    void setid(int ID) {
        this.id = ID;
    }

    char getaccountType() {
        return accountType;
    }

    void setaccountType(char type) {
        this.accountType = type;
    }

    double getbalance() {
        return this.balance;
    }

    void setbalance(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) {
        if (getbalance() >= amount) {
            setbalance(getbalance() - amount);
        }
    }

    void deposit(double amount) {
        setbalance(this.balance + amount);
    }

    void displayBalance() {
        System.out.println("Your Balance is: " +getbalance());

    }

    void displayAll() {
        System.out.println(" Name: " + getstrName());
        System.out.println("Id: " +getid());
        System.out.println("Account Type: " +getaccountType());
        System.out.println("Total Balnce: " +getbalance());
    }
}

class SavingAccount extends Account {
    private double rate;

    SavingAccount(){
        super();
        rate = 0.0;
    }

    SavingAccount(String strName, int id, char accountType, double balance, double rate) {
        super(strName, id, accountType, balance);
        this.rate = rate;
    }

    public void addInterst() {
        double interestAmount = (rate/12) * getbalance();
        deposit(interestAmount);
    }

    public void deductLoan(SavingAccount[] loan, char accountType, double amount) {
        double loanDeducted = getbalance() - amount;
    }

}


public class UseSavingBankAccount extends javax.swing.JFrame {
    boolean bRb1 = false;
    boolean bRb2 = false;
    boolean bRb3 = false;
    boolean bRb4 = false;
    
    private double placeHolder;
    private double balance;

    SavingAccount[] objAcc = new SavingAccount[50];
    /**
     * Creates new form UseSavingBankAccount
     */
    public UseSavingBankAccount() {
        int id = 100;
        char atype = 'C';
        for (int i = 0; i < 50; i++) {
            objAcc[i] = new SavingAccount("TTU" + i, id + i, atype , (1000*i), 0.03);
            if (i > 20){
                atype = 'S';
            }
            System.out.println(objAcc[i].getstrName() + " " + objAcc[i].getaccountType() + " " + objAcc[i].getbalance());
        }
        
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(Rb1);
        group.add(Rb2);
        group.add(Rb3);
        group.add(Rb4);

        Tf1.setEnabled(false);
        Tf2.setEnabled(false);
        Tf3.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Rb1 = new javax.swing.JRadioButton();
        Rb2 = new javax.swing.JRadioButton();
        Rb3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Rb4 = new javax.swing.JRadioButton();
        Tf1 = new javax.swing.JTextField();
        Tf2 = new javax.swing.JTextField();
        Tf3 = new javax.swing.JTextField();
        Submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Rb1.setText("Search Balance By Name");
        Rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb1ActionPerformed(evt);
            }
        });

        Rb2.setText("Add Interest To Account Holder BY Name");
        Rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb2ActionPerformed(evt);
            }
        });

        Rb3.setText("Display All Using Account Type");
        Rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Name");

        jLabel2.setText("Enter Name");

        jLabel3.setText("Enter A/C Type");

        Rb4.setText("Exit");
        Rb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb4ActionPerformed(evt);
            }
        });

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(Rb4))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Rb3)
                                .addGap(72, 72, 72)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tf3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Submit)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Rb1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Rb2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tf1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tf2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rb1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rb2)
                    .addComponent(jLabel2)
                    .addComponent(Tf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rb3)
                    .addComponent(jLabel3)
                    .addComponent(Tf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rb4)
                    .addComponent(Submit))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb1ActionPerformed
        // TODO add your handling code here:
        bRb1 = true;
        bRb2 = false;
        bRb3 = false;
        bRb4 = false;
        Tf1.setEnabled(true);
        Tf2.setEnabled(false);
        Tf3.setEnabled(false);
    }//GEN-LAST:event_Rb1ActionPerformed

    private void Rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb2ActionPerformed
        // TODO add your handling code here:
        bRb1 = false;
        bRb2 = true;
        bRb3 = false;
        bRb4 = false;

        Tf1.setEnabled(false);
        Tf2.setEnabled(true);
        Tf3.setEnabled(false);

    }//GEN-LAST:event_Rb2ActionPerformed

    private void Rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb3ActionPerformed
        // TODO add your handling code here:
        bRb1 = false;
        bRb2 = false;
        bRb3 = true;

        Tf1.setEnabled(false);
        Tf2.setEnabled(false);
        Tf3.setEnabled(true);
    }//GEN-LAST:event_Rb3ActionPerformed

    private void Rb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb4ActionPerformed
        // TODO add your handling code here:
        bRb1 = false;
        bRb2 = false;
        bRb3 = false;
        bRb4 = true;

        Tf1.setEnabled(false);
        Tf2.setEnabled(false);
        Tf3.setEnabled(false);
    }//GEN-LAST:event_Rb4ActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
         String textfield1 = Tf1.getText();
        String textfield2 = Tf2.getText();
        String textfield3 = Tf3.getText();

        // System.out.println(textfield);
        if (bRb1){
            searchBalanceByName(objAcc,textfield1);
        }
        else if (bRb2){
            addInterestByName(objAcc, textfield2, 0.03);
        }
        else if (bRb3){
            char textfield = textfield3.charAt(0);
            displayAllByAccountType(objAcc, textfield);
        }
        else
            System.exit(0);
    }//GEN-LAST:event_SubmitActionPerformed
    void searchBalanceByName(SavingAccount[] account, String name) {
        for( int i = 0; i < 50; i++) {
            if (name.equals("TTU" + i)){
                //placeHolder = account[i].getbalance() + balance;
                JOptionPane.showMessageDialog(null,"<html>" + "Name: " +  account[i].getstrName() + "<br>" +"Type: " + account[i].getaccountType() + "<br> " +"Balance: " + account[i].getbalance());
                break;
            }
        }
    }

    void addInterestByName(SavingAccount[] account, String name, double rate) {
        for(int i = 0; i < 50; i++){
            if ( name.equals(("TTU" + i))){
                balance = account[i].getbalance() * rate;
                account[i].deposit(balance);
                JOptionPane.showMessageDialog(null,"<html>" + "Name: " +  account[i].getstrName() + "<br>" +"Type: " + account[i].getaccountType() + "<br> " +"Balance: " + account[i].getbalance());
                break;
            }
        }
    }

    void displayAllByAccountType(SavingAccount[] account, char Type) {
        String finaloutput = " ";
        for(int i = 0; i < 50; i++) {
            if (account[i].getaccountType() == Type) {
                finaloutput += ( "Name: " +  account[i].getstrName() + "  " +"Type: " + account[i].getaccountType() + "   " +"Balance: " + account[i].getbalance() + "\n");
                //JOptionPane.showMessageDialog(null,"<html>" + "Name: " +  account[i].getstrName() + "<br>" +"Type: " + account[i].getaccountType() + "<br> " +"Balance: " + account[i].getbalance());
            }
        }
        JOptionPane.showMessageDialog(null,finaloutput);
    }
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
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UseSavingBankAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UseSavingBankAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Rb1;
    private javax.swing.JRadioButton Rb2;
    private javax.swing.JRadioButton Rb3;
    private javax.swing.JRadioButton Rb4;
    private javax.swing.JButton Submit;
    private javax.swing.JTextField Tf1;
    private javax.swing.JTextField Tf2;
    private javax.swing.JTextField Tf3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
