package com.zyx.susan.View;

import com.zyx.susan.Domain.*;
import com.zyx.susan.Service.BillService;
import com.zyx.susan.Service.EatTableService;
import com.zyx.susan.Service.EmployeeService;
import com.zyx.susan.Service.MenuService;
import com.zyx.susan.utils.Utility;

import java.util.List;

/**
 * @author 张宇森
 * @version 1.0
 * 鸡坤茶室界面
 */
public class SusanView {

    public static void main(String[] args) {
        new SusanView().ViewMenu();
    }

    //控制退出菜单
    private boolean loop = true;
    //控制退出二级菜单
    private boolean lip = true;
    //接收用户的输入
    private String op;
    //定义EmployeeService 的属性
    private EmployeeService employeeService = new EmployeeService();
    //定义EatTableService 的属性
    private EatTableService eatTableService = new EatTableService();
    //定义MenuService 的属性
    private MenuService menuService = new MenuService();
    //定义BillService 的属性
    private BillService billService = new BillService();


    //主菜单
    public void ViewMenu() {

        while (loop) {
            System.out.println("==========鸡坤茶室==========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 2 退出系统");
            System.out.print("请输入你的选择: ");
            op = Utility.readString(1);

            switch (op) {
                case "1":

                    System.out.print("请输入账 号: ");
                    String uid = Utility.readString(12);
                    System.out.print("请输入密 码: ");
                    String pwd = Utility.readString(15);
                    //到数据库判断
                    Employee employee = employeeService.getEmployee(uid, pwd);

                    if (employee != null) {  //说明存在
                        System.out.println(employee.getNAME() + "登录鸡坤茶室成功！");
                        //二级菜单
                        new SusanView().TwoMenu();
                    } else {
                        System.out.println("登录失败");
                    }

                    break;
                case "2":
                    System.out.println("退出成功！");
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误, 请重试!");
            }
        }
    }

