package io.pivotal.socialmedia.buslogic;

import io.pivotal.socialmedia.domain.Post;

import com.gemstone.gemfire.cache.query.CqEvent;
import com.gemstone.gemfire.cache.query.CqListener;


public class PostingCQListener implements CqListener
{

	public void close() {
		System.out.println("CQListener:Received Close Event");
		
	}

	public void onError(CqEvent event) {
		System.out.println("CQListener:Received onError event");
		System.out.println("CQListener:Throwable: " + event.getThrowable());
		
	}

	public void onEvent(CqEvent event) {
		System.out.println("***************************************************************************************************************************");
		System.out.println("* CQListener: Event is           : " + event);
		System.out.println("* CQListener: Key is             : " + (Integer)event.getKey());
		System.out.println("* CQListener: New Post is        : " +  (Post)event.getNewValue());
		System.out.println("* CQListener: Base Operation is  : " + event.getBaseOperation());
		System.out.println("* CQListener: Query Operation is : " + event.getQueryOperation());
		System.out.println("* CQListener: Cq is              : " + event.getCq());
		System.out.println("* CQListener: DeltaValue         : " + event.getDeltaValue());
	System.out.println("***************************************************************************************************************************");
		
	}

	
}


