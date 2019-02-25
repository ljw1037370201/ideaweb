package com.lijw.test;

import com.lijw.pojo.DBCPUtils;
import com.lijw.pojo.Students;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    @Test
    public void first(){
        Connection conn = DBCPUtils.getConnection();
        String sql = "SELECT  * FROM students";
        Statement stmt = null;
        ResultSet result =null;
        try {
            List<Students> students = new ArrayList<Students>();
            stmt = conn.createStatement();
            result =  stmt.executeQuery(sql);
            while (result.next()){
                Students student = new Students();
                student.setId(result.getInt("id"));
                student.setName(result.getString("name"));
                student.setSex(result.getString("sex"));
                student.setAge(result.getInt("age"));
                students.add(student);
            }
            for (int i = 0;i < students.size(); i++){
                System.out.println(students.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBCPUtils.closedAll(conn,stmt,result);
        }
    }
}
