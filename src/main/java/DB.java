import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
  public DB() {



  }



  public static void main(String[] args) {
    MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://maks:777@hilodb-ejqv2.mongodb.net/test?retryWrites=true&w=majority");

    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("hilodb");


    // Make the logger a little more quiet
    Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
    mongoLogger.setLevel(Level.SEVERE);

    System.out.println("sdsds");

    for(String d : mongoClient.listDatabaseNames()){
      System.out.println(d);
    }

    for(String d : database.listCollectionNames()){
      System.out.println(d);
    }

//    for(String collectionName : database.listCollectionNames()) {
//      System.out.println(collectionName);
//    }
  }
}
