package Level1.Lesson8.components;

import javax.swing.*;
import java.awt.*;

public class NumberJButton extends JButton {
    public NumberJButton (String text) {
        super(text);
        setFont(new Font("TimesRoman", Font.PLAIN, 25));
        setBackground(new Color(100, 178, 196));
    }
}
