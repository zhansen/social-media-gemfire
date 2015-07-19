package io.pivotal.socialmedia.buslogic;

import io.pivotal.socialmedia.domain.User;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;

import com.gemstone.gemfire.cache.query.Query;




public class UserLoader {
	
	public static void main(String[] args) throws Exception
	{
		UserLoader loader = new UserLoader();
		loader.getCache();
		loader.getUserRegion();
		loader.populateUsers();
		loader.getUser();
		loader.queryUsers();
		loader.closeCache();
		
		

	}
	
	private ClientCache cache;
	private Region <Integer, User> users;
	
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
	
	public void populateUsers()
	{
		
		User usr2 = new User();
		usr2.setFirstName("Zac");
		usr2.setLastName("Hansen");
		usr2.setUserId(2222);
		usr2.addPost(10001);
		usr2.addPost(10002);
		usr2.addPost(10003);
		usr2.addPost(10004);
		usr2.addPost(10005);
		users.put(new Integer(2222), usr2);
		System.out.println("Inserted a User: " + usr2);
		
		User usr3 = new User();
		usr3.setFirstName("Kim");
		usr3.setLastName("Person");
		usr3.setUserId(33333);
		usr3.addPost(10006);
		usr3.addPost(10007);
		usr3.addPost(10008);
		usr3.addPost(10009);
		usr3.addPost(10010);
		users.put(new Integer(33333), usr3);
		System.out.println("Inserted a User: " + usr3);
		
		User usr4 = new User();
		usr4.setFirstName("Joe");
		usr4.setLastName("Deer");
		usr4.setUserId(44444);
		usr4.addPost(10011);
		usr4.addPost(10012);
		usr4.addPost(10013);
		usr4.addPost(10014);
		usr4.addPost(10015);
		users.put(new Integer(44444), usr4);
		System.out.println("Inserted a User: " + usr4);
		
		User usr5 = new User();
		usr5.setFirstName("Five");
		usr5.setLastName("Sixth");
		usr5.setUserId(55555);
		usr5.addPost(10016);
		usr5.addPost(10017);
		usr5.addPost(10018);
		usr5.addPost(10019);
		usr5.addPost(10020);
		users.put(new Integer(55555), usr5);
		System.out.println("Inserted a User: " + usr5);
		
		User usr1 = new User();
		usr1.setFirstName("Howdy");
		usr1.setLastName("Doody");
		usr1.setUserId(11111);
		usr1.addPost(10021);
		usr1.addPost(10022);
		usr1.addPost(10023);
		usr1.addPost(10024);
		usr1.addPost(10025);
		users.put(new Integer(11111), usr1);
		System.out.println("Inserted a User: " + usr1);
		
		

	}
	public void getUser(){
		User user1 = users.get(new Integer(11111));
		System.out.println("User from getUser returned as : "+user1);
		User user2 = users.get(new Integer(2222));
		System.out.println("User from getUser returned as : "+user2);
		User user3 = users.get(new Integer(33333));
		System.out.println("User from getUser returned as : "+user3);
		User user4 = users.get(new Integer(44444));
		System.out.println("User from getUser returned as : "+user4);
		User user5 = users.get(new Integer(55555));
		System.out.println("User from getUser returned as : "+user5);
			
	}
	
	public void queryUsers() throws Exception{
		Query query = cache.getQueryService().newQuery("select DISTINCT u FROM /User u WHERE u.userId=2222");
		Object o = query.execute();
		System.out.println("From Query returned: "+o);
		
		
	}

}
