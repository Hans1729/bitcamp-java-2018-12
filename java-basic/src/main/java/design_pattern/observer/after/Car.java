package design_pattern.observer.after;

import java.util.HashSet;

public class Car {
  // 옵저버 목록을 저장할 집합객체 준비
  // => 같은 옵저버가 중복 등록되지 않도록 HashSet을 사용한다.
  // => 등록 순서에 따라 통지할 필요는 없다.
  // 
  HashSet<CarObserver> observers = new HashSet<>();
  
  //옵저버를 관리하는 메서드 추가
  public void addObserver(CarObserver observer) {
    observers.add(observer);
    
  }
  
  public void removeObserver(CarObserver observer) {
    observers.remove(observer);
  }
  
  public void notifyObserversOnStarted() {
    for(CarObserver observer : observers) {
      observer.carStarted();
    }
  }
    public void notifyObserversOnStopped() {
      for(CarObserver observer : observers) {
        observer.carStopped();
      }
  }
  
  
  
  public void start() {
  System.out.println("시동을 건다.");
   notifyObserversOnStarted();
  // 예) 1월 20일 - 자동차 시동을 걸 때 안전 벨트 착용 여부를 검사하는 기능을 추가

  // 예) 2월 30일 - 자동차 시동을 걸 때 엔진 오일 유무를 검사하는 기능을 추가 

  
  // 예) 3월 2일 - 자동차 시동을 걸 때 엔진 오일 유무를 검사하는 기능을 추가

  }
   public void run() {
     System.out.println("달린다.");
    }
  
  public void stop() { 
    System.out.println("시동을 끈다.");
      notifyObserversOnStopped();
    // 예) 4월 15일 자동차 전조등 끌 때 전조등 자동 끄기 기능을 추가
  
    
 
  }
}
