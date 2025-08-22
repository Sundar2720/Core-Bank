import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bank6 {
    public JPanel panel1;
    public JComboBox comboBox1;
    public JButton viewDetailsButton;
    public JTable table1;
    private JButton returnButton;
    private JTextField textField1;
    private JButton ADDButton;
    private JTextField textField2;
    private JTextField textField3;
    private JButton UPDATEButton;
    private JTextField textField4;
    private JButton DELETEButton;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox comboBox2;
    private JButton updateButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("bank6");
        frame.setContentPane(new bank6().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public bank6() {
        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                    String sd=(String.valueOf(comboBox1.getSelectedItem()));
                    ResultSet rs=stmt.executeQuery("select * from sbank2 where accno in(select accno from sbank where branch='"+sd+"' )");
                    DefaultTableModel model= new DefaultTableModel(new String[]{"Account Number","Date","Remarks","Credit","Debit",},0);
                    while (rs.next())
                    {
                        long s=rs.getLong(1);
                        String st=Long.toString(s);
                        String st1=rs.getString(2);
                        String st2=rs.getString(3);
                        long s1= rs.getLong(4);
                        String st4=Long.toString(s1);
                        String st5=rs.getString(5);
                        model.addRow(new Object[]{st,st1,st2,st4,st5});
                    }
                    table1.setModel(model);
                    c.close();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    System.err.println(ex.getClass().getName()+" :"+ex.getMessage());
                }



            }
        });
/*
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aa=textField1.getText();
                String bb=textField2.getText();
                String cc=(String.valueOf(comboBox2.getSelectedItem()));
                String dd=textField4.getText();
                String ee=textField5.getText();
                String ff=textField6.getText();
                String []columns={"Accno","Name","Branch","Email","Phone No","Address"};
                String [][]data={{aa,bb,cc,dd,ee,ff}};
                table1.setModel(new DefaultTableModel(data,columns));
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                    long a=Long.parseLong(aa);
                    long ew=Long.parseLong(ee);
                    stmt.executeQuery("insert into sbank (accno,accname,branch,email,phoneno,address) values("+a+",'"+bb+"','"+cc+"','"+dd+"',"+ew+",'"+ff+"')");
                    c.close();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    System.err.println(ex.getClass().getName()+" :"+ex.getMessage());
                }




            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String al=textField1.getText();
                String cl=(String.valueOf(comboBox1.getSelectedItem()));
                String []columns={"Accno","Name","Branch","Email","Phone No","Address"};
                String [][] data1=new String[1][1];
                table1.setModel(new DefaultTableModel(data1,columns));
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                    long as=Long.parseLong(al);
                    stmt.executeQuery("delete from sbank where accno="+as+" ");
                    c.close();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    System.err.println(ex.getClass().getName()+" :"+ex.getMessage());
                }

            }
        });



        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aq=textField1.getText();
                String bq=textField2.getText();
                String cq=String.valueOf(comboBox2.getSelectedItem());
                String dq=textField4.getText();
                String eq=textField5.getText();
                String fq=textField6.getText();
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kalvi123");
                    Statement stmt = c.createStatement();
                    long aw=Long.parseLong(aq);
                    long ew=Long.parseLong(eq);
                    stmt.executeQuery("update sbank set accname='"+bq+"',branch='"+cq+"',email='"+dq+"',phoneno="+ew+",address='"+fq+"' where accno="+aw+" ");
                    c.close();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    System.err.println(ex.getClass().getName()+" :"+ex.getMessage());
                }






            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model=(DefaultTableModel)table1.getModel();
                int selectedRowIndex=table1.getSelectedRow();
                textField1.setText(model.getValueAt(selectedRowIndex,0).toString());
                textField2.setText(model.getValueAt(selectedRowIndex,1).toString());
                comboBox2.setSelectedItem(model.getValueAt(selectedRowIndex,2).toString());
                textField4.setText(model.getValueAt(selectedRowIndex,3).toString());
                textField5.setText(model.getValueAt(selectedRowIndex,4).toString());
                textField6.setText(model.getValueAt(selectedRowIndex,5).toString());


            }
        });

 */
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(returnButton);
                currentFrame.dispose();
                JFrame frame = new JFrame("bank10");
                frame.setContentPane(new bank10().panel11);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(400,400));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
