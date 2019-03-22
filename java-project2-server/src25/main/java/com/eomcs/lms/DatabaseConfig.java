package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 특정 패키지를 탐색하여 @Component 애노테이션이 붙은 클래스에 대해 인스턴스를 생성하게 만드는 애노테이션
@Configuration // 
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")
@EnableTransactionManagement
public class DatabaseConfig {

 
  @Autowired 
  Environment env;
  
  @Bean
  public DataSource dataSource() {
    // DBMS 정보는 jdbc.properties 파일에 있다.
    // Spring IoC 컨테이너에서 주입 받은 env 객체를 사용하여 이 파일의 값을 꺼내면 된다.
    
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(env.getProperty("jdbc.driver")); 
    ds.setUrl(env.getProperty("jdbc.url"));
    ds.setUsername(env.getProperty("jdbc.username"));
    ds.setPassword(env.getProperty("jdbc.password"));
    return ds;
  }
  
  
  @Bean
  public PlatformTransactionManager transationManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
  
  
}






