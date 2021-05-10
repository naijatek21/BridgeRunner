import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public LinkedList<Bridge> bridges;

  public static void main(String[] args) {
    System.out.println("Welcome to Bridge Hiker .");
    Heap<Hiker> hikerGroup = new Heap<Hiker>();
    String response = "n";
    System.out.println("Please enter your hikers. Type STOP when complete");

    while (!(response.equals("n"))) {
      Scanner sys = new Scanner(System.in);
      System.out.println("Please enter your hiker's id");
      String id = sys.nextLine();
      System.out.println("Please enter your hiker's speed");
      double speed = sys.nextDouble();
      Hiker h = new Hiker(id, speed);
      hikerGroup.add(h, speed);
      System.out.println("Continue adding? y/n ");
      response = sys.nextLine();

    }

  }

}