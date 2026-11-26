
import java.awt.*;

public class Ball {
    int x, y, size = 20, dx = 4, dy = 4;

    Ball(int x, int y) { this.x = x; this.y = y; }

    void move() { x += dx; y += dy; }

    void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, size, size);
    }

    Rectangle getBounds() { return new Rectangle(x, y, size, size); }
}