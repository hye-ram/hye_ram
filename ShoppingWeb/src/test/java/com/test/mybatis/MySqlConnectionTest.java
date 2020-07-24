package com.test.mybatis;

import java.sql.Connection;
 
import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
import org.junit.Test;
import org.junit.runner.RunWith;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MySqlConnectionTest {
    
    @Inject
    private DataSource ds;
 
    @Test
    public void testConnection() throws Exception {
 
        try (Connection con = ds.getConnection()) {
 
            System.out.println("\n >>>>>>>>>> Connection Ãâ·Â : " + con + "\n");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}