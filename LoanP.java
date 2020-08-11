import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

import java.sql.*;
import java.util.Vector;
/*
 * Created by JFormDesigner on Tue Aug 11 15:31:57 EDT 2020
 */



/**
 * @author Khushi Malik
 */
public class LoanP extends JFrame {
    public LoanP() {
        initComponents();
    }

    private void btnaddActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
        // TODO add your code here

        String clientno, clientname,loantype;
        String loanamount;
        String years;

        clientno = txtClientNumber.getText();
        clientname = txtClientName.getText();
        loanamount = txtLoanAmount.getText();
        years = txtNumOfYears.getText();
        loantype = (String) cbTypeOfLoan.getSelectedItem();

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan","root","");

        if(e.getSource() == btnadd){
            insert = connection.prepareStatement("Select * from loantable where clientno = ?");

            insert.setString(1, clientno);
            ResultSet rs = insert.executeQuery();
            if(rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "The clientno you entered already exists ");
                txtClientNumber.setText("");
                txtClientName.setText("");
                txtLoanAmount.setText("");
                txtNumOfYears.setText("");
//                cbTypeOfLoan.setModel("Business");
                txtClientNumber.requestFocus();
                return;
            }
            insert = connection.prepareStatement("insert into loantable values(?,?,?,?,?)");

            insert.setString(1, clientno);
            insert.setString(2, clientname);
            insert.setString(3, loanamount);
            insert.setString(4, years);
            insert.setString(5, loantype);

            insert.executeUpdate();

            JOptionPane.showMessageDialog(null, "Record Updated");

            txtClientNumber.setText("");
            txtClientName.setText("");
            txtLoanAmount.setText("");
            txtNumOfYears.setText("");
//                cbTypeOfLoan.setModel("Business");
            txtClientNumber.requestFocus();
            updateTable();
        }
    }

    private void btneditActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btndeleteActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    //Class variables for connection and creating SQL statements
    Connection connection;
    PreparedStatement insert;

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Khushi Malik
        lblClientNumber = new JLabel();
        txtClientNumber = new JTextField();
        lblClientName = new JLabel();
        txtClientName = new JTextField();
        lblLoanAmount = new JLabel();
        txtLoanAmount = new JTextField();
        lblNumOfYears = new JLabel();
        txtNumOfYears = new JTextField();
        lblTypeOfLoan = new JLabel();
        cbTypeOfLoan = new JComboBox<>();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        btnadd = new JButton();
        btnedit = new JButton();
        btndelete = new JButton();
        lblMonthlyPayment = new JLabel();
        txtMonthlyPayment = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- lblClientNumber ----
        lblClientNumber.setText("Enter the client number: ");
        contentPane.add(lblClientNumber, "cell 0 0");
        contentPane.add(txtClientNumber, "cell 1 0 7 1");

        //---- lblClientName ----
        lblClientName.setText("Enter the client name:");
        contentPane.add(lblClientName, "cell 0 1");
        contentPane.add(txtClientName, "cell 1 1 7 1");

        //---- lblLoanAmount ----
        lblLoanAmount.setText("Enter the customer loan amount: ");
        contentPane.add(lblLoanAmount, "cell 0 2");
        contentPane.add(txtLoanAmount, "cell 1 2 7 1");

        //---- lblNumOfYears ----
        lblNumOfYears.setText("Enter the number of years to pay");
        contentPane.add(lblNumOfYears, "cell 0 3");
        contentPane.add(txtNumOfYears, "cell 1 3 7 1");

        //---- lblTypeOfLoan ----
        lblTypeOfLoan.setText("Enter the loan type: ");
        contentPane.add(lblTypeOfLoan, "cell 0 4");

        //---- cbTypeOfLoan ----
        cbTypeOfLoan.setModel(new DefaultComboBoxModel<>(new String[] {
            "Business",
            "Personal"
        }));
        contentPane.add(cbTypeOfLoan, "cell 1 4 7 1");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, "cell 0 6");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2, "cell 4 6");

        //---- btnadd ----
        btnadd.setText("Add");
        btnadd.addActionListener(e -> {
            try {
                btnaddActionPerformed(e);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        contentPane.add(btnadd, "cell 0 7");

        //---- btnedit ----
        btnedit.setText("Edit");
        btnedit.addActionListener(e -> btneditActionPerformed(e));
        contentPane.add(btnedit, "cell 0 7");

        //---- btndelete ----
        btndelete.setText("Delete");
        btndelete.addActionListener(e -> btndeleteActionPerformed(e));
        contentPane.add(btndelete, "cell 0 7");

        //---- lblMonthlyPayment ----
        lblMonthlyPayment.setText("Monthly Payment");
        contentPane.add(lblMonthlyPayment, "cell 4 7");

        //---- txtMonthlyPayment ----
        txtMonthlyPayment.setEditable(false);
        contentPane.add(txtMonthlyPayment, "cell 4 7");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Khushi Malik
    private JLabel lblClientNumber;
    private JTextField txtClientNumber;
    private JLabel lblClientName;
    private JTextField txtClientName;
    private JLabel lblLoanAmount;
    private JTextField txtLoanAmount;
    private JLabel lblNumOfYears;
    private JTextField txtNumOfYears;
    private JLabel lblTypeOfLoan;
    private JComboBox<String> cbTypeOfLoan;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton btnadd;
    private JButton btnedit;
    private JButton btndelete;
    private JLabel lblMonthlyPayment;
    private JTextField txtMonthlyPayment;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //Initiating intial values for table1 and creating a model for table 2
    public void initialValues() {
        String[] headerRow = {"Number","Name","Amount","Years","Type of Loan"};
        //String[] data = {"1","Khushi","2324","1000","100","32"};
        String[][] data = {{"d1","d1.1","d1.2","d1.3","d1.4"},{"d2","d2.2","d2.2","d2.3","d2.4"}};
        DefaultTableModel model = new DefaultTableModel(data, headerRow);
        table1.setModel(model);
    }

    //To transfer data(if exists) from the database to the table
    public void updateTable() throws ClassNotFoundException, SQLException {
        int colCount;

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan","root","");

        insert = connection.prepareStatement("Select * from loantable");

        ResultSet rs = insert.executeQuery();
        if (!rs.isBeforeFirst() ) {
            JOptionPane.showMessageDialog(null, "Database currently empty");
            return;
        }
        ResultSetMetaData rsmd = rs.getMetaData();

        colCount = rsmd.getColumnCount();
        DefaultTableModel df = (DefaultTableModel) table1.getModel();
        df.setRowCount(0);

        while(rs.next()) {
            Vector v1 = new Vector();
            for (int i=1; i<=colCount; i++) {
                v1.add(rs.getString("clientno"));
                v1.add(rs.getString("clientname"));
                v1.add(rs.getDouble("loanamount"));
                v1.add(rs.getInt("years"));
                v1.add(rs.getString("loantype"));
            }
            df.addRow(v1);
        }

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        LoanP obj1 = new LoanP();

        obj1.initialValues();

        obj1.updateTable();

        obj1.setVisible(true);
    }
}
