package com.zyx.susan.Service;

import com.zyx.susan.DAO.EatTableDAO;
import com.zyx.susan.Domain.EatTable;

import java.util.List;

/**
 * @author 张宇森
 * @version 1.0
 * 对EatTable表 的操作（调用EatTableDAO）
 */
public class EatTableService {

    private EatTableDAO  eatTableDAO = new EatTableDAO();

    //显示茶室营业状态
    public List<EatTable> list(){

        return eatTableDAO.queryMultiply("SELECT id,state FROM EatTable", EatTable.class);
    }

    //根据桌子号查询对应的茶桌 EatTable 对象
    //如果返回null,表示餐桌不存在
    public EatTable getEatTable(int id){

        return eatTableDAO.querySingle("SELECT * FROM EatTable where id=?",EatTable.class,id);
    }

    //如果可以预定，预定信息、
    public boolean preEatTable(int id,String Eatname,String Eattel){

        int update =
                eatTableDAO.update("update EatTable set state='已预定',Eatname=?,Eattel=? where id=?", Eatname, Eattel,id);

        return update>0;
    }

    //更新茶室状态
    public boolean updateState(int id,String state){

        int update = eatTableDAO.update("update EatTable set state=? where id=?", state, id);
        return update>0;

    }
    //指定茶室转为空闲状态
    public boolean FreeState(int id,String state){

        int update = eatTableDAO.update("update EatTable set state=?,Eatname='',Eattel=''where id=?", state, id);
        return update>0;
    }

}
