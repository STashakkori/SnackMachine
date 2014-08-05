import java.net.UnknownHostException;
import java.util.*;

import com.mongodb.*;
import com.sun.javafx.collections.MappingChange;
import org.bson.types.ObjectId;
import javax.swing.text.Document;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by rt on 4/22/14.
 */
public class SnackMachineModel implements Model {

    HashMap<String, ArrayList<String>> snackmap;
    MongoClient mongoClient;

    public SnackMachineModel() throws UnknownHostException {
        mongoClient = new MongoClient();
        System.out.println("Mongo Connection Successful");
    }

    /*

     */
    public void migrateDB(){
        DB db = mongoClient.getDB("snackmachine");
        System.out.println("Migrating Product collection....");
        DBCollection productTable = db.getCollection("product");
        System.out.println(productTable.count() + " documents migrated");
    }

    public void removeItem(String name){
        DB db = mongoClient.getDB("snackmachine");
        DBCollection productTable = db.getCollection("product");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", name);
        productTable.remove(productTable.findOne(searchQuery));

        /*
        while(cursor.hasNext()){
            if(cursor.next().get(""))
            productTable.remove(cursor.next());
        }*/
    }

    public HashMap<String,Integer> countItems(String[] itemNames){
        System.out.println("Counting snacks...");
        HashMap<String, Integer> itemCountMap = new HashMap<String, Integer>();
        DB db = mongoClient.getDB("snackmachine");
        DBCollection productTable = db.getCollection("product");
        BasicDBObject searchQuery = new BasicDBObject();
        for(int i = 0; i < itemNames.length; i++){
            searchQuery.put("name", itemNames[i]);
            Integer count = (int)productTable.count(searchQuery);
            itemCountMap.put(itemNames[i],count);
            System.out.println(count + " " + itemNames[i] + " counted.");
        }
        return itemCountMap;
    }

