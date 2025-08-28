import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static javax.swing.JOptionPane.showMessageDialog;

public class bank3 {
    public JPanel panel1;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JButton okButton;
    public JButton cancelButton;
    public static String aa,bb,cc,us;

    public bank3() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aa= textField1.getText();
                bb=textField2.getText();
                cc=textField3.getText();
                if(aa == null || aa.isEmpty() || aa.isBlank())
                {
                    JOptionPane.showMessageDialog(null, " Enter a User Name ");
                }
                else if (bb == null || bb.isEmpty() || bb.isBlank())
                {
                    JOptionPane.showMessageDialog(null, "Password is Empty");
                }
                else {
                    if (cc.equals(bb)) {
                        Connection c=null;
                        us="";
                        int flag=0;
                        try {

                            Class.forName("org.postgresql.Driver");
                            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                            Statement stmt = c.createStatement();
                            ResultSet rs=stmt.executeQuery("select username from sbank1 where username="+aa+"");
                            while(rs.next())
                            {
                                us=rs.getString(1);
                            }
                            if(us==null)
                            {
                                flag=1;
                            }
                            c.close();
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                            System.err.println(exception.getClass().getName() + " :" + exception.getMessage());
                        }

                        if(flag==1)
                        {
                            JOptionPane.showMessageDialog(null, " UserName Already Exists");
                        }
                        else {
                            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(okButton);
                            currentFrame.dispose();
                            JFrame frame = new JFrame("bank4");
                            frame.setContentPane(new bank4().panel1);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setMinimumSize(new Dimension(400, 400));
                            frame.setLocationRelativeTo(null);
                            frame.pack();
                            frame.setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, " Password is invalid ");
                    }
                }
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        JFrame frame = new JFrame("bank3");
        frame.setContentPane(new bank3().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
