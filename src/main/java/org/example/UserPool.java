package org.example;

public class UserPool {

    public static User getValidUser() {
        return new User("veseb50927@avzong.com", "exkuk^N60Sz$%PnS");
    }

    public static User getFalsePasswordUser() {
        return new User("veseb50927@avzong.com", "1111111111111111");
    }

    public static User getEmptyPasswordUser() {
        return new User("veseb50927@avzong.com", "");
    }
}
