import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class bank1 {
    public static String ac,a,b,c,d,ed;
    public JPanel panel2;
    public JTextField textField1;
    public JTextField textField4;
    public JTextField textField5;
    public JButton OKButton;
    public JComboBox comboBox1;
    public JTextField textField2;
    private JButton backButton;
    private JButton homeButton;
    public static long bc,sc;
    public static int ad;

    public bank1() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                a=textField1.getText();
                b=textField4.getText();
                c=textField5.getText();
                d=textField2.getText();

                if (a == null || (a.isEmpty() || a.isBlank()))
                {
                    JOptionPane.showMessageDialog(null," Enter a Name ");
                }
                else if(b == null || (b.isEmpty() || b.isBlank()))
                {
                    JOptionPane.showMessageDialog(null," Enter a Email ");
                }

                else if(c == null || c.isEmpty() || c.isBlank())
                {
                    JOptionPane.showMessageDialog(null," Enter a Phone No ");
                }

                else if(d == null || (d.isEmpty() || d.isBlank()))
                {
                    JOptionPane.showMessageDialog(null," Enter a Address ");
                }

                else {
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(OKButton);
                    currentFrame.dispose();
                    JFrame frame = new JFrame("bank3");
                    frame.setContentPane(new bank3().panel1);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setMinimumSize(new Dimension(400,400));
                    frame.setLocationRelativeTo(null);
                    frame.pack();
                    frame.setVisible(true);
                }


            }
        });



        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ed=(String.valueOf(comboBox1.getSelectedItem()));
            Connection c = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                Statement stmt = c.createStatement();
                ResultSet rs2 = stmt.executeQuery("select * from bank1 where branchname='" + ed + "'");
                while(rs2.next()) {

                    bc = rs2.getLong(1);
                     sc = rs2.getLong(2);
                }
                ResultSet rs3=stmt.executeQuery("select count(accno)from sbank");
                while(rs3.next()) {
                   ad=rs3.getInt(1);
                   ad++;

                }

                ac = Long.toString(bc) + Long.toString(sc) + ad;


            c.close();
        }

                catch(Exception ea)
            {
                ea.printStackTrace();
                System.err.println(ea.getClass().getName()+" :"+ea.getMessage());
            }


        }
        });

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
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
        JFrame frame1 = new JFrame("bank1");
        frame1.setContentPane(new bank1().panel2);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setMinimumSize(new Dimension(400,400));
        frame1.setLocationRelativeTo(null);
        frame1.pack();
        frame1.setVisible(true);
    }
}
