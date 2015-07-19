package io.pivotal.socialmedia.buslogic;

import io.pivotal.socialmedia.domain.Post;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;


public class PostingDao {
	
	// The region object that stores BookMaster objects
			private Region <Integer, Post> posts;

			public PostingDao(ClientCache cache) {
				this.posts = cache.getRegion("Post");
			}
			
			public void insertPost(Integer key, Post post)
			{
	           
				posts.create(key, post);
				
			}
			
			public Post getPost(Integer key)
			{
				
				return posts.get(key);
			}
			
		    public void updatePost(Integer key, Post post)
		    {
		    
		    	posts.put(key, post);

		    }

		    public void removePost(Integer key) 
		    {
		        
		    	posts.remove(key);
		    
		    }
			
}