    public void stockDB(){

        int STOCKNUMBER = 5;
        for(int i = 0; i < STOCKNUMBER; i++){

            //System.out.println(ObjectId.getCurrentInc());

            // add 5 nacho Doritos snacks
            DB db = mongoClient.getDB("snackmachine");
            BasicDBObject doritosnachoDoc = new BasicDBObject("name","doritosnacho")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Frito-Lay")
                                    .append("address", new BasicDBObject("street", "123 Blackberry Dr")
                                                    .append("city", "Raleigh")
                                                    .append("state", "NC")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Jun 23, 1998")
                                    .append("state", "GA")
                    )
                    .append("nutrition", new BasicDBObject("calories", 140)
                                    .append("sodium", 210)
                                    .append("fat", 8)
                                    .append("fiber", 1)
                    );
            DBCollection productTable = db.getCollection("product");
            productTable.insert(doritosnachoDoc);

            // add 5 cool ranch Doritos snacks
            BasicDBObject doritosranchDoc = new BasicDBObject("name","doritosranch")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Frito-Lay")
                                    .append("address", new BasicDBObject("street", "123 Blackberry Dr")
                                                    .append("city", "Raleigh")
                                                    .append("state", "NC")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Jun 23, 1998")
                                    .append("state", "GA")
                    )
                    .append("nutrition", new BasicDBObject("calories", 150)
                                    .append("sodium", 180)
                                    .append("fat", 8)
                                    .append("fiber", 2)
                    );
            productTable.insert(doritosranchDoc);

            // add 5 Cheetos snacks
            BasicDBObject cheetosDoc = new BasicDBObject("name","cheetos")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Frito-Lay")
                                    .append("address", new BasicDBObject("street", "524 Market Street")
                                                    .append("city", "Newark")
                                                    .append("state", "NJ")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Feb 17, 2002")
                                    .append("state", "GA")
                    )
                    .append("nutrition", new BasicDBObject("calories", 150)
                                    .append("sodium", 250)
                                    .append("fat", 10)
                                    .append("fiber", 0)
                    );
            productTable.insert(cheetosDoc);

            // add 5 original Fritos snacks
            BasicDBObject fritosDoc = new BasicDBObject("name","fritos")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Frito-Lay")
                                    .append("address", new BasicDBObject("street", "104 Victory Ln")
                                                    .append("city", "Tampa")
                                                    .append("state", "FL")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Jun 20, 1999")
                                    .append("state", "GA")
                    )
                    .append("nutrition", new BasicDBObject("calories", 160)
                                    .append("sodium", 170)
                                    .append("fat", 10)
                                    .append("fiber", 1)
                    );
            productTable.insert(fritosDoc);

            // add 5 pizza Combos snacks
            BasicDBObject combosPizzaDoc = new BasicDBObject("name","combospizza")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Mars")
                                    .append("address", new BasicDBObject("street", "524 Market Street")
                                                    .append("city", "Newark")
                                                    .append("state", "NJ")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Feb 17, 2002")
                                    .append("state", "GA")
                    )
                    .append("nutrition", new BasicDBObject("calories", 140)
                                    .append("sodium", 290)
                                    .append("fat", 7)
                                    .append("fiber", 1)
                    );
            productTable.insert(combosPizzaDoc);

            // add 5 classic Lays potato chip snacks
            BasicDBObject laysClassicDoc = new BasicDBObject("name","laysclassic")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Frito-Lay")
                                    .append("address", new BasicDBObject("street", "524 Market Street")
                                                    .append("city", "Newark")
                                                    .append("state", "NJ")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Jun 14, 2008")
                                    .append("state", "GA")
                    )
                    .append("nutrition", new BasicDBObject("calories", 160)
                                    .append("sodium", 170)
                                    .append("fat", 10)
                                    .append("fiber", 1)
                    );
            productTable.insert(laysClassicDoc);

            // add 5 classic salt and vinegar Lays potato chip snacks
            BasicDBObject laysVinegarDoc = new BasicDBObject("name","laysvinegar")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Frito-Lay")
                                    .append("address", new BasicDBObject("street", "524 Market Street")
                                                    .append("city", "Newark")
                                                    .append("state", "NJ")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Mar 3, 20011")
                                    .append("state", "GA")
                    )
                    .append("nutrition", new BasicDBObject("calories", 160)
                                    .append("sodium", 220)
                                    .append("fat", 10)
                                    .append("fiber", 1)
                    );
            productTable.insert(laysVinegarDoc);

            // add 5 cheddar and sour cream Lays potato chip snacks
            BasicDBObject laysCheddarDoc = new BasicDBObject("name","layscheddar")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Frito-Lay")
                                    .append("address", new BasicDBObject("street", "524 Market Street")
                                                    .append("city", "Newark")
                                                    .append("state", "NJ")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Feb 10, 2005")
                                    .append("state", "GA")
                    )
                    .append("nutrition", new BasicDBObject("calories", 160)
                                    .append("sodium", 170)
                                    .append("fat", 10)
                                    .append("fiber", 1)
                    );
            productTable.insert(laysCheddarDoc);

            // add 5 Pretzel stick snacks
            BasicDBObject pretzelsDoc = new BasicDBObject("name","pretzels")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Frito-Lay")
                                    .append("address", new BasicDBObject("street", "524 Market Street")
                                                    .append("city", "Newark")
                                                    .append("state", "NJ")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Feb 17, 2002")
                                    .append("state", "GA")
                    )
                    .append("nutrition", new BasicDBObject("calories", 110)
                                    .append("sodium", 490)
                                    .append("fat", 0)
                                    .append("fiber", 1)
                    );
            productTable.insert(pretzelsDoc);

            // add 5 sweet and salty mix snacks
            BasicDBObject sweetSaltyMixDoc = new BasicDBObject("name","sweetsaltymix")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Kars")
                                    .append("address", new BasicDBObject("street", "524 Market Street")
                                                    .append("city", "Chicago")
                                                    .append("state", "Il")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Oct 1, 2000")
                                    .append("state", "FL")
                    )
                    .append("nutrition", new BasicDBObject("calories", 280)
                                    .append("sodium", 110)
                                    .append("fat", 18)
                                    .append("fiber", 4)
                    );
            productTable.insert(sweetSaltyMixDoc);

            // add 5 salsa Sunchip snacks
            BasicDBObject sunchipsSalsaDoc = new BasicDBObject("name","sunchipssalsa")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Frito-Lay")
                                    .append("address", new BasicDBObject("street", "411 Bradshaw Ave")
                                                    .append("city", "Seattle")
                                                    .append("state", "WA")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Feb 17, 2002")
                                    .append("state", "FL")
                    )
                    .append("nutrition", new BasicDBObject("calories", 140)
                                    .append("sodium", 150)
                                    .append("fat", 6)
                                    .append("fiber", 2)
                    );
            productTable.insert(sunchipsSalsaDoc);

            // add 5 bbq Sunchip snacks
            BasicDBObject sunchipsBbqDoc = new BasicDBObject("name","sunchipsbbq")
                    .append("price", 1.10)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Frito-Lay")
                                    .append("address", new BasicDBObject("street", "411 Bradshaw Ave")
                                                    .append("city", "Seattle")
                                                    .append("state", "WA")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Feb 17, 2002")
                                    .append("state", "FL")
                    )
                    .append("nutrition", new BasicDBObject("calories", 140)
                                    .append("sodium", 135)
                                    .append("fat", 6)
                                    .append("fiber", 2)
                    );
            productTable.insert(sunchipsBbqDoc);

            // add 5 Reeses cups
            BasicDBObject reesesDoc = new BasicDBObject("name","reeses")
                    .append("price", .80)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Hershey's")
                                    .append("address", new BasicDBObject("street", "1134 Irwin Rd.")
                                                    .append("city", "Manhattan")
                                                    .append("state", "NY")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Mar, 5 2014")
                                    .append("state", "OR")
                    )
                    .append("nutrition", new BasicDBObject("calories", 210)
                                    .append("sodium", 150)
                                    .append("fat", 13)
                                    .append("fiber", 1)
                    );
            productTable.insert(reesesDoc);

            // add 5 Snickers bars
            BasicDBObject snickersDoc = new BasicDBObject("name","snickers")
                    .append("price", .80)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Hershey's")
                                    .append("address", new BasicDBObject("street", "281 Teatree Blvd")
                                                    .append("city", "San Jose")
                                                    .append("state", "CA")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Jan 3, 2014")
                                    .append("state", "OR")
                    )
                    .append("nutrition", new BasicDBObject("calories", 250)
                                    .append("sodium", 120)
                                    .append("fat", 12)
                                    .append("fiber", 1)
                    );
            productTable.insert(snickersDoc);

            // add 5 Milkyway bars
            BasicDBObject milkyWayDoc = new BasicDBObject("name","milkyway")
                    .append("price", .80)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Hershey's")
                                    .append("address", new BasicDBObject("street", "281 Teatree Blvd")
                                                    .append("city", "San Jose")
                                                    .append("state", "CA")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Jan 3, 2014")
                                    .append("state", "OR")
                    )
                    .append("nutrition", new BasicDBObject("calories", 240)
                                    .append("sodium", 75)
                                    .append("fat", 9)
                                    .append("fiber", 1)
                    );
            productTable.insert(milkyWayDoc);

            // add 5 Twix bar pairs
            BasicDBObject twixDoc = new BasicDBObject("name","twix")
                    .append("price", .80)
                    .append("expiration", "Sep 8, 2016")
                    .append("supplier", new BasicDBObject("name", "Mars")
                                    .append("address", new BasicDBObject("street", "1134 Irwin Rd.")
                                                    .append("city", "Manhattan")
                                                    .append("state", "NY")
                                    )
                    )
                    .append("lot", new BasicDBObject("id", "12345")
                                    .append("packaged", "Mar, 5 2014")
                                    .append("state", "OR")
                    )
                    .append("nutrition", new BasicDBObject("calories", 250)
                                    .append("sodium", 100)
                                    .append("fat", 12)
                                    .append("fiber", 1)
                    );
            productTable.insert(twixDoc);
        }
    }

