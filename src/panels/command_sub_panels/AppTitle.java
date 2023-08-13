package panels.command_sub_panels;

import javax.swing.*;
import java.awt.*;

public class AppTitle extends JPanel {
    public AppTitle() {
        this.setBounds(9, 20, 264, 120);
        this.setLayout(null);
        this.setBackground(new Color(77, 218, 227));

        JLabel title = new JLabel("Athens");
        title.setBounds(-9, 8, 283, 125);
        title.setFont(new Font("Serif", Font.PLAIN, 96));
        this.add(title);
    }
}
