import panels.CommandPanel;
import panels.ContentPanel;
import panels.CustomFonts;
import panels.TitlePanel;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    MyFrame(CustomFonts customFonts) {
        this.setVisible(true);
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        TitlePanel titlesPanel = new TitlePanel(customFonts);
        ContentPanel contentPanel = new ContentPanel(customFonts);
        CommandPanel commandPanel = new CommandPanel(customFonts, titlesPanel, contentPanel);

        this.add(titlesPanel);
        this.add(contentPanel);
        this.add(commandPanel);
    }
}
