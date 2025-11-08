package com.mamajulit;

import com.mamajulit.View.Auth.LoginView;
import com.mamajulit.Controller.Auth.LoginController;

public class App {
    public static void main(String[] args) {
        LoginView view = new LoginView();
        new LoginController(view);
    }
}
