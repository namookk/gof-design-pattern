package com.gofdesignpattern.adapter;

import com.gofdesignpattern.adapter.security.UserDetails;
import com.gofdesignpattern.adapter.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {

    private final AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
