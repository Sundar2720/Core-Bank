import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bank2 {
    public JPanel panel1;
    public JTextField textField1;
    public JTextField textField2;
    public JButton OKButton;
    private JButton cancelButton;
    private JPasswordField passwordField1;
    private JButton clickButton;
    public static String ei,fi,bc,sc,username1,password1;

    public bank2() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

             username1=textField1.getText();
             password1=passwordField1.getText();
                Connection c=null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                    ResultSet rs3 = stmt.executeQuery("select * from sbank1 where username='" + username1 + "' and  password='" + password1 + "' ");
                    while (rs3.next()) {

                        bc = rs3.getString(2);
                        sc = rs3.getString(3);
                    }


                    if(bc==null&&sc==null)
                    {
                        JOptionPane.showMessageDialog(null, " Username and Password Invalid");
                    }

                    else if ((bc.equals(username1))&&(sc.equals(password1)) ) {
                        JOptionPane.showMessageDialog(null, " Login SuccessFully");
                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(OKButton);
                        currentFrame.dispose();
                        JFrame frame = new JFrame("bank8");
                        frame.setContentPane(new bank8().Panel1);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setMinimumSize(new Dimension(400,400));
                        frame.setLocationRelativeTo(null);
                        frame.pack();
                        frame.setVisible(true);
                    }


                        c.close();

                }catch (Exception ei)
                    {
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
                JFrame frame = new JFrame("bank");
                frame.setContentPane(new bank().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(400,400));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(clickButton);
                currentFrame.dispose();
                JFrame frame1 = new JFrame("bank1");
                frame1.setContentPane(new bank1().panel2);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setMinimumSize(new Dimension(400,400));
                frame1.setLocationRelativeTo(null);
                frame1.pack();
                frame1.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("bank2");
        frame.setContentPane(new bank2().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