    /*

     */
    public void addTransacton(String itemName){
        DB db = mongoClient.getDB("snackmachine");
        DBCollection salesTable = db.getCollection("sales");
        DBCollection productTable = db.getCollection("product");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", itemName);
        BasicDBObject purchaseDoc = new BasicDBObject(searchQuery);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date snapShot = new Date();
        purchaseDoc.append("sold",dateFormat.format(snapShot));
        purchaseDoc.append("paid", productTable.findOne(searchQuery).get("price"));
        salesTable.insert(purchaseDoc);
    }

    /*

     */
    public ConcurrentLinkedQueue<String> getTransactions(ConcurrentLinkedQueue<String> receipt){
        DB db = mongoClient.getDB("snackmachine");
        DBCollection salesTable = db.getCollection("sales");
        DBCursor cursor = salesTable.find();
        while(cursor.hasNext()){
            String item = cursor.next().toString();
            receipt.add(item);
        }
        System.out.println("Receipt Generated....");
        return receipt;
    }

    public void getTotalSales() {
        DB db = mongoClient.getDB("snackmachine");
        DBCollection salesTable = db.getCollection("sales");

        String map = "function(){ " +
                        "var snackname = 'total snacks'; " +
                        "emit({name:this.name}, {count:1}); " +
                        "sort: {name: 1};" +
                     "}";
        String reduce = "function(key,values){ "+
                            "var sum = 0; " +
                            "values.forEach(function(doc){" +
                            "sum += doc['count'] " +
                            "}); " +
                            "return {sum:sum};" +
                        "}";

        MapReduceCommand cmd = new MapReduceCommand(salesTable, map, reduce, null, MapReduceCommand.OutputType.INLINE, null);
        MapReduceOutput out = salesTable.mapReduce(cmd);

        for(DBObject o: out.results()){
            System.out.println(o.toString());
        }
    }

