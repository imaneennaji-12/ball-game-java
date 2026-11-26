// GamePanel.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    static final int W = 600, H = 400;
    Timer timer = new Timer(16, this);   // ~60 images/seconde
    Ball ball = new Ball(W / 2, H / 2);
    Paddle paddle = new Paddle(W / 2 - 50, H - 40);
    int score = 0;
    boolean gameOver = false;
    boolean left, right;

    public GamePanel() {
        setPreferredSize(new Dimension(W, H));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        paddle.draw(g);
        g.setColor(Color.WHITE);
        g.drawString("Score : " + score, 10, 20);
        if (gameOver) {
            g.drawString("GAME OVER - Espace pour rejouer", W / 2 - 100, H / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) update();
        repaint();
    }

    void update() {
        ball.move();
        // murs
        if (ball.x <= 0 || ball.x + ball.size >= W) ball.dx = -ball.dx;
        if (ball.y <= 0) ball.dy = -ball.dy;
        // raquette
        if (ball.getBounds().intersects(paddle.getBounds()) && ball.dy > 0) {
            ball.dy = -ball.dy;
            score++;
        }
        // perdu
        if (ball.y > H) gameOver = true;
        // mouvement raquette
        if (left && paddle.x > 0) paddle.x -= paddle.speed;
        if (right && paddle.x + paddle.width < W) paddle.x += paddle.speed;
    }

    void restart() {
        ball = new Ball(W / 2, H / 2);
        score = 0;
        gameOver = false;
    }

    @Override public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
        if (e.getKeyCode() == KeyEvent.VK_SPACE && gameOver) restart();
    }
    @Override public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
    }
    @Override public void keyTyped(KeyEvent e) {}
}