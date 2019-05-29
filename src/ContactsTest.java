//package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import util.Input;

public class ContactsTest {
    static Input input = new Input();

    static String namessFromFile () {
        String directory = "data";

        Path file = Paths.get(directory, "contacts.txt");

        try {
            List<String> namesFromFile = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ;
    }

    public static void main(String[] args) {
        boolean keepGoing;
        Scanner scan = new Scanner(System.in);

        String directory = "data";

        Path folder = Paths.get(directory);
        Path file = Paths.get(directory, "contacts.txt");

        if(Files.notExists(folder)){
            try {
                Files.createDirectories(folder);
                System.out.println(folder + " was created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!Files.exists(file)){
            try {
                Files.createFile(file);
                System.out.println(file + " file was created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        do {
            System.out.println("1 - View contacts\n" +
                    "2 - Add a new contact\n" +
                    "3 - Search contact by name\n" +
                    "4 - Delete an existing contact\n" +
                    "Enter an option (1, 2, 3, or 4)");

            int userAnswer = input.getInt(1, 4);

            switch (userAnswer) {
                case 1:
//                    List<String> updatedList = new ArrayList<>();
                    try {
                        System.out.println("Name " + " | " + " Phone number");
                        System.out.println("----------------------------");
                        for (String line : namessFromFile) {
                            String name = line.split(" ")[0];
                            int number = Integer.parseInt(line.split(" ")[1]);
                            System.out.println(name + " | " + number);
                        }
                        Files.write(file, updatedList);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
//                    System.out.println("Add a name: ");
//                    String inputName = scan.nextLine();
//                    System.out.println("Add a number: ");
//                    int inputNumber = scan.nextInt();
//                    Files.write(
//                            Paths.get("data", "contacts.txt"),
//                            updatedList.add(inputName + inputNumber),
//                            StandardOpenOption.APPEND
//                    );
                    break;
                case 3:
//                    System.out.println("Give me a name");
//                    String giveName = scan.nextLine();
//                    if (giveName.equalsIgnoreCase()) {
//                        System.out.println(giveName);
//                    }
                    break;
                case 4:
//                    System.out.println("Delete contact: Enter name");
//                    String deleteName = scan.nextLine();
//                    List<String> namesFromFile = Files.readAllLines(file);
//                    for (String line : namesFromFile) {
//                        if(line.equals(deleteName)) {
//                            updatedList.remove(deleteName);
//                        }
//                    }
                    break;
                default:
                    System.err.println("Enter a correct option");
            }
            System.out.println("Would you like to continue using the contact manager?");
            keepGoing = input.yesNo();
        } while (keepGoing);
    }
}