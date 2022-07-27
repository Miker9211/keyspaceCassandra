package com.demoach2.ach2.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserServiceTest {

    private final UserService userService;

    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void givenLdapClient_whenCorrectCredentials_thenSuccessfulLogin() {
        Boolean isValid = userService.authenticate("prodriguez", "itac1234!");

        assertEquals(true, isValid);
    }

}