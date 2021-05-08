public class Bridge {
  private int length;
  private int hikers;

  public Bridge(int length, int hikers) {
    this.length = length;
    this.hikers = hikers;
  }

  public int getLength() {
    return length;
  }

  public int getTotalHikers() {
    return hikers;
  }

}