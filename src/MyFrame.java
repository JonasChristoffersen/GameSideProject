import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JLabel label;
    JPanel greenPanel;

    MyFrame(){

        ImageIcon wheatImage = new ImageIcon("minecraftwheat.png");

        label = new JLabel();

        label.setText("Crop Clicker");
        label.setForeground(new Color(0x00FF00));
        label.setFont(new Font("MV Boli", Font.PLAIN, 40));
        label.setBackground(Color.black);
        label.setOpaque(true);
        //label.setBorder(border);
        //label.setVerticalAlignment(JLabel.TOP);
        //label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(100, 0,250, 75);

        button = new JButton();
        button.setBounds(100, 200, 300, 300);
        button.addActionListener(this);
        button.setText("Harvest");
        button.setFocusable(false);
        button.setIcon(wheatImage);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setBackground(new Color(77, 51, 34));
        button.setFont(new Font("Comic Sand", Font.BOLD, 25));
        button.setIconTextGap(-5);
        button.setForeground(Color.black);
        button.setBorder(BorderFactory.createEtchedBorder());

        greenPanel = new JPanel();
        greenPanel.setBackground(new Color(17, 122, 26));
        greenPanel.setBounds(0, 0, 500, 750);
        greenPanel.setLayout(null);
        greenPanel.add(button);

        this.setTitle("Crop Clicker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(750, 750);
        this.setVisible(true);
        this.setLayout(null);
        this.setIconImage(wheatImage.getImage());
        this.add(button);
        this.add(label);
        this.add(greenPanel);
        this.setLocationRelativeTo(null);



        //this.getContentPane().setBackground(new Color(17, 122, 26));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("+1");
        }
    }
}
