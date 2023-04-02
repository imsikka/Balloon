import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {

    private JButton startButton;
    private JLabel scoreLabel;
    private Timer timer;
    private Balloon balloon;
    private int score;

    public GamePanel() {
        setPreferredSize(new Dimension(500, 500));
        setLayout(new BorderLayout());

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        scoreLabel = new JLabel("Score: 0");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(startButton);
        buttonPanel.add(scoreLabel);

        add(buttonPanel, BorderLayout.NORTH);

        balloon = new Balloon();
        add(balloon);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balloon.move();
                if (balloon.getX() > getWidth()) {
                    endGame();
                } else if (balloon.isPopped()) {
                    score++;
                    scoreLabel.setText("Score: " + score);
                    balloon.reset();
                }
            }
        });
    }

    private void startGame() {
        startButton.setEnabled(false);
        score = 0;
        scoreLabel.setText("Score: " + score);
        balloon.reset();
        balloon.setVisible(true);
        timer.start();
    }

    private void endGame() {
        startButton.setEnabled(true);
        balloon.setVisible(false);
        timer.stop();
    }
}
