// Paddle.java
import java.awt.*;

public class Paddle {
    int x, y, width = 100, height = 15, speed = 8;

    Paddle(int x, int y) { this.x = x; this.y = y; }

    void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    Rectangle getBounds() { return new Rectangle(x, y, width, height); }
}