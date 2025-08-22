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

public class bank12 {
    public JPanel panel1;
    public JTextField textField1;
    public JButton viewButton;
    public JTable table1;
    public JTextField textField2;
    public JComboBox comboBox1;
    public JTextField textField3;
    public JTextField textField4;
    public JTextField textField5;
    public JButton updateButton;
    public JButton deleteAccountButton;
    private JButton backButton;

    public bank12() {
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ag = textField1.getText();
                long as=Long.parseLong(ag);
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                    String[][] data = new String[10][3];
                    int row = 0;
                    String l1="";
                    ResultSet resultset=stmt.executeQuery("select accno from sbank where accno="+as+"");
                    while (resultset.next())
                    {
                        long l=resultset.getLong(1);
                        l1=Long.toString(l);
                    }
                    if(l1.isEmpty()||l1==null)
                    {
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField5.setText("");
                        JOptionPane.showMessageDialog(null, " Account Number was Wrong");

                    }


                    ResultSet rs = stmt.executeQuery("select * from sbank where accno=" + as + " ");
                    DefaultTableModel model = new DefaultTableModel(new String[]{"Accno", "Name", "Branch", "Email", "Phone No", "Address"}, 0);
                    while (rs.next()) {
                        long s = rs.getLong(1);
                        String st = Long.toString(s);
                        String st1 = rs.getString(2);
                        String st2 = rs.getString(3);
                        String st3 = rs.getString(4);
                        long s1 = rs.getLong(5);
                        String st4 = Long.toString(s1);
                        String st5 = rs.getString(6);
                        model.addRow(new Object[]{st, st1, st2, st3, st4, st5});
                    }
                    table1.setModel(model);
                    c.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getClass().getName() + " :" + ex.getMessage());
                }
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model=(DefaultTableModel)table1.getModel();
                int selectedRowIndex=table1.getSelectedRow();

                textField2.setText(model.getValueAt(selectedRowIndex,1).toString());
                comboBox1.setSelectedItem(model.getValueAt(selectedRowIndex,2).toString());
                textField3.setText(model.getValueAt(selectedRowIndex,3).toString());
                textField4.setText(model.getValueAt(selectedRowIndex,4).toString());
                textField5.setText(model.getValueAt(selectedRowIndex,5).toString());

            }
        });
        deleteAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String al=textField1.getText();

                String []columns={"Accno","Name","Branch","Email","Phone No","Address"};
                String [][] data1=new String[1][1];
                table1.setModel(new DefaultTableModel(data1,columns));
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                    long as=Long.parseLong(al);
                    stmt.executeUpdate("delete from sbank1 where accno="+as+" ");
                    stmt.executeUpdate("delete from sbank where accno="+as+" ");
                    stmt.executeUpdate("delete from sbank2 where accno="+as+" ");
                    stmt.executeUpdate("drop table \"" + as+ "\" ");
                    c.close();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    System.err.println(ex.getClass().getName()+" :"+ex.getMessage());
                }
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");

                JOptionPane.showMessageDialog(null, " Your Account was deleted");


            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aq=textField1.getText();
                String bq=textField2.getText();
                String cq=String.valueOf(comboBox1.getSelectedItem());
                String dq=textField3.getText();
                String eq=textField4.getText();
                String fq=textField5.getText();
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
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
                JOptionPane.showMessageDialog(null, " Your Account was updated");


            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("bank12");
        frame.setContentPane(new bank12().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300,300));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
