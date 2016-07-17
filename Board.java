import java.util.ArrayList;

public class Board {
  private boolean[][] cell;
  private int width, length;
  private ArrayList<Ant> ants;

  public Board(int l, int w) {
    cell = new boolean[l][w];
    width = w;
    length = l;
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < w; j++) {
        cell[i][j] = false;
      }
    }
    ants = new ArrayList<Ant>();
    ants.add(new Ant(w / 2, l / 2));
  }

  public Board(int size) {
    cell = new boolean[size][size];
    width = size;
    length = size;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        cell[i][j] = false;
      }
    }
    ants = new ArrayList<Ant>();
    ants.add(new Ant(size / 2, size / 2));
  }

  public void addAnt(int x, int y) {
    ants.add(new Ant(x, y));
  }

  public void addAnt() {
    ants.add(new Ant(width / 2, length / 2));
  }

  public void step() {
    boolean state;
    int x, y;
    for (int i = 0; i < ants.size(); i++) {
      x = ants.get(i).getX();
      y = ants.get(i).getY();
      if (x < 0 || x >= width || y < 0 || y >= length) {
        ants.remove(i);
        continue;
      }
      state = cell[x][y];
      cell[x][y] = !cell[x][y];
      ants.get(i).step(state);
    }

  }

  public boolean getState(int x, int y) {
    return cell[x][y];
  }

  public ArrayList<Ant> getAnts() {
    return ants;
  }
}
