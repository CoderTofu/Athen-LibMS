package panels;

import panels.command_sub_panels.AppTitle;
import panels.command_sub_panels.CommandsContainer;

import javax.swing.*;
import java.awt.*;

public class CommandPanel extends JPanel {

    public CommandPanel(CustomFonts customFonts, TitlePanel titlePanel, ContentPanel contentPanel) {
        this.setBounds(0, 0, 283, 700);
        this.setBackground(new Color(77, 218, 227));
        this.setLayout(null);

        AppTitle appTitle = new AppTitle(customFonts.getHeadingsFont());
        CommandsContainer commandsContainer = new CommandsContainer(titlePanel, contentPanel);

        this.add(appTitle);
        this.add(commandsContainer);
    }

    @Override
    protected void paintComponent(Graphics g) { // Create a circle for design purposes
        super.paintComponent(g);

        g.setColor(new Color(255, 188, 188)); // Set the circle color
        g.fillOval(108, 490, 335, 335);
    }

}
