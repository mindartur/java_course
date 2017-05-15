package mongo.service;

import org.bson.Document;

/**
 * Created by artur on 15/05/17.
 */
public class Main {

    public static void main(String[] args){
        MongoDBService db = new MongoDBService();
        db.initialize("localhost", 27017, "testJavaMongo");
        db.insert("users", new Document("name", "Tully").append("company", "Umbrella INC"));
        String id = db.insert("users", new Document("name", "Artur").append("company", "Space"));
        System.out.println(id);
        db.insert("users", new Document("name", "Vova").append("company", "Space"));
        System.out.println("By id: " + db.findById("users", id));
        System.out.println("By custom query: " + db.findCustom("users", new Document("name", "Vova")
                .append("company", "Space")));

        db.listDatabaseNames();

    }
}
