import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    MyFrame() {
        this.setVisible(true);
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        JPanel commandPanel = new JPanel();
        commandPanel.setBounds(0, 0, 283, 700);
        commandPanel.setBackground(new Color(77, 218, 227));

        JPanel titlesPanel = new JPanel();
        titlesPanel.setBounds(283, 0, 717, 100);
        titlesPanel.setBackground(new Color(47, 155, 255));

        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(283, 100, 717, 600);
        contentPanel.setBackground(Color.lightGray);

        this.add(commandPanel);
        this.add(titlesPanel);
        this.add(contentPanel);
    }
}
