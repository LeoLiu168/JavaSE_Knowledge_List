package org.leo.demo.dp.singleton;
/*
 * 使用枚举类作为内部类实现懒加载
 */
public final class LazyEnumSingleton {
	private LazyEnumSingleton(){}
	private enum EnumHolder{
		INSTANCE;
		private LazyEnumSingleton instance;
		EnumHolder(){
			this.instance = new LazyEnumSingleton();
		}
		private LazyEnumSingleton getLazyEnumSingleton() {
			return instance;
		}
	}
	public static LazyEnumSingleton getInstance() {
		return EnumHolder.INSTANCE.getLazyEnumSingleton();
	}
}
