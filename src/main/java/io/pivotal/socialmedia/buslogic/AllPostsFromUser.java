package io.pivotal.socialmedia.buslogic;

import java.util.Properties;

import io.pivotal.socialmedia.domain.Post;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.FunctionAdapter;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.gemstone.gemfire.cache.partition.PartitionRegionHelper;
import com.gemstone.gemfire.cache.query.Query;
import com.gemstone.gemfire.cache.query.QueryService;
import com.gemstone.gemfire.cache.query.SelectResults;
import com.gemstone.gemfire.pdx.PdxInstance;


public class AllPostsFromUser extends FunctionAdapter implements Declarable{

	private static final long serialVersionUID = -5861593135266150172L;

	

	@Override
	public void execute(FunctionContext context) {
		if (context instanceof RegionFunctionContext) {
			Cache cache= CacheFactory.getAnyInstance();
			QueryService qs = cache.getQueryService();
 			String queryString = "select DISTINCT p from /Post p WHERE p.userId=2222";
			RegionFunctionContext rfc = (RegionFunctionContext) context;
			
				
	 			try {
	 				Query query = qs.newQuery(queryString);
	 				SelectResults<Post> results = (SelectResults <Post>)query.execute(rfc);
	 				for(Post p: results){
	 					System.out.println("Post: " + p.getMyPost());
	 					rfc.getResultSender().sendResult(p.getMyPost());
	 					rfc.getResultSender().lastResult(null);
	 				}
	 				
	 				System.out.println("Function Executed"); //As seen in logs for servers
	 			} catch (Exception e) {
	 			  e.printStackTrace();	
	 			  System.out.println("Failing in Execute 'Try Block' ");
	 			}

			
			} else {
				throw new FunctionException("Function must be called as onRegion()");
			}
		}
	

	@Override
	public String getId() {
		return getClass().getName();
	}
	
	

	public void init(Properties arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean optimizeForWrite() {
		return true;
	}

}
