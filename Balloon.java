import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Balloon extends JComponent {

    private static final int SIZE = 50;
    private static final Color COLOR = Color.RED;
    private static final int SPEED = 10;
    private static final int POP_THRESHOLD = 5;

    private int x, y;
    private int dx;
    private Random rand;
    private int popCount;

    public Balloon() {
        rand = new Random();
        setSize(new Dimension(SIZE, SIZE));
        setVisible(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (contains(e.getPoint())) {
                    pop();
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(COLOR);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public void move() {
        x += dx;
        repaint();
    }

    public void reset() {
        x = -SIZE;
        y = rand.nextInt(getHeight() - SIZE);
        dx = SPEED;
        popCount = 0;
    }


        
        private void pop() {
            popCount++;
            if (popCount >= POP_THRESHOLD) {
                setVisible(false);
            }
        }
    
        public boolean isPopped() {
            return !isVisible();
        }
    
        public int getX() {
            return x;
        }
    
        public int getY() {
            return y;
        }
    }
    
