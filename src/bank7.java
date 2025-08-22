import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bank7 {
    public JPanel Panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton cancelButton;
    public static String aa,bb;

    public bank7() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                    String a= textField1.getText();
                    String b=passwordField1.getText();
                    ResultSet rs=stmt.executeQuery("select * from admin where username='"+a+"' and password='"+b+"'");
                    while(rs.next())
                    {
                         aa=rs.getString(1);
                         bb=rs.getString(2);
                    }
                    if(aa==null)
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Username and password");
                    }
                    else
                    {
                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);
                        currentFrame.dispose();
                        JFrame frame = new JFrame("bank10");
                        frame.setContentPane(new bank10().panel11);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setMinimumSize(new Dimension(400,400));
                        frame.setLocationRelativeTo(null);
                        frame.pack();
                        frame.setVisible(true);
                    }
                    c.close();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    System.err.println(ex.getClass().getName()+" :"+ex.getMessage());
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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("bank7");
        frame.setContentPane(new bank7().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
