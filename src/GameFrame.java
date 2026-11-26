// GameFrame.java
import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Ball Game");
        add(new GamePanel());
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}