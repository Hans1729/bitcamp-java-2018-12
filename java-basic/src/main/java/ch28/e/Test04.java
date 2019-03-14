// 애노테이션 프로퍼티 추출하기
//
package ch28.e;

@MyAnnotation7(
    name="홍길동",
    age = 20
    )
public class Test04 {
  public static void main(String[] args) {


    Class<?> clazz = Test04.class;
    MyAnnotation7 anno1 = clazz.getAnnotation(MyAnnotation7.class);


    MyAnnotation7 anno2 =  Test04.class.getAnnotation(MyAnnotation7.class);
  }
}
