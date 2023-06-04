package handlers;

import org.example.models.Actor;

import java.util.Scanner;

public class UserInputHandler {
    private static Scanner scanner = new Scanner(System.in);
    public static MenuOptions getMenuOptionFromUser()
    {
        return MenuOptions.values()[getSelectedOptionFromUser()-1];//-1 ujednolica indeksy zeby było od 0?
    }

    private static int getSelectedOptionFromUser() {
        var result = getIntegerFromUser();
        scanner.nextLine();

        if (result >0 && result <MenuOptions.values().length +1)
        {
            return result;
        }

        else
        {
            System.out.println("You selected non existing option: " + result);
            System.out.println("Please try again");
            return getSelectedOptionFromUser();
        }
    }

    private static int getIntegerFromUser() {
        while(!scanner.hasNext())
        {
            scanner.nextLine();
            System.out.println("It is not integer, try again");
        }
        return scanner.nextInt();
    }

    public static Actor getActorFromUser(){
        System.out.println("Enter Actor name");
        var s = scanner.nextLine().split(" ");

        return new Actor(s[0],s[1]);

    }

}
