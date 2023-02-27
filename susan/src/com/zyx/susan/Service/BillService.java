package com.zyx.susan.Service;

import com.zyx.susan.DAO.BillDAO;
import com.zyx.susan.DAO.MultiTableDAO;
import com.zyx.susan.Domain.Bill;
import com.zyx.susan.Domain.MultiTable;

import java.util.List;
import java.util.UUID;

/**
 * @author 张宇森
 * @version 1.0
     * 对Bill表 的操作（调用BillDAO）
 */
public class BillService {

    private BillDAO billDAO = new BillDAO();
    //定义MenuService属性
    private MenuService menuService = new MenuService();
    //定义EatTableService属性
    private EatTableService eatTableService = new EatTableService();
    //定义MultiTableDAO属性
    private MultiTableDAO multiTableDAO = new MultiTableDAO();


    //点餐方法
    //1.生成账单
    //2.更新对应茶室的状态
    public boolean OrderFood(int meid,int nums,int eatTableId){
        //生成一个账单号
        String bid = UUID.randomUUID().toString();
        //将账单生成到Bill表
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未支付')", bid, meid, nums,
                menuService.getMenu(meid).getPrice() * nums, eatTableId);
        if (update<=0){
            return false;
        }
        //更新状态
        return eatTableService.updateState(eatTableId,"就餐中");
    }

    //查看账单信息

    public List<Bill> list(int eatTableId){
        return billDAO.queryMultiply("SELECT * FROM bill where eatTableId=?",Bill.class,eatTableId);
    }

    public List<MultiTable> list2(int eatTableId){
        return multiTableDAO.queryMultiply("SELECT Bill.*, fname  FROM Bill,menu WHERE Bill.meid=menu.fid AND eatTableId = ?",MultiTable.class,eatTableId);
    }

    //查看某个餐桌是否有未结账的菜单
    public boolean hasPay(int eatTableId){

        Bill bill = billDAO.querySingle
                ("SELECT * FROM Bill WHERE eatTableId=? AND state ='未支付' LIMIT 0,1", Bill.class, eatTableId);
        return  bill !=null;
    }

    //支付账单
    //1.鲲室存在
    //2.有未支付的账单
    public boolean payBill_(int  eatTableId,String state){

        //1.修改bill 表
        int update = billDAO.update
                ("Update Bill set state=? where eatTableId=? and state='未支付'", state, eatTableId);
        if(update<=0){
            return false;
        }
        //2.修改EatTable 表
        boolean k = eatTableService.FreeState(eatTableId, "空闲");
        if(!k){
            return false;
        }
        return true;
    }

}
