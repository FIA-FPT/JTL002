package edu.fpt.AI1501.View;

import java.util.Scanner;

import edu.fpt.AI1501.DAO.UserList;
import edu.fpt.AI1501.Utils.EssentialUtils;


public class InputUtils {
    static Scanner sc = new Scanner(System.in);

    public static String inputUser(boolean isReturnNullAllowed) {
        while (true) {            
            sc = new Scanner(System.in);
            System.out.print("Input Username:  ");
            String username = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(username);
            if(isReturnNullAllowed && isNull){
                return null;
            }
            if(!isNull){
                return username;
            }
            System.out.println("Username cannot be null!");
        }
    }


    public static String inputEmail(boolean isReturnNullAllowed){
        while(true){
            sc = new Scanner(System.in);
            String email = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(email);
            boolean isEmailValid = EssentialUtils.isEmailValid(email);
            if(isReturnNullAllowed && isNull){
                return null;
            }
            if(!isNull && isEmailValid){
                return email;
            } else{
                System.out.println("Email Format isnt valid!");
            }

        }
    }

    public static String inputPassword(boolean isNullAllowed, boolean isRegister){
        while(true){
            sc = new Scanner(System.in);
            System.out.print("Input password: ");
            String password = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(password);
            boolean isPasswordValid = EssentialUtils.isPasswordValid(password);
            if(isNullAllowed && isNull){
                return null;
            }
            if(!isNull && isPasswordValid && isRegister){
                if(confirmPassword(password)){
                    return EssentialUtils.encryptMessage(password);
                }
            }
            if(!isNull && isPasswordValid){
                return EssentialUtils.encryptMessage(password);
            }
            System.out.println("Password Format Incorrect! Must be above 8");
            
        }
    }

    public static boolean confirmPassword(String srcPassword){
        while(true){
            sc = new Scanner(System.in);
            String conPassword = sc.nextLine();
            System.out.print("Enter the typed password");
            if(conPassword.equals(srcPassword)){
                return true;
            } else{
                System.out.println("Try Again!");
            }
            
        }
    }

    public static String inputPhoneNumber(boolean isNullAllowed){
        while(true){
            sc = new Scanner(System.in);
            System.out.print("Enter phone number:  ");
            String phoneNumber = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(phoneNumber);
            boolean isPhoneNumberValid = EssentialUtils.isPhoneNumberValid(phoneNumber);
            if(isNullAllowed && isNull){
                return null;
            }
            if(!isNull && isPhoneNumberValid){
                return phoneNumber;
            }
            System.out.println("Phone Number Format Invalid!");
        }
    }


    public static String inputLastName(boolean isNullAllowed){
        while(true){
            sc = new Scanner(System.in);
            System.out.print("Enter First Name:  ");
            String lastName = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(lastName);
            if(isNull && isNullAllowed){
                return null;
            }
            if(!isNull){
                return EssentialUtils.capitalizeName(lastName);
            }
            System.out.println("Last Name cannot be empty!");
        }
    }

    public static String inputFirstName(boolean isNullAllowed){
        while(true){
            sc = new Scanner(System.in);
            System.out.print("Enter First Name:  ");
            String firstName = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(firstName);
            if(isNull && isNullAllowed){
                return null;
            }
            if(!isNull){
                return EssentialUtils.capitalizeName(firstName);
            }
            System.out.println("First Name cannot be empty!");
        }
    }

    public static boolean loginUser(UserList list){
        sc = new Scanner(System.in);
        System.out.print("Input user:  ");
        String username = inputUser(true);
        String password = inputPassword(true,false);
        Integer posId = list.search(username);
        if(posId == -1){
            System.out.println("No Username Exist Or Incorrect Password!");
            return false;
        }
        
        if(password.equals(list.get(posId).getPassword())){
            return true;
        } else{
            System.out.println("No Username Exist Or Incorrect Password!");
            return false;
        }

        

    }
}