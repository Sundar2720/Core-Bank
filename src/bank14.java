import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class bank14 {
    public JPanel panel1;
    public JTextField textField1;
    public JComboBox comboBox1;
    public JTextField textField2;
    public JButton proceedButton;
    public JButton cancelButton;
    public static long z,w,t,r;
    public static String y;
    public static int k;

    public bank14() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String x = today.format(formatter);

        textField1.setText(x);
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                y = comboBox1.getSelectedItem().toString();

                long vi = bank5.ad;
                int flag=0;

                Connection c = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "sundar2720");
                    Statement stmt = c.createStatement();
                    if (comboBox1.getSelectedItem().equals("credit")) {
                        String mwzx = textField2.getText();
                        z = Long.parseLong(mwzx);
                        w = 0;
                    }
                    else
                    {
                        String smi = textField2.getText();
                        w = Long.parseLong(smi);
                        long balance = 0;
                        ResultSet red = stmt.executeQuery("SELECT balance FROM \"" + vi + "\"ORDER BY id DESC LIMIT 1");
                        while (red.next()) {
                            balance = red.getLong(1);
                        }
                        if ((balance - w) < 0) {
                            flag=1;

                        }

                        z = 0;
                    }
                    if (flag == 1) {
                        JOptionPane.showMessageDialog(null, " Your balance is Insufficient ");
                    }
                    else {
                        String aa = ("insert into \"" + vi + "\"(date,remarks,credit,debit)values('" + x + "','" + y + "'," + z + "," + w + ")");

                        String bz = ("insert into sbank2(accno,date,remarks,credit,debit)values(" + vi + ",'" + x + "','" + y + "'," + z + "," + w + ")");
                        stmt.addBatch(aa);
                        stmt.addBatch(bz);
                        stmt.executeBatch();
                        ResultSet rs1 = stmt.executeQuery("select sum(credit) from \"" + vi + "\" ");
                        while (rs1.next()) {
                            t = rs1.getLong(1);
                        }
                        ResultSet rs23 = stmt.executeQuery("select sum(debit) from \"" + vi + "\" ");
                        while (rs23.next()) {
                            r = rs23.getLong(1);
                        }
                        ResultSet rs3 = stmt.executeQuery("SELECT * FROM \"" + vi + "\"ORDER BY id DESC LIMIT 1");
                        while (rs3.next()) {
                            k = rs3.getInt(1);
                        }
                        Long ww = t - r;
                        String bb = ("update \"" + vi + "\" set balance=" + ww + " where ID=" + k + " ");

                        stmt.addBatch(bb);
                        stmt.executeBatch();
                        JOptionPane.showMessageDialog(null, " Transactions SuccessFully.... ");
                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(proceedButton);
                        currentFrame.dispose();
                        JFrame frame = new JFrame("bank8");
                        frame.setContentPane(new bank8().Panel1);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setMinimumSize(new Dimension(400,400));
                        frame.setLocationRelativeTo(null);
                        frame.pack();
                        frame.setVisible(true);


                        c.close();
                    }
                    }
                catch(Exception ei){
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
        JFrame frame = new JFrame("bank14");
        frame.setContentPane(new bank14().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
