package io.pivotal.socialmedia.buslogic;

import io.pivotal.socialmedia.domain.Post;
import io.pivotal.socialmedia.domain.User;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.query.Query;


public class PostLoader {

	private ClientCache cache;
	private Region <Integer, Post> posts;
	
	public static void main(String[] args) throws Exception
	{
		PostLoader loader = new PostLoader();
		loader.getCache();
		loader.getPostRegion();
		loader.populatePosts();
		loader.getPost();
		loader.queryPosts();
		loader.closeCache();
		

	}
	
	public void setCache (ClientCache cache)
	{
		this.cache = cache;
	}
	
	public void closeCache()
	{
		cache.close();
	}
	
	public void getCache()
	{
		this.cache = new ClientCacheFactory()
        .set("cache-xml-file", "xml/client-cache.xml")
        .create();
	}
	
	public void getPostRegion()
	{
		posts = cache.getRegion("Post");
		System.out.println("Got the Post Region: " + posts);
	}
	
	public void populatePosts(){
		Post post1 = new Post(10001, "Hello" ,2222);
		posts.put(10001, post1);
		
		Post post2 = new Post(10002,"Goodbye"  ,2222);
		posts.put(10002, post2);
		
		Post post3 = new Post(10003,"How are you?"  ,2222);
		posts.put(10003, post3);
		
		Post post4 = new Post(10004,"Whats up?" ,2222);
		posts.put(10004, post4);
		
		Post post5 = new Post(10005,"Have a good day",2222);	
		posts.put(10005, post5);
		Post post6 = new Post(10006, "Hello" ,33333);
		posts.put(10006, post6);
		
		Post post7 = new Post(10007,"Goodbye"  ,33333);
		posts.put(10007, post7);
		
		Post post8 = new Post(10008,"How are you?"  ,33333);
		posts.put(10008, post8);
		
		Post post9 = new Post(10009,"Whats up?" ,33333);
		posts.put(10009, post9);
		
		Post post10 = new Post(10010,"Have a good day",33333);	
		posts.put(10010, post10);
		Post post11 = new Post(10011, "Hello" ,44444);
		posts.put(10011, post11);
		
		Post post12 = new Post(10012,"Goodbye"  ,44444);
		posts.put(10012, post12);
		
		Post post13 = new Post(10013,"How are you?"  ,44444);
		posts.put(10013, post13);
		
		Post post14 = new Post(10014,"Whats up?" ,44444);
		posts.put(10014, post14);
		
		Post post15 = new Post(10015,"Have a good day",44444);	
		posts.put(10015, post15);
		Post post16 = new Post(10016, "Hello" ,55555);
		posts.put(10016, post16);
		
		Post post17 = new Post(10017,"Goodbye"  ,55555);
		posts.put(10017, post17);
		
		Post post18 = new Post(10018,"How are you?"  ,55555);
		posts.put(10018, post18);
		
		Post post19 = new Post(10019,"Whats up?" ,55555);
		posts.put(10019, post19);
		
		Post post20 = new Post(10020,"Have a good day",55555);	
		posts.put(10020, post20);
		Post post21 = new Post(10021, "Hello" ,11111);
		posts.put(10021, post21);
		
		Post post22 = new Post(10022,"Goodbye"  ,11111);
		posts.put(10022, post22);
		
		Post post23 = new Post(10023,"How are you?"  ,11111);
		posts.put(10023, post23);
		
		Post post24 = new Post(10024,"Whats up?" ,11111);
		posts.put(10024, post24);
		
		Post post25 = new Post(10025,"Have a good day",11111);	
		posts.put(10025, post25);
		
		
	}
	
	public void queryPosts() throws Exception{
		Query query = cache.getQueryService().newQuery("select * from /Post");
		Object o = query.execute();
		System.out.println("From Query returned: "+o);
		
		
	}
	public void getPost(){
		Post post1 = posts.get(new Integer(10001));
		System.out.println("Post from getPost returned as : "+post1);
		
			
	}
}
