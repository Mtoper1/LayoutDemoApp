import javax.swing.*;
import java.awt.*;

public class LayoutDemoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> showMenu());
    }

    static void showMenu() {
        JFrame frame = new JFrame("LayoutDemoApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        JButton flowLayoutButton = new JButton("FlowLayout");
        flowLayoutButton.addActionListener(e -> showFlowLayout());
        frame.add(flowLayoutButton);

        JButton borderLayoutButton = new JButton("BorderLayout");
        borderLayoutButton.addActionListener(e -> showBorderLayout());
        frame.add(borderLayoutButton);

        JButton gridLayoutButton = new JButton("GridLayout");
        gridLayoutButton.addActionListener(e -> showGridLayout());
        frame.add(gridLayoutButton);

        JButton boxLayoutButton = new JButton("BoxLayout");
        boxLayoutButton.addActionListener(e -> showBoxLayout());
        frame.add(boxLayoutButton);

        JButton cardLayoutButton = new JButton("CardLayout");
        cardLayoutButton.addActionListener(e -> showCardLayout());
        frame.add(cardLayoutButton);

        JButton gridBagLayoutButton = new JButton("GridBagLayout");
        gridBagLayoutButton.addActionListener(e -> showGridBagLayout());
        frame.add(gridBagLayoutButton);

        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void showWindow(String title, JPanel panel) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(550, 350);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    static void showFlowLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        for (int i = 1; i <= 10; i++) {
            panel.add(new JButton("Button " + i));
        }
        showWindow("FlowLayout", panel);
    }

    static void showBorderLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JButton("NORTH"), BorderLayout.NORTH);
        panel.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        panel.add(new JButton("WEST"), BorderLayout.WEST);
        panel.add(new JButton("EAST"), BorderLayout.EAST);
        panel.add(new JButton("CENTER"), BorderLayout.CENTER);
        showWindow("BorderLayout", panel);
    }

    static void showGridLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 5, 5));
        for (int i = 1; i <= 9; i++) {
            panel.add(new JButton("Button " + i));
        }
        showWindow("GridLayout", panel);
    }

    static void showBoxLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JButton("Button 1"));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(new JButton("Button 2"));
        panel.add(Box.createVerticalGlue());
        panel.add(new JButton("Button 3"));
        showWindow("BoxLayout", panel);
    }

    static void showCardLayout() {
        JPanel panel = new JPanel();
        CardLayout layout = new CardLayout();
        panel.setLayout(layout);
        panel.add(new JLabel("Card 1", SwingConstants.CENTER), "1");
        panel.add(new JLabel("Card 2", SwingConstants.CENTER), "2");
        panel.add(new JLabel("Card 3", SwingConstants.CENTER), "3");

        JButton back = new JButton("Back");
        JButton next = new JButton("Next");
        back.addActionListener(e -> layout.previous(panel));
        next.addActionListener(e -> layout.next(panel));

        JPanel buttons = new JPanel();
        buttons.add(back);
        buttons.add(next);
        JPanel content = new JPanel(new BorderLayout());
        content.add(panel, BorderLayout.CENTER);
        content.add(buttons, BorderLayout.SOUTH);
        showWindow("CardLayout", content);
    }

    static void showGridBagLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(new JLabel("Login form"), c);

        c.gridwidth = 1;
        c.gridy = 1;
        panel.add(new JLabel("Login:"), c);

        JTextField login = new JTextField(15);
        c.gridx = 1;
        c.weightx = 1;
        panel.add(login, c);

        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0;
        panel.add(new JLabel("Password:"), c);

        JPasswordField password = new JPasswordField(15);
        c.gridx = 1;
        c.weightx = 1;
        panel.add(password, c);

        JButton submit = new JButton("Zaloguj");
        submit.addActionListener(e -> JOptionPane.showMessageDialog(panel, "Demo"));
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 0;
        panel.add(submit, c);

        JButton cancel = new JButton("Anuluj");
        cancel.addActionListener(e -> {
            login.setText("");
            password.setText("");
        });
        c.gridx = 1;
        c.weightx = 1;
        panel.add(cancel, c);
        showWindow("GridBagLayout", panel);
    }
}
