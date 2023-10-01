package org.example;

import org.example.AccountType;
import org.example.NotValidMailException;
import org.example.User;
import org.example.UsersService;
import org.junit.jupiter.api.Nested;
import org.mockito.Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class UsersServiceTest {


    private UsersService usersService;

    @BeforeEach
    public void setUp() {

         usersService = new UsersService();



    }
    @Test
    void loginValid() throws NotValidMailException {

        assertTrue(usersService.Login("user1@gmail.com","12345678"));
    }
    @Test
    void loginInValid() throws NotValidMailException {

        assertFalse(usersService.Login("user2@gmail.com","12345678"));
    }


    @Test
      void signUpValid() throws NotValidMailException {
        /*ArrayList<User> mockList = Mockito.mock(ArrayList.class);
        mockList.add(new User("user1@gmail.com","12345678"));
        mockList.add(new User("user2@gmail.com","12345678"));
        mockList.add(new User("user3@gmail.com","12345678"));
        */


       /* Mockito.when(mockList.size()).thenReturn(4);
        usersService.setUsers(mockList);*/
        usersService.SignUp("user4@gmail.com", "12345678");
        assertEquals(2, usersService.users.size());


    }
    @Test
    void signUpNotValid() throws NotValidMailException {


        assertThrows(NotValidMailException.class,()-> usersService.SignUp("wad","12345678"),
                "Email is not valid");
    }
    @Test
    void addNewAccount(){

        User user = usersService.getUsers().get(0);
        user.openNewAccount(AccountType.CURRENT,1000);
        assertEquals(3,user.getUserAccounts().size());
    }
    @Nested
    class withDraw {
        @Test
        void withDrawValid() throws NoAvailableBlance, CannotFindAccount {
            assertEquals(100,usersService.withDraw(usersService.getUsers().get(0),1,100 ));
        }

        @Test
        void withDrawInvalid() throws NoAvailableBlance, CannotFindAccount {
        assertThrows(NoAvailableBlance.class,()->usersService.withDraw(usersService.getUsers().get(0),1,300 ));
        }

        @Test
        void withDrawAccountNotFound() {
            assertThrows(CannotFindAccount.class,()->usersService.withDraw(usersService.getUsers().get(0),5,300 ));
        }
    }
    @Nested
    class deposit {
        @Test
        void depositValid() throws CannotFindAccount {
            assertEquals(300,usersService.deposit(usersService.getUsers().get(0),1,100 ));
        }

        @Test
        void DepositAccountNotFound() {
            assertThrows(CannotFindAccount.class,()->usersService.deposit(usersService.getUsers().get(0),9,300 ));
        }
    }
}