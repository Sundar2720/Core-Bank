import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bank4 {
    public JPanel panel1;
    public JTextField textField1;
    public JButton okButton;
    public static String x;


    public bank4() {
        textField1.setText(String.valueOf(bank1.ac));

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                     x = bank1.ac;
                     long xi=Long.parseLong(x);
                    String y = bank1.a;
                    String z = bank1.ed;
                    String w = bank1.b;
                    String v = bank1.c;
                    long vi=Long.parseLong(v);
                    String u = bank1.d;
                    String i = bank3.us;
                    String j = bank3.bb;
                    String ii = "insert into sbank values(" + xi + ",'" + y + "','" + z + "','" + w + "'," + vi + ",'" + u + "')";
                    String kk="insert into sbank1(accno,username,password)values("+xi+",'" +i+ "','" + j + "')";
                    String jj = "create table \"" + textField1.getText() + "\" ( ID  SERIAL PRIMARY KEY,date varchar,remarks varchar,credit bigint,debit bigint,balance bigint)";
                    stmt.addBatch(ii);
                    stmt.addBatch(kk);
                    stmt.addBatch(jj);
                    stmt.executeBatch();
                    c.close();
                } catch (Exception ei) {
                    ei.printStackTrace();
                    System.err.println(ei.getClass().getName() + " : " + ei.getMessage());
                }
                JOptionPane.showMessageDialog(null, " Your Account was Successfully Created");

                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(okButton);

                // Close current frame
                currentFrame.dispose();

                JFrame frame = new JFrame("bank");
                frame.setContentPane(new bank().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(400,400));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("bank4");
        frame.setContentPane(new bank4().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}

