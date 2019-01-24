// Object 클래스 - getClass() 의 배열의 항목 이름
package ch15;

public class Test14 {
  public static void main(String[] args) {
  
    String[] obj2 = new String[10];
    Class classInfo = obj2.getClass();
    System.out.println(classInfo.getName());//[Ljava.lang.String; L = LIST 
    System.out.println(classInfo.getComponentType());//[Ljava.lang.String; L = LIST
    
    Class componentTypeInfo = classInfo.getComponentType();
    System.out.println(componentTypeInfo.getName());
    
    // 값을 한 번 밖에 사용하지 않을 것이라면
    // 위의 경우처럼 한 번에 호출하고, 리턴 값을 가지고 또 호출하는 방식으로 값을 꺼내지 않는다.
    // 체인(chain) 방식으로 호출한다.
    System.out.println(obj2.getClass().getComponentType().getName());
  }
}







