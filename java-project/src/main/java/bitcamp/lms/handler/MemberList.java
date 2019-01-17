package bitcamp.lms.handler;

import java.util.Arrays;
import bitcamp.lms.domain.Member;

public class MemberList {
  static final int LENGTH = 10;
  Member[] arr = new Member[LENGTH];
  int size = 0;

  public Member[] toArray() {
    Member[] arr = new Member[size];
    for (int i = 0; i < size; i++)
      arr[i] = this.arr[i];
    return arr;
  }

  public void add(Member member) {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));

      System.out.printf("배열이 증가함 %d\n", arr.length);
    }
    arr[size++] = member;
  }
}
