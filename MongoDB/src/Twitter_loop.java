import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.text.Document;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UserMentionEntity;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;
import java.util.regex.*;
import static javafx.scene.input.KeyCode.P;






public class Twitter_loop {




    private ConfigurationBuilder cb;
    private DB db;
    private DBCollection items;




    /**
     * static block used to construct a connection with tweeter with twitter4j
     * configuration with provided settings. This configuration builder will be
     * used for next search action to fetch the tweets from twitter.com.
     */

    public static void main(String[] args) throws InterruptedException {

        Twitter_loop taskObj = new Twitter_loop();

        taskObj.loadMenu("dnacho");
    }

    public void loadMenu(String keyword)  throws InterruptedException {   


        //System.out.print("Please choose your Keyword:\t");
        //Scanner input = new Scanner(System.in);
        //String keyword = input.nextLine();

        
        connectdb(keyword); 

     
            cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true);
            cb.setOAuthConsumerKey("FC92PeytnRkNAcpTZjJTQHRnD");
            cb.setOAuthConsumerSecret("hdkgzuU6d0Sf8YSHucBxTXpLanWMEMB46KutM6JR5Koqb5sZva");
            cb.setOAuthAccessToken("98014861-hQ6By5cRcGGZmKMcJPuFOx24QCP9DX8k4Px9rVs4Z");
            cb.setOAuthAccessTokenSecret("P20EJsYcU0u6eKfa5cn09ZDN8POgtZiRauVgl7ne6W70A");

