package io.pivotal.socialmedia.buslogic;



import java.util.ArrayList;

import io.pivotal.socialmedia.domain.Post;
import io.pivotal.socialmedia.domain.User;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.execute.Execution;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.cache.execute.ResultCollector;

public class FunctionExecuter {
	
	private Region <Integer, User> users;
	private Region <Integer, Post> posts;
	
	public static void main(String[] args) throws Exception
	{
		FunctionExecuter poster = new FunctionExecuter();
		poster.getCache();
		poster.getPostRegion();
		poster.getUserRegion();
		poster.executeFunction();
		poster.closeCache();
		
		
	}
	
	public void executeFunction(){
		 Execution execution = FunctionService.onRegion(posts)
				 .withArgs(2222)
				 .withCollector(new MyCustomResultColector());
		 
		 ResultCollector rc = execution.execute("io.pivotal.socialmedia.buslogic.AllPostsFromUser");
         ArrayList results = (ArrayList) rc.getResult();
         System.out.println("The Posts for given User are: "+ results);
		
		
		
	}
	
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
}
