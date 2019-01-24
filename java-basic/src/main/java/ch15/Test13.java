// Object 클래스 - getClass() 의 배열
package ch15;

public class Test13 {
  public static void main(String[] args) {
    String obj1 = new String();
    
    // 레퍼런스를 통해서 인스턴스의 클래스 정보를 알아낼 수 있다.
    Class classInfo = obj1.getClass();
    
     // 배열의 클래스 정보
    System.out.println(classInfo.getName());
   
    String[] obj2 = new String[10];
    classInfo = obj2.getClass();
    System.out.println(classInfo.getName());//[Ljava.lang.String; L = LIST 

    int[] obj3 = new int[10];
    classInfo = obj3.getClass();
    System.out.println(classInfo.getName()); // [I = Int
    
    float[] obj4 = new float[10];
    classInfo = obj4.getClass();
    System.out.println(classInfo.getName()); // [F =
   
    double[] obj5 = new double[10];
    classInfo = obj5.getClass();
    System.out.println(classInfo.getName()); // [D = 
  }
}







