package panels.command_sub_panels;

import panels.ContentPanel;
import panels.TitlePanel;

import javax.swing.JPanel;
import java.awt.*;

public class CommandsContainer extends JPanel {
    public CommandsContainer(TitlePanel titlePanel, ContentPanel contentPanel) {
        this.setBounds(50, 140, 196, 400);
        this.setLayout(new BorderLayout());

        JPanel controls = new JPanel(); // Create a panel for the labels
        controls.setBackground(new Color(77, 218, 227));
        controls.setLayout(new FlowLayout());

        CommandButton browseBooks = new CommandButton("Browse Books" , titlePanel, contentPanel);
        controls.add(browseBooks);

        CommandButton browseMembers = new CommandButton("Browse Members" , titlePanel, contentPanel);
        controls.add(browseMembers);

        this.add(controls);
    }


}
