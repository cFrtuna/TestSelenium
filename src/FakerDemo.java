import com.github.javafaker.Faker;

import java.io.IOException;

public class FakerDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
//
        Faker fakeData = new Faker();
        System.out.println(fakeData.business().creditCardNumber());
    }
}

