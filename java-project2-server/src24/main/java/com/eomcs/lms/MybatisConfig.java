package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 
@Configuration 
@MapperScan("com.eomcs.lms.dao") 
public class MybatisConfig {
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource,
      ApplicationContext appCtx) throws Exception {
    
    // mybatis에서 SqlSessionFactory를 생성할 때 사용하라고 제공하는 객체이다. 
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    
    // SqlSessionFactory 객체를 생성하는데 필요한 객체를 주입한다.
    factoryBean.setDataSource(dataSource);
    
    // 도메인 클래스의 별명을 자동을 생성하도록 도메인 클래스가 들어 있는 패키지를 지정한다.
    factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    
    // SQL 매퍼 파일이 있는 패키지를 등록한다.
    factoryBean.setMapperLocations(
        appCtx.getResources("classpath:/com/eomcs/lms/mapper/*.xml"));
    
    return factoryBean.getObject();
  }
  
  /*
  // DAO 구현체 자동 생성하기 방법1:
  // => mybatis에서 Spring과 함께 사용하라고 제공해주는 SqlSessionTemplate을 사용한다.
  // => @MapperScan 애노테이션을 사용하면 더 간단히 DAO 구현체를 자동 생성할 수 있다.
  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
  
  // BoardDao 객체를 만들어 주는 메서드
  @Bean
  public BoardDao boardDao(SqlSessionTemplate sessionTemplate) throws Exception {
    return sessionTemplate.getMapper(BoardDao.class);
  }
  
  //MemberDao 객체를 만들어 주는 메서드
  @Bean
  public MemberDao memberDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(MemberDao.class);
  }

  //LessonDao 객체를 만들어 주는 메서드
  @Bean
  public LessonDao lessonDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(LessonDao.class);
  }

  //PhotoBoardDao 객체를 만들어 주는 메서드
  @Bean
  public PhotoBoardDao photoBoardDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(PhotoBoardDao.class);
  }

  //PhotoFileDao 객체를 만들어 주는 메서드
  @Bean
  public PhotoFileDao photoFileDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(PhotoFileDao.class);
  }
  */

}
