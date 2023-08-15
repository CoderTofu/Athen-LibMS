package panels;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    JLabel contentTitle;
    public TitlePanel() {
        this.contentTitle = new JLabel();
        this.contentTitle.setText("Browse Books");
        this.contentTitle.setBounds(283, 0, 717, 100);
        this.setBounds(283, 0, 717, 100);
        this.setBackground(new Color(47, 155, 255));
        this.add(contentTitle);
    }

    public void changeText(String newText) {
        this.contentTitle.setText(newText);
    }
}
