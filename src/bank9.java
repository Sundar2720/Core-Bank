import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bank9 {
    public JPanel Panel1;
    public JTextField textField1;
    public JButton viewButton;
    public JTable table1;
    private JButton backButton;

    public static String aj,aa;
    public static long ad;

    public bank9() {
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aj = bank2.username1;
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                    String a = textField1.getText();
                    ResultSet rs4 = stmt.executeQuery("select accno from sbank1 where username='" + aj + "'");
                    while (rs4.next()) {
                        ad = rs4.getLong(1);
                    }
                    String ye = Long.toString(ad);
                    DefaultTableModel model = new DefaultTableModel(new String[]{"Date", "Remarks", "Credit", "Debit", "Balance"}, 0);
                    if (ye.equals(textField1.getText())) {
                        ResultSet rs5 = stmt.executeQuery("select * from \"" + a + "\" ");
                        while (rs5.next()) {
                            aa = rs5.getString(2);
                            String bb = rs5.getString(3);
                            long c1 = rs5.getLong(4);
                            String cc = Long.toString(c1);
                            long d1 = rs5.getLong(5);
                            String dd = Long.toString(d1);
                            long e1 = rs5.getLong(6);
                            String ee = Long.toString(e1);
                            model.addRow(new Object[]{aa, bb, cc, dd, ee});
                        }
                        table1.setModel(model);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, " AccNo  was invalid. Please Try Again ");
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
                JFrame frame = new JFrame("bank8");
                frame.setContentPane(new bank8().Panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(400,400));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("bank9");
        frame.setContentPane(new bank9().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}

