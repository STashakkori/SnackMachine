import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;

/**
 * Created by rt on 4/22/14.
 */
public class SnackMachineModel implements Model {

    HashMap<String, ArrayList<String>> snackmap;
    MongoClient mongoClient;

    public SnackMachineModel() throws UnknownHostException {

        mongoClient= new MongoClient();
        DB db = mongoClient.getDB("local");
        System.out.println("Mongo Connection Successful");

    }

    public void registerModel(Model m){

    }

    public void unregisterModel(Model m){

    }

    public void notifyModel(){

    }

    public void closeConnection(){
        mongoClient.close();
    }
}
