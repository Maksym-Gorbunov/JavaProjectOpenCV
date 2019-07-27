package com.db;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Arrays.asList;

public class DB {
  static MongoClient mongoClient;
  static MongoDatabase database;

  static {
    MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://maks:777@hilodb-ejqv2.mongodb.net/test?retryWrites=true&w=majority");
    mongoClient = new MongoClient(uri);
    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
    mongoLogger.setLevel(Level.SEVERE);
    database = mongoClient.getDatabase("hilodb");
  }


  public static void populateContactBook() {
//    printContacts();
//    createCollection("Contacts");
      deleteCollection("Contacts");
//    for (String collectionName : database.listCollectionNames()) {
//      System.out.println(collectionName);
//    }
  }


  static void printContacts() {
    MongoCollection<Document> collection = database.getCollection("questions");
    List<Document> result = collection.find().into(new ArrayList<>());
    result.stream().map(Document::toJson).forEach(System.out::println);
    /* OLD Style Java:
    for (Document doc : result) {
      System.out.println(doc.toJson());
    }
    */
  }

  // Create collection
  static void createCollection(String collectionName) {
    MongoCollection<Document> collection = database.getCollection(collectionName);
    collection.insertOne(new Document());
  }

  // Delete collection
  static void deleteCollection(String collectionName) {
    MongoCollection<Document> collection = database.getCollection(collectionName);
    collection.drop();
//    collection = database.getCollection(collectionName);
  }










  // This method lists all databases
  static void listDatabases() {
    System.out.println("===================================");
    System.out.println("names of all databases:");
    //show databases:
    mongoClient.getDatabaseNames().forEach(System.out::println);
  }

  // This method lists all collection names in the current database:
  static void listCollectionNames() {
    for(String collectionName : database.listCollectionNames()) {
      System.out.println(collectionName);
    }
  }





  static void hr() {
    System.out.println("===================================");
  }

  static void createAndInsertCustomers() {
    MongoCollection<Document> collection = database.getCollection("customers");
    List<Document> document = asList(
            new Document ("name", "Eva")
                    .append("email", "eva@email.com")
                    .append("customerId", 100),

            new Document("name", "Patrik")
                    .append("email","patrik@email.com")
                    .append("customerId", 101));
    collection.insertMany(document);
  }



  static void findAndPrintEva() {
    MongoCollection<Document> collection = database.getCollection("customers");
    List<Document> result = collection.find(new Document("name", "Eva")).into(new ArrayList<>());
    System.out.println(result);
  }

  static void updateEva() {
    MongoCollection<Document> collection = database.getCollection("customers");
    BasicDBObject newDocument = new BasicDBObject();
    newDocument.append("$set", new BasicDBObject().append("email", "eva@mail.org"));
    BasicDBObject query = new BasicDBObject().append("name","Eva");
    collection.updateOne(query, newDocument);
  }

  static void updatePatrik() {
    MongoCollection<Document> collection = database.getCollection("customers");
    BasicDBObject updateQuery = new BasicDBObject();
    updateQuery.append("$inc", new BasicDBObject().append("customerId", 10));
    BasicDBObject searchQuery = new BasicDBObject().append("name","Patrik");
    collection.updateOne(searchQuery, updateQuery);
  }

}