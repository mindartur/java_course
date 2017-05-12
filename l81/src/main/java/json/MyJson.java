package json;

import com.google.gson.JsonObject;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * Created by artur on 10/05/17.
 */
public class MyJson {
    private JsonObjectBuilder tree;

    public MyJson(){
        tree = Json.createObjectBuilder();
    }

    private static void createJson(Object obj, JsonObjectBuilder curr) throws IllegalAccessException {

        if (obj == null) {
            return;
        }

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType().getName().equals("java.lang.String") || field.getType().getName().equals("int")) {
                curr.add(field.getName(), field.get(obj).toString());
            }
            else if (field.getType().getName().equals("Array")){
                JsonArrayBuilder next = Json.createArrayBuilder();
                curr.add(obj.toString(), next);
                createJson(field.get(obj), (JsonObjectBuilder) next);
            }
            else {
                JsonObjectBuilder next = Json.createObjectBuilder();
                curr.add(field.getName(), next);
                createJson(field.get(obj), next);
            }
        }
    }

    public String toString(Object obj) throws IllegalAccessException {
        createJson(obj, tree);
        return writeToString(tree.build());
    }

    private static String writeToString(javax.json.JsonObject jsonst) {
        StringWriter stWriter = new StringWriter();
        try (JsonWriter jsonWriter = Json.createWriter(stWriter)) {
            jsonWriter.writeObject(jsonst);
        }

        return stWriter.toString();
    }

    public static void writeToFile(String path, String json) throws IOException {
        //byte[] ser = serialize(json);
        try (FileOutputStream fos = new FileOutputStream(path)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(json);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readFromFile(String file) throws IOException, ClassNotFoundException {
        Object out;
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            out = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            out = null;
        }
        return out;
    }

}
