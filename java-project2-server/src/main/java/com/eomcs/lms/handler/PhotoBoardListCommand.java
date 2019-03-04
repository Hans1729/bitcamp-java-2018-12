// 4단계: Command를 다루는 클래스에 대해 리펙토리 수행
// => Command를 미리 구현한 AbstractCommand 클래스 생성

package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardListCommand extends AbstractCommand {

  PhotoBoardDao photoboardDao;

  public PhotoBoardListCommand( PhotoBoardDao photoboardDao) {
    this.photoboardDao = photoboardDao;
  }

  @Override
  public void execute(Response response) {

    List<PhotoBoard> boards = photoboardDao.findAll();
    
    for (PhotoBoard board : boards) {
      response.println(String.format("%3d, %-20s, %s, %d, %d\n", 
          board.getNo(), board.getTitle(), 
          board.getCreatedDate(), board.getViewCount(),
           board.getLessonNo()));
    }
  }
}
