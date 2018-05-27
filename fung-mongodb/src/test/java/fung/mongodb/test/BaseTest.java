package fung.mongodb.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;

public class BaseTest {

    private MyMongoClient myMongoClient = MyMongoClient.createClient("127.0.0.1", 27017)
            .useDatabase("test").useCollection("user");

    @Test
    public void testHello() {
        System.out.println("Hello MongoDB");
    }

    @Test
    public void testFind() {

        try(MongoCursor<Document> cursor = myMongoClient.find()) {

            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFilter() {
        try(MongoCursor<Document> cursor = myMongoClient.find(Filters.eq("name", "fung"))) {

            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyMongoClient {

        private MongoClient mongoClient;
        private String database;
        private String collection;

        private MyMongoClient(MongoClient mongoClient) {
            this.mongoClient = mongoClient;
        }

        static MyMongoClient createClient(String host, int port) {
            return new MyMongoClient(new MongoClient(host, port));
        }

        MyMongoClient useDatabase(String database) {
            this.database = database;
            return this;
        }

        MyMongoClient useCollection(String collection) {
            this.collection = collection;
            return this;
        }

        MongoCursor<Document> find() {
            return mongoClient.getDatabase(database)
                    .getCollection(collection).find().iterator();
        }

        MongoCursor<Document> find(Bson filter) {
            return mongoClient.getDatabase(database)
                    .getCollection(collection).find(filter).iterator();
        }

    }

}
