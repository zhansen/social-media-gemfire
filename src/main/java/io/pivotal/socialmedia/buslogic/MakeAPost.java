package io.pivotal.socialmedia.buslogic;

import java.util.Scanner;

import io.pivotal.socialmedia.domain.Post;
import io.pivotal.socialmedia.domain.User;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;



public class MakeAPost {
	private Region <Integer, User> users;
	private Region <Integer, Post> posts;
	
	
	/**
	 
	 * 
	 * @param cache
	 * @return 
	 */
	public void MyRegions(ClientCache cache) {
		posts = cache.getRegion("Post");
		users = cache.getRegion("User");
		
	}
	private ClientCache cache;
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
	
	public void getUserRegion()
	{
		users = cache.getRegion("User");
		System.out.println("Got the User Region: " + users);
	}
	
	public void getPostRegion()
	{
		posts = cache.getRegion("Post");
		System.out.println("Got the Post Region: " + posts);
	}
	
	public Integer makePost(){
		 Scanner in = new Scanner(System.in);
		 System.out.println("What would you like to post");	
		 String newPost = in.nextLine();
		 Integer myPostNumber = 5;
		 myPostNumber = myPostNumber++;
		 Post myPost = new Post(myPostNumber, newPost, 2222);
		 
		    User usr2 = new User();
			usr2.setFirstName("Zac");
			usr2.setLastName("Hansen");
			usr2.setUserId(2222);
			usr2.addPost(myPostNumber);
			users.put(new Integer(2222), usr2);
			posts.put(myPostNumber, myPost);
			
			return myPostNumber;
}
	
	public void getPost(Integer myPostNumber){
		Post post1 = posts.get(new Integer(myPostNumber));
		System.out.println("Post from getPost returned as : "+post1);
		
			
	}
	
	
	public static void main(String[] args) throws Exception
	{
		MakeAPost poster = new MakeAPost();
		poster.getCache();
		poster.getPostRegion();
		poster.getUserRegion();
		Integer myPostNumber = poster.makePost();
		poster.getPost(myPostNumber);
		poster.closeCache();
		
		
	}
	
}
