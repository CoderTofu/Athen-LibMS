package panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;

public class TitlePanel extends JPanel {

    JLabel contentTitle;
    public TitlePanel(CustomFonts customFonts) {
        this.setBounds(283, 0, 717, 100);
        this.setBackground(new Color(47, 155, 255));
        this.setLayout(new FlowLayout());

        contentTitle = new JLabel();
        contentTitle.setText("Browse Books");
        contentTitle.setBounds(283, 0, 717, 5000);
        contentTitle.setFont(customFonts.getHeadingsFont().deriveFont(70f));
        contentTitle.setHorizontalAlignment(JLabel.CENTER);
        contentTitle.setVerticalAlignment(JLabel.CENTER);
        contentTitle.setForeground(Color.white);

        this.add(contentTitle);
    }

    public void changeText(String newText) {
        this.contentTitle.setText(newText);
    }
}
