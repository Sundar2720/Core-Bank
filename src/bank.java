import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class bank {
    public JPanel panel1;
    public JButton registerButton;
    public JButton loginButton;
    private JButton detailsButton;
    private JButton adminLoginButton;
    private JButton exitButton;

    public bank() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(registerButton);
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
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);
                currentFrame.dispose();
                JFrame frame = new JFrame("bank2");
                frame.setContentPane(new bank2().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(400,400));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);

            }
        });

        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(adminLoginButton);
                currentFrame.dispose();
                JFrame frame = new JFrame("bank7");
                frame.setContentPane(new bank7().Panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(400,400));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("bank");
        frame.setContentPane(new bank().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

}
