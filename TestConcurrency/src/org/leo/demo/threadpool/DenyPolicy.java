package org.leo.demo.threadpool;

@FunctionalInterface
public interface DenyPolicy {
	
	void reject(Runnable runnable, ThreadPool threadPool);
	
	//1.deny and discard tasks
	class DiscardDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	//2.deny and throws exception
	class AbortDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			throw new RunnableDenyException("The runnable " + runnable + " will abort.");
		}
		
	}
	
	//3.deny and use submit`s thread to run the task
	class RunnerDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {

			if(!threadPool.isShutdown()) {
				runnable.run();
			}
		}
		
	}

}
