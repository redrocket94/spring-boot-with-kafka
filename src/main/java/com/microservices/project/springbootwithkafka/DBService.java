package com.microservices.project.springbootwithkafka;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DBService {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> mongoCollection;

    public DBService() {
        this.mongoClient = new MongoClient();
        this.database = mongoClient.getDatabase("accounting_db");
        this.mongoCollection = database.getCollection("accounts");
    }

    public void addEntry(String entry) {
        mongoCollection.insertOne(new Document("message", entry));
    }
}