    //二级菜单
    public void TwoMenu() {

        while (lip) {
            System.out.println("==========欢迎来到鸡坤茶室系统==========");
            System.out.println("\t\t 1 预览茶室位置");
            System.out.println("\t\t 2 预定茶室位置");
            System.out.println("\t\t 3 显示鲲鲲菜品");
            System.out.println("\t\t 4 进行点餐服务");
            System.out.println("\t\t 5 查看鲲室账单");
            System.out.println("\t\t 6 支付鲲室账单");
            System.out.println("\t\t 0 返回登录界面");
            System.out.print("请输入你的选择: ");
            op = Utility.readString(1);

            switch (op) {
                case "1":
                    //预览茶室位置方法
                    previewTable();
                    break;
                case "2":
                    //预定茶室位置方法
                    orderEatTable();
                    break;
                case "3":
                    //返回所有菜品
                    foodMenu();
                    break;
                case "4":
                    //进行点餐服务
                    OrderMeal();
                    break;
                case "5":
                    //查看鲲室账单
                    lookBill();
                    break;
                case "6":
                    //支付鲲室账单
                    payBill();
                    break;
                case "0":
                    lip = false;
                    System.out.println("返回主菜单成功");
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }

    //预览茶室位置方法
    public void previewTable() {
        System.out.println("==========鸡坤茶室营业信息==========");
        List<EatTable> list = eatTableService.list();
        System.out.println("\n鲲室号\t鲲室状态");
        for (EatTable eatTable : list) {
            System.out.println(eatTable.getId() + "\t\t  " + eatTable.getState());
        }
        System.out.println("==========营业信息显示完毕==========\n");
    }

    //预定茶室位置方法
    public void orderEatTable() {
        System.out.println("==========预定鲲室==========");
        System.out.print("请选择要预定鲲室的房间号(-1:退出预定):");
        int op = Utility.readInt();
        if (op == -1) {
            System.out.println("取消预定鲲室");
            return;
        }
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            //确认预定茶室
            EatTable eatTable = eatTableService.getEatTable(op);
            //茶室号不存在
            if (eatTable == null) {
                System.out.println("该鲲室不存在");
                return;
            }
            //判断茶室状态是否为"空"
            if (!("空".equals(eatTable.getState()))) {
                //当前餐桌不为空
                System.out.println("该鲲室已被预定");
                return;
            }
            //剩下的为空茶室，接收信息
            System.out.print("请输入你的名字: ");
            String name = Utility.readString(50);
            System.out.print("请输入你的电话: ");
            String number = Utility.readString(50);

            //更新状态
            boolean b = eatTableService.preEatTable(op, name, number);
            if (b) {
                System.out.println("==========该鲲室预定成功==========\n");
            } else {
                System.out.println("预定失败，请重试！");
            }

        } else {
            System.out.println("取消预定鲲室");
        }
    }

    //返回所有菜品
    public void foodMenu() {
        System.out.println("==========鸡坤茶室菜品信息==========");
        List<Menu> list = menuService.list();
        System.out.println("\n菜品编号\t\t菜品名\t\t类型\t\t价格");
        for (Menu menu : list) {

            System.out.println(menu);
        }
        System.out.println("==========菜品信息显示完毕==========\n");
    }
    //进行点餐服务
    public void OrderMeal(){
        System.out.println("==========点餐服务==========");
        System.out.print("请输入您要点餐的鲲室号(-1退出): ");
        int eatTableId = Utility.readInt();
        if(eatTableId==-1){
            System.out.println("取消点餐成功！");
            return;
        }
        System.out.print("请输入您要点餐的菜品号(-1退出): ");
        int meid = Utility.readInt();
        if(meid==-1){
            System.out.println("取消点餐成功！");
            return;
        }
        System.out.print("请输入您要点餐的菜品量(-1退出): ");
        int nums = Utility.readInt();
        if(nums==-1){
            System.out.println("取消点餐成功！");
            return;
        }
        //验证茶室号是否存在
        EatTable eatTable = eatTableService.getEatTable(eatTableId);
        if(eatTable==null){
            System.out.println("鲲室号不存在，请重试！");
            return;
        }
        //菜品号是否存在
        Menu menu = menuService.getMenu(meid);
        if(menu==null){
            System.out.println("菜品号不存在，请重试！");
            return;
        }
        //点餐
        boolean b = billService.OrderFood(meid, nums, eatTableId);
        if (b){
            System.out.println("==========点餐成功==========\n");
        }else{
            System.out.println("点餐失败");
        }
    }

    //查看鲲室账单
    public void lookBill(){
        System.out.println("==========查看账单==========");
        System.out.print("请选择你要查看账单的鲲室号: ");
        int eatTableId = Utility.readInt();
        if(eatTableId==-1){
            System.out.println("取消查看账单成功！");
            return;
        }
        //验证茶室号是否存在
        EatTable eatTable = eatTableService.getEatTable(eatTableId);
        if(eatTable==null){
            System.out.println("鲲室号不存在，请重试！");
            return;
        }
//        List<Bill> list = billService.list(eatTableId);
//        System.out.print("\n==========该鲲室账单==========");
//        System.out.println("\n账单号\t\t菜品号\t\t菜品量\t\t金额\t\t鲲室号\t\t\t日期\t\t\t\t\t\t\t状态");
//        for (Bill bill : list) {
//            System.out.println(bill);
//        }
        List<MultiTable> multiTables = billService.list2(eatTableId);
        System.out.print("\n==========该鲲室账单==========");
        System.out.println("\n账单号\t\t菜品号\t\t菜品量\t\t金额\t\t鲲室号\t\t\t日期\t\t\t\t\t\t\t状态\t\t菜品名");
        for (MultiTable multiTable : multiTables) {
            System.out.println(multiTable);
        }
        System.out.println("==========该鲲室账单显示完毕==========\n");
    }

    //支付鲲室账单
    public void payBill(){
        System.out.println("\n==========支付界面==========");
        System.out.print("请选择你要支付账单的鲲室号(-1退出): ");
        int eatTableId = Utility.readInt();
        if(eatTableId==-1){
            System.out.println("取消支付账单成功！");
            return;
        }
        //验证账单是否存在
        //验证茶室号是否存在
        EatTable eatTable = eatTableService.getEatTable(eatTableId);
        if(eatTable==null){
            System.out.println("鲲室号不存在，请重试！");
            return;
        }
        //验证鲲室是否有需要支付的账单
        boolean b = billService.hasPay(eatTableId);
        if (!b){
            System.out.println("该鲲室没有要支付的账单");
            return;
        }
        System.out.print("结账方式(现金/支付宝/微信):");
        String pay = Utility.readString(20,"");
        if ("".equals(pay)){
            System.out.println("取消支付账单成功！");
            return;
        }
        char c = Utility.readConfirmSelection();
        if (c=='Y'){
            //结账
            boolean b1 = billService.payBill_(eatTableId, pay);
            if (b1){
                System.out.println("==========该鲲室支付账单成功==========\n");
            }else {
                System.out.println("支付账单失败！");
            }
        }else{
            System.out.println("取消支付账单成功！");
        }
    }
}
