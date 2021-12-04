package cn.zzw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //要素
            String url = "jdbc:mysql://********:3306/linux_final?characterEncoding=utf-8";
            String username = "root";
            String password = "********";
            //连接
            connection = DriverManager.getConnection(url,username,password);
            //检查
            if (connection!=null) {
                System.out.println("数据库连接已经建立："+connection);
            }else {
                System.out.println("数据库连接失败");
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;

    }
    public static void close(AutoCloseable... res){
        try{
            for (AutoCloseable temp:res){
                if (temp!=null){
                    temp.close();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
