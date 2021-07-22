package Sel;

import com.github.javafaker.Faker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FakerDemo {

    public static void main(String[] args) throws FileNotFoundException {

        Faker fakeData = new Faker();

        System.out.println(fakeData.internet().emailAddress());

        System.out.println(fakeData.business().creditCardNumber());
        System.out.println(fakeData.phoneNumber().cellPhone());

        System.out.println(fakeData.chuckNorris().fact());


        FileInputStream fis = new FileInputStream("src/doc.txt");
        // To get a path to a file that is not in project folder:
        // Right click on file -> Path from content root

    }
}