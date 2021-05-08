import common.Util;

public class Hiker {
  private String id;
  private int speed;

  public Hiker(String id, int speed) {
    this.id = id;
    this.speed = speed;
  }

  public int getSpeed() {
    return speed;
  }

  public String getId() {
    return id;
  }

}
