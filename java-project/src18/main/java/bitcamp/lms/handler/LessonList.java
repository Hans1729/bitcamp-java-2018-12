package bitcamp.lms.handler;

import java.util.Arrays;
import bitcamp.lms.domain.Lesson;

public class LessonList {
  static final int LENGTH = 3;
  Lesson[] arr = new Lesson[LENGTH];
  int size = 0;
  
  
  public Lesson[] toArray() {
    Lesson[] arr = new Lesson[size] ;
    for(int i = 0; i<size; i++) 
      arr[i] = this.arr[i];
 
    return arr;
  }
   
  public void add(Lesson lesson) {
     if(size == arr.length) {
       arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));
       
       System.out.printf("배열이 증가함 %d\n", arr.length);
     }
   arr[size++] = lesson;
  }
}
