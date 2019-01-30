package design_pattern.decorator.after;

public class Comvertible extends Decorator {

  boolean openRoof;

  public Comvertible(Car car) {
    super(car);
  }

  @Override
  public void run() {
    if (this.openRoof) {
      System.out.println("지붕을 연다!");
    } else {
      System.out.println("지붕을 닫는다.");
    }
  }

  public void openRoof(boolean openRoof) {
    this.openRoof = openRoof;

  }
}

