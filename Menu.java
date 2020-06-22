package edu.psu.abington.ist.ist242;

import java.util.ArrayList;

public class Menu {

    //Class Level Variables - Protect the data
    private int menuId;
    private String menuItem;
    private String menuDesc;

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    //Constructor Method
    public Menu(int _menuId, String _menuItem, double price, String menuDesc){
        this.menuId = _menuId;
        this.menuItem = _menuItem;
        this.menuDesc = menuDesc;
    }

    //Setters and Getters
    public int getmenuId() { return menuId; }
    public void setmenuId(int _menuId) {this.menuId = _menuId;}

    public String getmenuItem() { return menuItem; }
    public void setmenuItem(String _menuItem) {this.menuItem = _menuItem;}

    public static void listMenu(ArrayList<Menu> mList){             //changed
        for (Menu menu: mList){
            System.out.println(menu.getMenuDesc());
        }
    }
}
