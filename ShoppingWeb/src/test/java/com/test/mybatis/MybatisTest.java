package com.test.mybatis;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MybatisTest 
{
    @Inject
    private SqlSessionFactory sqlFactory;
    
<<<<<<< HEAD
    @Test
    public void testFactory(){
        System.out.println("\n >>>>>>>>>> sqlFactory Ãâ·Â : "+sqlFactory);
    }
    
    @Test
    public void testSession() throws Exception{
        
        try(SqlSession session = sqlFactory.openSession()){
            
            System.out.println(" >>>>>>>>>> session Ãâ·Â : "+session+"\n");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

=======
   /* @Test
    public void testFactory(){
        System.out.println("\n >>>>>>>>>> sqlFactory ì¶œë ¥ : "+sqlFactory);
    }
    
    @Test
    public void testSession() throws Exception{
        
        try(SqlSession session = sqlFactory.openSession()){
            
            System.out.println(" >>>>>>>>>> session ì¶œë ¥ : "+session+"\n");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    
}
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
