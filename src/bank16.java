import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bank16 {

    public JPanel panel1;
    public JTextField textField1;
    public JButton detailsButton;
    public JTable table1;
    public JTextField textField2;
    private JTable table2;
    private JButton backButton;
    public static String aam,aas,cm,bbm;

    DefaultTableModel model = new DefaultTableModel(new String[]{"Accno", "Date", "Remarks", "Debit"}, 0);
    DefaultTableModel model1 = new DefaultTableModel(new String[]{"Accno",  "Remarks", "Debit"}, 0);

    public bank16() {
        detailsButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String Ax=textField1.getText();
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                    int row=0;
                    model.setRowCount(0);
                    model1.setRowCount(0);
                    ResultSet rs=stmt.executeQuery("select * from sbank2 where date='"+Ax+"' and remarks='debit' ");
                    while(rs.next()) {
                        long bx = rs.getLong(1);
                        String bb = Long.toString(bx);
                        String cx = rs.getString(2);
                        String dx = rs.getString(3);
                        long ex = rs.getLong(4);
                        String ee = Long.toString(ex);
                        long fx = rs.getLong(5);
                        String ff = Long.toString(fx);

                        model.addRow(new Object[]{bb, cx, dx, ff});
                    }
                    table1.setModel(model);
                    ResultSet rs1 = stmt.executeQuery("select sum(debit) from sbank2 where date='"+Ax+"' ");
                    while (rs1.next()) {
                        long t = rs1.getLong(1);
                        String tt=Long.toString(t);
                        textField2.setText(tt);
                    }
                    int row1=0;
                    ResultSet rs5=stmt.executeQuery("select accno,date='"+Ax+"',remarks, sum(credit),sum(debit) from sbank2 group by date,accno,remarks order by sum(debit) desc");
                    while (rs5.next()) {
                        long am = rs5.getLong(1);
                        aam = Long.toString(am);
                        boolean as = rs5.getBoolean(2);
                        aas = Boolean.toString(as);
                        cm = rs5.getString(3);
                        int bm = rs5.getInt(5);
                        bbm = Integer.toString(bm);

                        if (aas.equals("true")) {
                            if (cm.equals("debit")) {

                                model1.addRow(new Object[]{aam, cm, bbm});
                            }
                        } else {
                            String[] columns = {"Accno", "Remarks", "Debit"};
                            String[][] data1 = new String[1][1];
                            table2.setModel(new DefaultTableModel(data1, columns));

                        }
                        table2.setModel(model1);
                    }
                    c.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getClass().getName() + " :" + ex.getMessage());
                }
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
                frame.setMinimumSize(new Dimension(300,300));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("bank16");
        frame.setContentPane(new bank16().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(200,200));
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);

    }

}
