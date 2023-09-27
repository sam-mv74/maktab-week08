package ir.maktab101.hw08;

import ir.maktab101.hw08.menu.Menu;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        //show menu
        new Menu().mainMenu();
    }
}
