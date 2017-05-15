package mongo.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

/**
 * Created by artur on 15/05/17.
 */
public interface DatabaseService {

    public void initialize(String host, Integer port, String dbName);
    public String insert(String collectionName, Document doc);
    public void listDatabaseNames();
    public ArrayList<Document> findById(String collectionName, String id);
    public ArrayList<Document> findCustom(String collectionName, Document query);

}
