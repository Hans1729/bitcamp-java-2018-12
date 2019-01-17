package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Lesson;


public class LessonHandler {

  LessonList lessonList = new LessonList();
  Scanner keyboard;

  
  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void listLesson() {
    Lesson[] lessons = lessonList.toArray();
    
    for (Lesson lesson : lessons ){
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNo(), lesson.getTitle(), lesson.getStartDate(), 
          lesson.getEndDate(), lesson.getTotalHours());
    }
  }

  public void addLesson() {
    Lesson lesson = new Lesson();
    
    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));// Integer.parseInt(keyboard.nextLine());

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
    
    lessonList.add(lesson);
    System.out.println("저장하였습니다");
   

 
  }

}
