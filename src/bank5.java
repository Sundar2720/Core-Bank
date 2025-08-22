import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bank5 {
    public JPanel panel5;
    public JTextField textField2;
    public JTextField textField4;
    public JButton cancelButton;
    public JButton okButton;
    public JComboBox comboBox1;
    private JButton clickToContinueButton;
    public static long tt,rr,ki,ad,zw,wz,vi,z,w;
    public static String y,ax,v;

    public bank5() {


        clickToContinueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection cd = null;
                ax = bank2.username1;
                try {
                    Class.forName("org.postgresql.Driver");
                    cd = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = cd.createStatement();
                    ResultSet rs4 = stmt.executeQuery("select accno from sbank1 where username='" + ax + "'");
                    while (rs4.next()) {
                        ad = rs4.getLong(1);
                    }
                    String ye = Long.toString(ad);
                    if (ye.equals(textField2.getText())) {
                        JOptionPane.showMessageDialog(null, " Continue To Fill the Fields  ");
                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(clickToContinueButton);
                        currentFrame.dispose();
                        JFrame frame = new JFrame("bank14");
                        frame.setContentPane(new bank14().panel1);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setMinimumSize(new Dimension(400,400));
                        frame.setLocationRelativeTo(null);
                        frame.pack();
                        frame.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, " AccNo  was invalid. Please Try Again ");
                    }

                    cd.close();
                } catch (Exception ei) {
                    ei.printStackTrace();
                    System.err.println(ei.getClass().getName() + " : " + ei.getMessage());
                }

            }
        });


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(cancelButton);
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
        JFrame frame = new JFrame("bank5");
        frame.setContentPane(new bank5().panel5);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
