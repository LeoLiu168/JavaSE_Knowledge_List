package org.leo.demo.threadpool;

@FunctionalInterface
public interface DenyPolicy {
	
	void reject(Runnable runnable, ThreadPool threadPool);
	
	//1.拒绝并丢弃任务
	class DiscardDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			
		}	
	}
	
	//2.拒绝并抛出自定义异常
	class AbortDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			throw new RunnableDenyException("The runnable " + runnable + " will abort.");
		}		
	}
	
	//3.拒绝, 使用提交者所在线程来完成线程任务.
	class RunnerDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {

			if(!threadPool.isShutdown()) {
				runnable.run();
			}
		}	
	}
}
