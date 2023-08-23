package panels.command_sub_panels;

import panels.ContentPanel;
import panels.TitlePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommandsContainer extends JPanel {
    public CommandsContainer(TitlePanel titlePanel, ContentPanel contentPanel) {
//        JButton testButton = new JButton("Remove Member");
//        testButton.addActionListener(e -> buttonFunc(titlePanel, testButton));
//        testButton.setBounds(50, 300, 100, 50);
//        this.add(testButton);
        this.setBounds(50, 140, 196, 400);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel labelPanel = new JPanel(); // Create a panel for the labels
        labelPanel.setLayout(new FlowLayout());

        JLabel browseBooks = new JLabel("Browse Books");
        browseBooks.addMouseListener(new MouseAdapter() {
            @Override
            public  void mouseClicked(MouseEvent e) {
                buttonFunc(titlePanel, browseBooks);
            }
        });
        labelPanel.add(browseBooks);

        JLabel browseMembers = new JLabel("Browse Members");
        browseMembers.addMouseListener(new MouseAdapter() {
            @Override
            public  void mouseClicked(MouseEvent e) {
                buttonFunc(titlePanel, browseMembers);
            }
        });
        labelPanel.add(browseMembers);

        this.add(labelPanel);
    }

    private void buttonFunc(TitlePanel titlePanel, JLabel label) {
        titlePanel.changeText(label.getText());
    }

}
