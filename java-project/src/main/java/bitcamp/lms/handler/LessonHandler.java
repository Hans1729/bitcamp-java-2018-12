package bitcamp.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Lesson;
import bitcamp.util.ArrayList;

public class LessonHandler {

  Scanner keyboard;
  ArrayList<Lesson> list;

  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }

  public void listLesson() {
    Lesson[] lessons = list.toArray(new Lesson[] {});
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("수업명? ");
    lesson.setTitle(keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

    list.add(lesson);

    System.out.println("저장하였습니다.");
  }

  public void detailLesson(int no) {
    System.out.print("번호:?");
    Integer.parseInt(keyboard.nextLine());
   
    for(int i=0; i < list.size(); i ++) {
      Lesson item = list.get(i);
      if(item.getNo == no) {
        return i;
  }
      
    }
    return -1 
  }

  public void updateLesson() {
    System.out.print("번호:? ");
    Integer.parseInt(keyboard.nextLine());
    
  }

  public void deleteLesson() {
    System.out.print("번호:?");
    Integer.parseInt(keyboard.nextLine());
    
  }

}