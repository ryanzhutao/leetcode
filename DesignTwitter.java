import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class DesignTwitter {

	 int timestamp = 0;
	    private class Tweet{
	        public int id;
	        public int time;
	        public Tweet(int id, int timestamp){
	            this.id = id;
	            this.time = timestamp;
	        }
	        
	        public int getTimestamp(){
	            return time;
	        }
	        
	        public int getContent(){
	            return id;
	        }
	    }

	    private class User{
	        private int userID;
	        private List<Tweet> tweets;
	        private List<Integer> followee;
	        public User(int userID) {
	            this.userID = userID;
	            tweets = new ArrayList<Tweet>();
	            followee = new ArrayList<Integer>();
	        }
	        
	        public void addTweet(int tweetId,int timestamp){
	            Tweet tweet = new Tweet(tweetId, timestamp);
	            tweets.add(tweet);
	        }
	        
	        public List<Tweet> getTweets(int n){
	            int size = tweets.size();
	            int i = 0;
	            List<Tweet> result = new ArrayList<Tweet>();
	            if(n < size){
	                for(i = 1; i <= n; i++){
	                    result.add(tweets.get(size-i));
	                }
	            }else{
	                for(i = 1; i <= size; i++){
	                    result.add(tweets.get(size-i));
	                }
	            }
	            return result;
	        }
	        
	        public void addFollowee(int userID){
	            if(!followee.contains(userID)){
	                followee.add(userID);
	            }
	        }
	        public void removeFollowee(int userID){
	            if(followee.contains(userID)){
	                followee.remove((Integer)userID);
	            }
	        }
	        
	        public List<Integer> getFollowee(){
	            return followee;
	        }
	    }
	    
	    HashMap<Integer, User> table;
	    /** Initialize your data structure here. */
	    public DesignTwitter() {
	        table = new HashMap<Integer, User>();
	    }
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
	        User user = table.get(userId);
	        if(user == null){
	            user = new User(userId);
	        }
	        user.addTweet(tweetId, timestamp);
	        timestamp++;
	        table.put(userId, user);
	    }
	    
	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
	        User user = table.get(userId);
	        List<Integer> result = null; 
	        int i = 0;
	        int cnt = 0;
	        User ufollowee = null;
	        result = new ArrayList<Integer>();
	        if(user == null){
	            return result;
	        }else{
	            
	            List<Tweet> alltweets = new ArrayList<Tweet>();
	            List<Integer> followees = user.getFollowee();
	            if(!followees.contains(userId)){
	                alltweets.addAll(user.getTweets(10));
	            }
	            
	            for(Integer followee: followees){
	                ufollowee = table.get(followee);
	                if(ufollowee!=null){
	                    alltweets.addAll(ufollowee.getTweets(10));
	                }
	            }
	            Comparator<Tweet> comparator = new Comparator<Tweet>() {
	    			public int compare(Tweet t1, Tweet t2) {
	    				int result = 0;
	    				if(t1.getTimestamp()<t2.getTimestamp()){
	    					result = 1;
	    				}else if(t1.getTimestamp()>t2.getTimestamp()){
	    					result = -1;
	    				}else{
	    					result = 0;
	    				}
	    				return result;
	    			}
			    };
			    Collections.sort(alltweets, comparator);
			    cnt = alltweets.size() < 10? alltweets.size():10;
			    for(i = 0; i < cnt; i++){
			        result.add(alltweets.get(i).getContent());
			    }
	        }
	        return result;
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
	        User user = table.get(followerId);
	        if(user==null){
	            user = new User(followerId);
	        }
	        user.addFollowee(followeeId);
	        table.put(followerId, user);
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	        User user = table.get(followerId);
	        if(user!=null){
	            user.removeFollowee(followeeId);
	            table.put(followerId, user);
	        }
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
