package com.zyx.susan.DAO;

import com.zyx.susan.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 张宇森
 * @version 1.0
 * BasicDAO 的其他DAO的父类
 */
public class BasicDAO<T> {  //泛型指定具体类型


    private QueryRunner qr=  new QueryRunner();

    //通用的dml方法针对任意表
    public int update(String sql,Object... parameters){

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);  //将编译异常转为运行异常，抛出
        } finally {

            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //返回多个对象方法，针对任意表-》查询结果是多行的
    //clazz:传入一个class对象 比如Actor.class
    public List<T> queryMultiply(String sql,Class<T> clazz,Object... parameters){

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return query;

        } catch (SQLException e) {
            throw new RuntimeException(e);  //将编译异常转为运行异常，抛出
        } finally {

            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单行结果
    public T querySingle(String sql,Class<T> clazz,Object... parameters){

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

            T query = qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
            return query;

        } catch (SQLException e) {
            throw new RuntimeException(e);  //将编译异常转为运行异常，抛出
        } finally {

            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单行单列方法，返回单值
    public Object querySing(String sql,Object... parameters){

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return  qr.query(connection,sql,new ScalarHandler(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);  //将编译异常转为运行异常，抛出
        } finally {

            JDBCUtilsByDruid.close(null,null,connection);
        }
    }


}
