// java.io.File 클래스 : 연습 과제 - bin/main 뒤져서 모든 클래스 파일의 이름을 출력하라 
package ch22.a;

import java.io.File;

public class Test14 {

  public static void main(String[] args) throws Exception {
    
    File dir = new File("bin");

    findClass(dir, "");
   System.out.println("완료!");
    }
    static void findClass(File dir,String name) {
      File[] files = dir.listFiles(pathname -> 
           pathname.isDirectory() ||   
        (pathname.isFile() && pathname.getName().endsWith(".class"))?
         true : false);
        
         
         for(File file : files) { 
         if(file.isFile()) {
           System.out.printf("%s%s\n", name, file.getName().replace(".class",""));
        }else
        findClass(file , name + file.getName() + "." );
           }
         }
        }