            getTweetByQuery(true,keyword);
            cb = null;




        

    }

    public void connectdb(String keyword)
    {
        try {
            // on constructor load initialize MongoDB and load collection
            initMongoDB();
            items = db.getCollection(keyword);

            //make the tweet_ID unique in the database
            BasicDBObject index = new BasicDBObject("tweet_ID", 1);
            items.ensureIndex(index, new BasicDBObject("unique", true));

        } catch (MongoException ex) {
            System.out.println("MongoException :" + ex.getMessage());
        }

    }


    /**
     * initMongoDB been called in constructor so every object creation this
     * initialize MongoDB.
     */
    public void initMongoDB() throws MongoException {
        try {
            System.out.println("Connecting to Mongo DB..");
            Mongo mongo;
            mongo = new Mongo("127.0.0.1");
            db = mongo.getDB("tweetDB2");
        } catch (UnknownHostException ex) {
            System.out.println("MongoDB Connection Error :" + ex.getMessage());
        }
    }



    public void getTweetByQuery(boolean loadRecords, String keyword) throws InterruptedException {


        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();



        if (cb != null) {

            try {
                //Query query = new Query(keyword);
                //query.setCount(20);
                //QueryResult result;
                //result = twitter.search(query);
            	User user = twitter.verifyCredentials();
            	List<Status> tweets = twitter.getUserTimeline(keyword);
            	System.out.println("Getting Tweets...");
                //List<Status> tweets = result.getTweets();

                for (Status tweet : tweets) {
                    BasicDBObject basicObj = new BasicDBObject();
                    basicObj.put("user_name", tweet.getUser().getScreenName());
                    //basicObj.put("retweet_count", tweet.getRetweetCount());
                    //basicObj.put("tweet_followers_count", tweet.getUser().getFollowersCount());
                    //basicObj.put("source",tweet.getSource());
                    //basicObj.put("coordinates",tweet.getGeoLocation());


                    UserMentionEntity[] mentioned = tweet.getUserMentionEntities();
                    //basicObj.put("tweet_mentioned_count", mentioned.length);
                    basicObj.put("tweet_ID", tweet.getId());
                    basicObj.put("tweet_text", tweet.getText());


                    try {
                        items.insert(basicObj);
                    } catch (Exception e) {
                        System.out.println("MongoDB Connection Error : " + e.getMessage());

                    }
                }

                // Printing fetched records from DB.
                if (loadRecords) {
                    getTweetsRecords();
                }

            } catch (TwitterException te) {
                System.out.println("te.getErrorCode() " + te.getErrorCode());
                System.out.println("te.getExceptionCode() " + te.getExceptionCode());
                System.out.println("te.getStatusCode() " + te.getStatusCode());
                if (te.getStatusCode() == 401) {
                    System.out.println("Twitter Error : \nAuthentication credentials (https://dev.twitter.com/pages/auth) were missing or incorrect.\nEnsure that you have set valid consumer key/secret, access token/secret, and the system clock is in sync.");
                } else {
                    System.out.println("Twitter Error : " + te.getMessage());
                }



            }
        } else {
            System.out.println("MongoDB is not Connected! Please check mongoDB intance running..");
        }
    }

    
 public String query (String texto){
     // initMongoDB();
      String usuario = "dnacho";
      items = db.getCollection(usuario);
      //BasicDBObject fields = new BasicDBObject("_id", false).append("user_name", false).append("tweet_ID",false);
      
      //BasicDBObject query = new BasicDBObject();
      //query.put("tweet_text", "@eToro are you guys having problems. I cannot login!!");
      //DBCursor cursor = items.find(query);
      
      //DBCursor cursor = items.find("tweet_text": { $regex: /P/ } );
      //items.find({tweet_text:{$regex: /tutorialspoint/}});

      
      //BasicDBObject query = new BasicDBObject(tweet_text : /steam/);
//      System.out.println(cursor);
     // while (cursor.hasNext()) {
        //        System.out.println("Prueba");
        //        System.out.println(cursor.next());
        //    }
      //DBCursor cursor = items.find({tweet_text: /steam/});
      //FindIterable <Document> iterable = items.find(Document.parse("{\"status.name\": \"Expired\"}"));
    
      return usuario;
 }   
    
    
  public List buscar (String usuario){
        initMongoDB();
        items = db.getCollection(usuario);
        //query("dnacho");
       
        BasicDBObject fields = new BasicDBObject("_id", false).append("user_name", false).append("tweet_ID",false);
        DBCursor cursor = items.find(new BasicDBObject(), fields).limit(10).sort(new BasicDBObject("_id",1));
		
		List myList = new ArrayList();
		int n=1;
		
		while (cursor.hasNext()) {
                     DBObject obj = cursor.next();  
                     String texto = (String) obj.get("tweet_text");
                     myList.add(texto);
          
		}
	
         System.out.println("Prueba");
         query("dnacho");
                 
	return myList;
		 
    }
  
    public int contador (String usuario){
        initMongoDB();
        items = db.getCollection(usuario);
        //query("dnacho");
       
        BasicDBObject fields = new BasicDBObject("_id", false).append("user_name", false).append("tweet_ID",false);
        DBCursor cursor = items.find(new BasicDBObject(), fields).sort(new BasicDBObject("_id",1));
        int guardados = (int) items.count();
		
		List myList = new ArrayList();
		int n=1;
		
		while (cursor.hasNext()) {
                     DBObject obj = cursor.next();  
                     String texto = (String) obj.get("tweet_text");
                     myList.add(texto);
          
		}
	
         
                 
	return guardados;
		 
    }
    
    public List getTweetsRecords() throws InterruptedException {
        BasicDBObject fields = new BasicDBObject("_id", false).append("user_name", false).append("tweet_ID",false);
        DBCursor cursor = items.find(new BasicDBObject(), fields).limit(10).sort(new BasicDBObject("_id",1));
        
      
        
      List myList = new ArrayList();
      int n=1;
      
      while (cursor.hasNext()) {
          DBObject obj = cursor.next();  
          String texto = (String) obj.get("tweet_text");
          myList.add(texto);
          
      }
      System.out.println(myList);

      return myList;
      
    }
    

    public static String wrapString(String string, int charWrap) {
    int lastBreak = 0;
    int nextBreak = charWrap;
    if (string.length() > charWrap) {
        String setString = "";
        do {
            while (string.charAt(nextBreak) != ' ' && nextBreak > lastBreak) {
                nextBreak--;
            }
            if (nextBreak == lastBreak) {
                nextBreak = lastBreak + charWrap;
            }
            setString += string.substring(lastBreak, nextBreak).trim() + "\n";
            lastBreak = nextBreak;
            nextBreak += charWrap;

        } while (nextBreak < string.length());
        setString += string.substring(lastBreak).trim();
        return setString;
    } else {
        return string;
    }
}
    
    /*
    public List<DBObject> getResultsInDescendingOrderByDate(int limit) {

        List<DBObject> myList = null;
        DBCursor myCursor=myCollection.find().sort(new BasicDBObject("date",-1)).limit(10);
        myList = myCursor.toArray();

        return myList;
    }
*/

}