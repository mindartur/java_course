package json;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by artur on 10/05/17.
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, IOException, ClassNotFoundException {
        MySimpleClass testClass = new MySimpleClass(1, "test string");
        MySimpleClass testClass2 = new MySimpleClass(2, "test string 2");
        testClass.setNext(testClass2);

        Gson gson = new Gson();
        String json = gson.toJson(testClass);
        System.out.println("gson: " + json);

        MyJson myJson = new MyJson();
        String stringJson = myJson.toString(testClass);
        System.out.println("MyJson: " + stringJson);

        MyJson.writeToFile("test.txt", stringJson);

        String out = (String) MyJson.readFromFile("test.txt");
        System.out.println("From file: " + out);

    }

}
