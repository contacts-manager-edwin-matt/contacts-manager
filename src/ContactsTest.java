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

public class ContactsTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String directory = "data";
        String contacts = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path contactFile = Paths.get(directory, contacts);

        List<String> updatedList = new ArrayList<>();
        try {
            List<String> namesFromFile = Files.readAllLines(contactFile);
            for (String line: namesFromFile){
                String name = line.split(" ")[0];
                int number = Integer.parseInt(line.split(" ")[1]);
                System.out.println("name = " + name);
                System.out.println("number = " + number);
                Files.write(
                        Paths.get("data", "contacts.txt"),
                        Arrays.listOf("Mark"),
                        StandardOpenOption.APPEND
                );
            }
        }catch (IOException e) {
            e.printStackTrace();
    }
    }
}
