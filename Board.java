public class Board {
  private boolean[][] cell;
  private int width, length, antX, antY, antDir;

  public Board(int l, int w) {
    antX = w / 2;
    antY = l / 2;
    antDir = 0; // 0 = UP, 1 = RIGHT, 2 = DOWN, 3 = LEFT. (all modulo 4)
    cell = new boolean[l][w];
    width = w;
    length = l;
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < w; j++) {
        cell[i][j] = false;
      }
    }
  }

  public Board(int size) {
    antX = size / 2;
    antY = size / 2;
    cell = new boolean[size][size];
    width = size;
    length = size;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        cell[i][j] = false;
      }
    }
  }

  public void step() {
    boolean state = cell[antX][antY];
    cell[antX][antY] = !cell[antX][antY];
    if (state) {
      antDir += 3;
    } else {
      antDir++;
    }
    switch(antDir % 4) {
      case 0:
        antY--;
        break;
      case 1:
        antX++;
        break;
      case 2:
        antY++;
        break;
      case 3:
        antX--;
        break;
      default:
        System.out.println("Butter.");
    }
  }

  public boolean get(int x, int y) {
    return cell[x][y];
  }

  public int getX() {
    return antX;
  }

  public int getY() {
    return antY;
  }
}
