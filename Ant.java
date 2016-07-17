public class Ant {
  private int direction, xPos, yPos;

  public Ant() {
    direction = 0;
    xPos = 0;
    yPos = 0;
  }

  public Ant(int x, int y) {
    direction = 0;
    xPos = x;
    yPos = y;
  }

  public int getX() {
    return xPos;
  }

  public int getY() {
    return yPos;
  }

  public void step(boolean nextStep) {
    if (nextStep) {
      direction += 3;
    } else {
      direction++;
    }
    switch(direction % 4) {
      case 0:
        yPos--;
        break;
      case 1:
        xPos++;
        break;
      case 2:
        yPos++;
        break;
      case 3:
        xPos--;
        break;
      default:
        System.out.println("Butter.");
    }
  }
}
