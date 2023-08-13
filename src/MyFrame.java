import panels.CommandPanel;
import panels.ContentPanel;
import panels.TitlePanel;

import javax.swing.*;

public class MyFrame extends JFrame{
    MyFrame() {
        this.setVisible(true);
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        JPanel titlesPanel = new TitlePanel();
        JPanel contentPanel = new ContentPanel();
        JPanel commandPanel = new CommandPanel(titlesPanel, contentPanel);

        this.add(titlesPanel);
        this.add(contentPanel);
        this.add(commandPanel);
    }
}
