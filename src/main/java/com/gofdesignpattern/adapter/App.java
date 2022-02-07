package com.gofdesignpattern.adapter;

import com.gofdesignpattern.adapter.security.LoginHandler;
import com.gofdesignpattern.adapter.security.UserDetails;
import com.gofdesignpattern.adapter.security.UserDetailsService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler handler = new LoginHandler(userDetailsService);
        String login = handler.login("황남욱", "1234");
        System.out.println(login);
    }
}
