import java.util.Set;

public class Bridge {
  private String name;
  private int length;
  private int hikers;
  private Set<String> ledger;
  private Hiker newHiker;

  public Bridge(String name, int length, Hiker h) {
    this.length = length;
    hikers = 0;
    ledger = null;
    this.name = name;
    newHiker = h;

  }

  public int getLength() {
    return length;
  }

  public int getTotalHikers() {
    return hikers;
  }

  public void addHiker(Hiker h) {
    ledger.add(h.getId());
    this.hikers += 1;
  }

  public String name() {
    return name;
  }

  public Hiker pickup() {
    Hiker h = this.newHiker;
    this.newHiker = null;
    return h;
  }

  public String report() {
    return "Bridge " + this.name + "of length " + this.length + "ft. was crossed by /n"
        + ((this.ledger.toArray()).toString()) + "/n" + "with a total of " + this.hikers + "hikers";
  }
}