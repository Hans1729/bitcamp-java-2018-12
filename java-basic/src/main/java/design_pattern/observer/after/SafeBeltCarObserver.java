package design_pattern.observer.after;

public class SafeBeltCarObserver implements CarObserver {

  @Override
  public void carStarted() {
    // TODO Auto-generated method stub
    System.out.println("안전벨트 착용 여부 검사.");
    
  }

  @Override
  public void carStopped() {
    // TODO Auto-generated method stub
    
  }

}
