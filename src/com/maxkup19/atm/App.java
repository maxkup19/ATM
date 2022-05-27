package com.maxkup19.atm;

import com.maxkup19.atm.domain.OptionMenu;

import java.io.IOException;

public class App extends OptionMenu{
    public static void main(String[] args) throws IOException {
        OptionMenu optionMenu = new OptionMenu();
        optionMenu.getLogin();
    }
}
