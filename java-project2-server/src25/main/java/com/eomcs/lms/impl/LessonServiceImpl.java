package com.eomcs.lms.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;

// 스프링 IoC 컨테이너가 관리하는 객체 중에서
// 비즈니스 로직을 담당하는 객체는
// 특별히 그 역할을 표시하기 위해 @Commpoent 대신에 @Service 애노테이션을 붙인다.
// 이렇게 애노테이션을 구분해두면 나중에 애노테이션으로 객체를 찾을 수 있다.
@Service
public class LessonServiceImpl implements LessonService {

  LessonDao lessonDao;
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  PlatformTransactionManager txManager;

  public LessonServiceImpl(LessonDao lessonDao,
      PhotoBoardDao photoBoardDao,
      PhotoFileDao photoFileDao,
      PlatformTransactionManager txManager) {
    
    this.lessonDao = lessonDao;
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.txManager = txManager;
  }

  //비즈니스 객체에서 메서드 이름은 가능한 업무 용어를 사용한다.
  @Override
  public List<Lesson> list() {
    // 게시물 목록을 가져오는 경우 서비스 객체에서 특별하게 할 일이 없다.
    // 그럼에도 불구하고 Command 객체와 DAO 사이에 Service 객체를 두기로 했으면
    // 일관성을 위해 Command 객체는 항상 Service 객체를 통해 데이터를 다뤄야 한다.
    // 
    return lessonDao.findAll();
  }
//
  @Override
  public int add(Lesson lesson) {
    // 이 메서드도 하는 일이 없다.
    // 그래도 일관된 프로그래밍을 위해 Command 객체는 항상 Service 객체를 경유하여 DAO를 사용해야 한다.
    
    return lessonDao.insert(lesson);
  }
  
  @Override
  public Lesson get(int no) {
    
    Lesson lesson = lessonDao.findByNo(no);
    if (lesson == null) {
      System.out.println("해당 번호의 수업이 없습니다.");
    }
  
    return lesson;
  }
  
//  
  @Override
  public int update(Lesson lesson) {
     // 그냥 DAO 실행시키고 리턴 값을 그대로 전달한다.

    
    return lessonDao.update(lesson) ;
  }
//  
  @Override
  public int delete(int no) {
    // 트랜잭션 동작 방식을 설정한다.
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    
    // 트랜잭션을 준비한다.
    TransactionStatus status = txManager.getTransaction(def);
   
    try {
      HashMap<String,Object> params = new HashMap<>();
      params.put("lessonNo", no);
      
      List<PhotoBoard> boards = photoBoardDao.findAll(params);
      for (PhotoBoard board : boards) {
        photoFileDao.deleteByPhotoBoardNo(board.getNo());
        photoBoardDao.delete(board.getNo());
      }
      int count = lessonDao.delete(no);

      txManager.commit(status);
      return count;

    } catch (RuntimeException e) {
      txManager.rollback(status);
      throw e;
    }

  }
  
  


}
