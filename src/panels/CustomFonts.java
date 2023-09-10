package panels;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class CustomFonts {

    private Font headings;
    private Font body;

    public CustomFonts() {
        try {
            this.headings = Font.createFont(Font.TRUETYPE_FONT, new File("res/Engagement-Regular.ttf"));
            this.body = Font.createFont(Font.TRUETYPE_FONT, new File("res/Inter-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(this.headings);
            ge.registerFont(this.body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Font getHeadingsFont() {
        return this.headings;
    }

    public Font getBodyFont() {
        return this.body;
    }
}
