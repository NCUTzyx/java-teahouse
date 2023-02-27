package com.zyx.susan.Service;

import com.zyx.susan.DAO.MenuDAO;
import com.zyx.susan.Domain.Menu;

import java.util.List;

/**
 * @author 张宇森
 * @version 1.0
 * 对Menu表 的操作（调用MenuDAO）
 */
public class MenuService {

    private MenuDAO menuDAO = new MenuDAO();

    //返回所有菜品
    public List<Menu> list(){

        return menuDAO.queryMultiply("SELECT * FROM Menu", Menu.class);
    }

    //根据id 返回Menu对象
    public Menu getMenu(int id){
        return menuDAO.querySingle("SELECT * FROM Menu where fid=?",Menu.class,id);
    }
}
