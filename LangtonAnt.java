import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class LangtonAnt {
  public static final int SIZE = 1000;
  public static final int RATIO = 4;
  private static JFrame window;
  private static JPanel mainPanel;
  private static JPanel leftPanel;
  private static JPanel rightPanel;
  private static JPanel boardSpace;
  private static Board board;
  // private static int count = 0;

  public static void main (String[] args) {
    board = new Board(SIZE / RATIO);

    int delay = 2;
    ActionListener al = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          board.step();
          rightPanel.repaint();
          // if (count++ > 200) {
          //   count = 0;
          //   board.addAnt();
          // }
      }
    };
    Timer timer = new Timer(delay, al);

    window = new JFrame("Langton's Ant");
    leftPanel = new JPanel();
    rightPanel = new MyPanel(SIZE, RATIO, board);
    boardSpace = new JPanel();

    Container contentPane = window.getContentPane();
    contentPane.setLayout(new FlowLayout());

    leftPanel.setPreferredSize(new Dimension(200, SIZE + 1));
    rightPanel.setPreferredSize(new Dimension(SIZE + 1, SIZE + 1));

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.add(leftPanel);
    window.add(rightPanel);
    window.pack();
    window.setVisible(true);
    timer.start();
  }
}

class MyPanel extends JPanel {
  private int size, ratio;
  private Board board;

  public MyPanel(int s, int r, Board b) {
    size = s;
    ratio = r;
    board = b;
    setBorder(BorderFactory.createLineBorder(Color.black));
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    ArrayList<Ant> ants = board.getAnts();

    for (int i = 0; i < size / ratio; i++) {
      for (int j = 0; j < size / ratio; j++) {
        if (board.getState(i, j)) {
          g.setColor(new Color(0, 0, 0));
          g.fillRect(ratio * i, ratio * j, ratio, ratio);
        } else {
          g.setColor(new Color(200, 200, 200));
          g.drawRect(ratio * i, ratio * j, ratio, ratio);
        }
      }
    }
    g.setColor(new Color(255, 0, 0));
    int x, y;
    for (int i = 0; i < ants.size(); i++) {
      x = ants.get(i).getX();
      y = ants.get(i).getY();
      g.fillOval(x * ratio, y * ratio, ratio, ratio);
    }
  }
}
