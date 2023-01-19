package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Util.getConnection();
        // реализуйте алгоритм здесь
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserServiceImpl();
        while (true){
            crudMethod();
            System.out.print("Write command:");
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    userService.createUsersTable();
                    System.out.println();
                    break;
                case 2:
                    userService.dropUsersTable();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Write UserName:");
                    String userName = new Scanner(System.in).nextLine();
                    System.out.print("Write UserLastName:");
                    String userLastName = new Scanner(System.in).nextLine();
                    System.out.print("Write UserAge:");
                    byte userAge = scanner.nextByte();
                    userService.saveUser(userName,userLastName,userAge);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("write user id:");
                    long userId = scanner.nextLong();
                    userService.removeUserById(userId);
                    System.out.println();
                    break;
                case 5:
                    userService.cleanUsersTable();
                    System.out.println();
                    break;
            }
        }
    }



    public static  void  crudMethod(){
        System.out.println("---CRUD METHODS---\n" +
                "1-button-CREATE TABLE\n" +
                "2-button-DROP TABLE\n" +
                "3-button-SAVE USER\n" +
                "4-button-REMOVE USER BY ID\n" +
                "5-button-CLEAN USER TABLE\n");
    }
}