    public void getNumSales() {
        DB db = mongoClient.getDB("snackmachine");
        DBCollection salesTable = db.getCollection("sales");

        String map = "function(){ " +
                        "for(var i = 0; i < reg.length; i++){ " +
                            "emit({name:this.name}, {count:1}); " +
                        "}" +
                     "}";

        String reduce = "function(key,counts){ "+
                            "var counter = 0; " +
                            "for (var i = 0; i < counts.length; i++) {" +
                                "counter = counter + counts[i].count;" +
                            "}"+
                        "return { count:counter };";

        MapReduceOutput out = salesTable.mapReduce(map, reduce, "counts", MapReduceCommand.OutputType.REPLACE, null);

        for(DBObject o: out.results()){
            System.out.println(o.toString());
        }
    }

    /*

     */
    public String getBestSeller() {

        DB db = mongoClient.getDB("snackmachine");
        DBCollection salesTable = db.getCollection("sales");

        String map ="function(){ " +
                        "var snackname = 'total snacks'; " +
                        "emit({name:this.name}, {count:1}); " +
                    "}";

        String reduce = "function(key,values){ "+
                            "var sum = 0; " +
                            "values.forEach(function(doc){" +
                                "sum += doc['count'] " +
                            "}); " +
                        "return {sum:sum};" +
                        "}";

        DBCollection reduced = db.createCollection("salesReduction",null);
        MapReduceCommand cmd = new MapReduceCommand(salesTable, map, reduce, "salesCounts", MapReduceCommand.OutputType.REPLACE, null);
        MapReduceOutput out = salesTable.mapReduce(cmd);
        DBCollection collection = db.getCollection("salesCounts");
        DBObject sort = new BasicDBObject();
        sort.put("value", -1);
        DBCursor cursor = collection.find().sort(sort).limit(1);
        Pattern p = Pattern.compile("[0-9]+");
        String max = cursor.next().get("value").toString();
        Matcher m = p.matcher(max);
        if(m.find()) {
            System.out.println("Best seller:" + m.group());
            return m.group();
        }
        return "";
    }

    public String getWorstSeller() {

            DB db = mongoClient.getDB("snackmachine");
            DBCollection salesTable = db.getCollection("sales");

            String map = "function(){ " +
                    "var snackname = 'total snacks'; " +
                    "emit({name:this.name}, {count:1}); " +
                    "}";

            String reduce = "function(key,values){ " +
                    "var sum = 0; " +
                    "values.forEach(function(doc){" +
                    "sum += doc['count'] " +
                    "}); " +
                    "return {sum:sum};" +
                    "}";

            DBCollection reduced = db.createCollection("salesReduction", null);
            MapReduceCommand cmd = new MapReduceCommand(salesTable, map, reduce, "salesCounts", MapReduceCommand.OutputType.REPLACE, null);
            MapReduceOutput out = salesTable.mapReduce(cmd);
            DBCollection collection = db.getCollection("salesCounts");
            DBObject sort = new BasicDBObject();
            sort.put("value", 1);
            DBCursor cursor = collection.find().sort(sort).limit(1);
            Pattern p = Pattern.compile("[0-9]+");
            String max = cursor.next().get("value").toString();
            Matcher m = p.matcher(max);
            if(m.find()) {
                System.out.println("Worst seller:" + m.group());
                return m.group();
            }
            return "";
    }

    /*

     */
    public void clearProducts(){
        DB db = mongoClient.getDB("snackmachine");
        DBCollection productTable = db.getCollection("product");
        DBCursor cursor = productTable.find();
        while(cursor.hasNext()){
            productTable.remove(cursor.next());
        }
        System.out.println("All existing product documents removed.");
    }

    /*

     */
    public void clearSales(){
        DB db = mongoClient.getDB("snackmachine");
        DBCollection productTable = db.getCollection("sales");
        DBCursor cursor = productTable.find();
        while(cursor.hasNext()){
            productTable.remove(cursor.next());
        }
        System.out.println("All existing sales documents removed.");
    }

    public void registerModel(Model m){

    }

    public void unregisterModel(Model m){

    }

    public void notifyView(){

    }

    public void closeConnection(){
        mongoClient.close();
    }



}
