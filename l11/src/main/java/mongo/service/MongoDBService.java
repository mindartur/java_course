package mongo.service;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

/**
 * Created by artur on 15/05/17.
 */
public class MongoDBService implements DatabaseService {

    private MongoClient mongo;
    private MongoDatabase mongoDatabase;

    @Override
    public void initialize(String host, Integer port, String dbName) {
        mongo = new MongoClient(host, port);
        mongoDatabase = mongo.getDatabase(dbName);
    }

    @Override
    public String insert(String collectionName, Document doc) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName); //create if not exist
        collection.insertOne(doc);
        return doc.get("_id").toString();
    }

    @Override
    public void listDatabaseNames() {
        MongoIterable<String> dbs = mongo.listDatabaseNames();
        System.out.println("\nDatabase names:");
        for (String db : dbs) {
            System.out.println(db);
        }
    }

    @Override
    public ArrayList<Document> findById(String collectionName, String id){
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("_id", new ObjectId(id));
        FindIterable<Document> iterableID = collection.find(searchQuery);

        ArrayList<Document> res = new ArrayList<Document>();

        for (Document document : iterableID){
            res.add(document);
        }
        return res;
    }

    public ArrayList<Document> findCustom(String collectionName, Document query){
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        BasicDBObject searchQuery = new BasicDBObject();

        for (Object key : query.keySet()){
            searchQuery.put((String) key, query.get(key));
        }

        FindIterable<Document> iterableID = collection.find(searchQuery);

        ArrayList<Document> res = new ArrayList<Document>();

        for (Document document : iterableID){
            res.add(document);
        }
        return res;
    }

}
