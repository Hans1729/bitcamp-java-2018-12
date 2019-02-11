package design_pattern.observer.after2;

// 자동차의 상태가 바뀌었을 때 호출할 메서드 규칙을 정의한다.
public class EngineOilObserver extends AbstractCarObserver {

  @Override
  public void carStarted() {
    // TODO Auto-generated method stub
    System.out.println("엔진 오일 유무 검사");
  }


  
  // 자동차의 시동이 걸렸을 때 호출할 메서드
  // => 보통 메서드의 이름은 동사로 시작하는데,
  //    옵저버에게 통지할 때 호출하는 메서드는
  //    명사구의 상태 이름으로 정의할 수 있다.
  //    

   
   
   

}