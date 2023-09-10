package panels.command_sub_panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;

public class AppTitle extends JPanel {
    public AppTitle(Font bodyFont) {
        this.setBounds(9, 20, 264, 120);
        this.setLayout(null);
        this.setBackground(new Color(77, 218, 227));

        JLabel title = new JLabel("Athens");
        title.setBounds(0, 8, 283, 125);

        title.setFont(bodyFont.deriveFont(100f));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setForeground(Color.white);
        this.add(title);

        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black);
        this.setBorder(bottomBorder);
    }
}
