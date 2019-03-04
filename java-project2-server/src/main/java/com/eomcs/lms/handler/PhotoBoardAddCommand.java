package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardAddCommand extends AbstractCommand {
  
  PhotoBoardDao photoBoardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.
  
  public PhotoBoardAddCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }
  
  @Override
  public void execute(Response response) throws Exception{
      PhotoBoard board = new PhotoBoard();
      board.setTitle(response.requestString("내용?"));
      board.setLessonNo(response.requestIntValue("수업명?"));
      photoBoardDao.insert(board);

      response.println("저장하였습니다.");
  }
}
