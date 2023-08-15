package panels.command_sub_panels;

import panels.ContentPanel;
import panels.TitlePanel;

import javax.swing.*;

public class CommandsContainer extends JPanel {
    public CommandsContainer(TitlePanel titlePanel, ContentPanel contentPanel) {
        JButton testButton = new JButton("Hello");
        testButton.addActionListener(e -> buttonFunc(titlePanel, testButton));
        testButton.setBounds(50, 300, 100, 50);
        this.setBounds(50, 300, 100, 50);
        this.add(testButton);
    }

    private void buttonFunc(TitlePanel titlePanel, JButton button) {
        titlePanel.changeText(button.getText());
    }

}
