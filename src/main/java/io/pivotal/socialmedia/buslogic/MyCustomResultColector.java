package io.pivotal.socialmedia.buslogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.ResultCollector;
import com.gemstone.gemfire.distributed.DistributedMember;

public class MyCustomResultColector implements ResultCollector<Serializable, Serializable> {
	
	ArrayList<Serializable> result = new ArrayList<Serializable>();

	public void addResult(DistributedMember memberID,Serializable resultOfSingleExecution) {
			
			result.add(resultOfSingleExecution);
		
	}

	public void clearResults() {
		result.clear();
		
	}

	public void endResults() {
		// TODO Auto-generated method stub
		
	}

	public Serializable getResult() throws FunctionException {
		
		return result;
	}

	public Serializable getResult(long timeout, TimeUnit unit)
			throws FunctionException, InterruptedException {
		
		return this.getResult();
	}


}