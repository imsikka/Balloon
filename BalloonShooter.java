import javax.swing.*;

public class BalloonShooter {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Balloon Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gamePanel = new GamePanel();
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
