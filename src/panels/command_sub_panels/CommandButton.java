package panels.command_sub_panels;

import panels.ContentPanel;
import panels.TitlePanel;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CommandButton {
    String text = "";
    TitlePanel titlePanel = null;
    ContentPanel contentPanel = null;

    List<JPanel> buttons = new ArrayList<>();

    CommandButton(String text, TitlePanel titlePanel, ContentPanel contentPanel) {
        this.text = text;
        this.titlePanel = titlePanel;
        this.contentPanel = contentPanel;

        createButton("Test");

        addButtonsToContainer();
    }

    private void createButton(String text) {
        JPanel buttonPanel = new JPanel();
        JLabel button = new JLabel();
        button.setText(this.text);
        button.addMouseListener(new MouseAdapter() {
            public  void mouseClicked(MouseEvent e) {
                buttonFunc(titlePanel, button.getText());
            }
        });
        buttonPanel.add(button);
        buttons.add(buttonPanel);
    }

    private void buttonFunc(TitlePanel titlePanel, String text) {
        titlePanel.changeText(text);
    }

    private void addButtonsToContainer() {

    }
}
