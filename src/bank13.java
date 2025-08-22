import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bank13 {
    public JPanel Panel1;
    public JButton creditAnalyticButton;
    public JButton debitAnalyticButton;
    private JButton backToPageButton;

    public bank13() {
        creditAnalyticButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(creditAnalyticButton);
                currentFrame.dispose();
                JFrame frame = new JFrame("bank15");
                frame.setContentPane(new bank15().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setResizable(true);
                frame.setVisible(true);

            }
        });
        debitAnalyticButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(debitAnalyticButton);
                currentFrame.dispose();
                JFrame frame = new JFrame("bank16");
                frame.setContentPane(new bank16().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(400,400));
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
        backToPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(backToPageButton);
                currentFrame.dispose();
                JFrame frame = new JFrame("bank10");
                frame.setContentPane(new bank10().panel11);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(400,400));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("bank13");
        frame.setContentPane(new bank13().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
