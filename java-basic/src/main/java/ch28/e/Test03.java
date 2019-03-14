// 애노테이션 프로퍼티
// => 메서드 선언하는 문법과 비슷하다
// => 기본 값을 지정하지 않으면 필수 입력이다.
// 
package ch28.e;

public class Test03 {

  @MyAnnotation6(value= {"aaa"}) // 배열의 값을 지정할 때는 중괄호로 감싼다.
  int a; 

  @MyAnnotation6(value= {"aaa"})// 물론 value 이름의 값만 설정할 때는 이름 생략 가능
  int b;

  @MyAnnotation6(value= "aaa") //배열의 값이 한 개 일 떄는 중괄호 생략  가능
  int c;

  //  @MyAnnotation6(value= "aaa","bbb") // 배열의 값이 여러 개일 때는 중괄호 생략 불가!
  int d; 

  @MyAnnotation6(value= {"aaa","bbb"}) // 배열의 값이 여러 개일 때는 반드시 중괄호로 감싸야 한다.
  int e; 
}
