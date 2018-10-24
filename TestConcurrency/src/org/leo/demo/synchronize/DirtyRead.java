package org.leo.demo.synchronize;

/**
 * 多方法需要使用synchronized实现同步,避免出现脏读
 * @author leoliu
 *
 */
public class DirtyRead {
	
	private String username = "leo";
	private String password = "123";
	
	public synchronized void setValue(String username, String password) {
		this.username = username;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("setValue最终结果:username=" +username+" , password=" + password);
	}
	
	public synchronized void getValue() {
		System.out.println("getValue最终结果:username=" +username+" , password=" + password);
	}

	public static void main(String[] args) throws InterruptedException {
		
		final DirtyRead dr = new DirtyRead();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				dr.setValue("jane", "456");
			}
		}).start();
		Thread.sleep(1000);
		dr.getValue();

	}

}
