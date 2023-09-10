package panels.command_sub_panels;

import panels.ContentPanel;
import panels.TitlePanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommandButton extends JPanel {
    String text = "";
    TitlePanel titlePanel = null;
    ContentPanel contentPanel = null;

    JLabel buttonText = new JLabel();

    CommandButton(String text, TitlePanel titlePanel, ContentPanel contentPanel) {
        this.setBackground(new Color(77, 218, 227));
        this.text = text;
        this.titlePanel = titlePanel;
        this.contentPanel = contentPanel;
        createButton();
    }

    private void createButton() {
        this.buttonText.setText(this.text);
        this.buttonText.addMouseListener(new MouseAdapter() {
            public  void mouseClicked(MouseEvent e) {
                buttonFunc(titlePanel, text);
            }
        });
        this.add(buttonText);
    }

    private void buttonFunc(TitlePanel titlePanel, String text) {
        titlePanel.changeText(text);
    }
}
