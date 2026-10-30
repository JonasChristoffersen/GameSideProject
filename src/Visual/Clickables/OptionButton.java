package Visual.Clickables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class OptionButton extends Buttons{
    public OptionButton() {
        this.setPreferredSize(new Dimension(150, 40));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] responses = {"OK"}; //, "thank you!", "*blush*"
                String message = "<html><body style='font-family: sans-serif; padding: 5px;'>" +
                        "<h1>Options &amp; Help</h1>" +

                        "<h2>General information:</h2>" +
                        "<table cellpadding='3'>" +
                        "<tr><td>Game</td><td>Crop Clicker A/S</td></tr>" +
                        "<tr><td>Version</td><td>0.0.0.1</td></tr>" +
                        "<tr><td>Authors</td><td>Andreas, Mathias &amp; Jonas</td></tr>" +
                        "</table>" +

                        "<h2>Help / information about gameplay:</h2>" +
                        "<p>Your goal is to earn as much money as possible by running your own farm.</p>" +
                        "<ul>" +
                        "<li><u>Click the crops</u> (Wheat and Tomatoes) to earn money.</li>" +
                        "<li><u>Wait before you click:</u> Crops grow between clicks, so the longer you wait, " +
                        "the more you earn. Wheat grows faster than tomatoes.</li>" +
                        "<li><u>Buy upgrades</u> in the panel on the right (Shovel, Bucket and Hoe). They earn " +
                        "you money every second, even when you're not clicking.</li>" +
                        "<li><u>Keep an eye on the bottom bar:</u> It shows your money, your income per second " +
                        "and your level.</li>" +
                        "<li><u>Remember to save:</u> Press \"Save Game\" to store your progress so you can " +
                        "continue next time.</li>" +
                        "</ul>" +
                        "</body></html>";

                //Text is written in https://text-html.com/
                //After put into claude to convert direct HTML code to format for the text box above


                JOptionPane.showOptionDialog(
                        null,
                        message,
                        "Options / help",
                        JOptionPane.YES_OPTION,
                        PLAIN_MESSAGE,
                        null,
                        responses,
                        responses[0]);
            }
        });

    }
}
