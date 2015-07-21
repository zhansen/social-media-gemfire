package io.pivotal.socialmedia.buslogic;

import io.pivotal.socialmedia.domain.Post;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.gemstone.gemfire.GemFireCheckedException;
import com.gemstone.gemfire.GemFireException;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.client.PoolManager;
import com.gemstone.gemfire.cache.query.CqAttributes;
import com.gemstone.gemfire.cache.query.CqAttributesFactory;
import com.gemstone.gemfire.cache.query.CqQuery;
import com.gemstone.gemfire.cache.query.QueryService;
import com.gemstone.gemfire.cache.query.SelectResults;
import com.gemstone.gemfire.cache.query.Struct;


public class ClientCQ {
	private ClientCache cache;

	public static void main(String[] args) throws Exception {
		ClientCQ consumer = new ClientCQ();
		consumer.getCache();

		try {
			consumer.registerCq();

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in));

			System.out.println("Press enter to end");
			bufferedReader.readLine();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		consumer.closeCache();

	}

	public void registerCq() throws GemFireException, GemFireCheckedException {
		
		Pool myPool = PoolManager.find("client");

		
		QueryService queryService = myPool.getQueryService();
		
		
		CqAttributesFactory cqAf = new CqAttributesFactory();
		cqAf.addCqListener(new PostingCQListener());
		CqAttributes cqa = cqAf.create();
		
		String query = "SELECT * FROM /Post p WHERE p.postNumber > 20000";
		
		
		CqQuery myCq = queryService.newCq("myCQ", query, cqa);
		System.out.println("New CQ Service Created");
		SelectResults sResults = myCq.executeWithInitialResults();
		for (Object o : sResults) {
			Struct s = (Struct) o;
			Post p = (Post) s.get("value");
			System.out.println("Intial result includes: " + p);
		}
	}

	public void closeCache() {
		cache.close();
	}

	public void getCache() {

		cache = new ClientCacheFactory().set("name", "CQClient")
				.set("cache-xml-file", "xml/client-cache.xml").create();
	}

}
