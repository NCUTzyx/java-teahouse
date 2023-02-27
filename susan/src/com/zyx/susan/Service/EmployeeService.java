package com.zyx.susan.Service;

import com.zyx.susan.DAO.EmployeeDAO;
import com.zyx.susan.Domain.Employee;

/**
 * @author 张宇森
 * @version 1.0
 * 对employee表 的操作（调用EmployeeDAO）
 */
public class EmployeeService {

    //定义Employee 属性
    private EmployeeDAO employeeDAO=new EmployeeDAO();

    //根据uid 和 pwd 来返回一个Employee 对象
    //查询不到返回null
    public Employee getEmployee(String uid,String pwd){

        Employee employee =
                employeeDAO.querySingle("SELECT * FROM employee where uid=? and pwd=MD5(?)", Employee.class, uid, pwd);

        return employee;
    }

}
