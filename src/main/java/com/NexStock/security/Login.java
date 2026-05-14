package security;
import java.util.*;
import model.UserManager;
import model.User;

public class Login {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();

        System.out.print("Enter Username: ");
        String enteredUsername = sc.nextLine();

        User foundUser = manager.findByUsername(enteredUsername);

        if (foundUser == null) {
            System.out.println("Username not found!");
            return;
        }

        int attempts = 0;
        System.out.println("Enter Password:");

        while (attempts < 5) {
            String userinput = sc.nextLine();

            if (foundUser.verifyPassword(userinput)) {
                System.out.println("Welcome " + foundUser.getUserName());
                break;
            } else {
                System.out.println("Incorrect! Try Again");
                if (attempts == 4) {
                    long locktime = System.currentTimeMillis();
                    while (System.currentTimeMillis() - locktime < 10000) {
                        long remaining = 10 - (System.currentTimeMillis() - locktime) / 1000;
                        System.out.println("Waiting for " + remaining + " seconds....");
                        Thread.sleep(1000);
                    }
                    System.out.println("Now Enter Again:");
                    attempts = 0;
                }
                attempts++;
            }
        }
    }
}