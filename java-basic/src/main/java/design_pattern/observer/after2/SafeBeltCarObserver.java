package design_pattern.observer.after2;

public class SafeBeltCarObserver extends AbstractCarObserver {

  @Override
  public void carStarted() {
    // TODO Auto-generated method stub
    System.out.println("안전벨트 착용 여부 검사.");
    
  }

}
