package org.leo.demo.map;

import java.util.TreeMap;

class R implements Comparable<Object>{
	
	int count;

	public R(int count) {
		super();
		this.count = count;
	}

	@Override
	public String toString() {
		return "R [count=" + count + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		R other = (R) obj;
		if (count != other.count)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		R r = (R)o;
		return count > r.count ? 1: count < r.count ? -1 : 0;
	}
}

public class TestTreeMap {

	public static void main(String[] args) {
		TreeMap<R, String> tm = new TreeMap<>();
		tm.put(new R(3), "AAAA");
		tm.put(new R(-5), "BBB");
		tm.put(new R(9), "CCCCCC");
		System.out.println(tm);
		//返回第一个Entry对象
		System.out.println(tm.firstEntry());
		//返回最后一个Key
		System.out.println(tm.lastKey());
		//返回比R(2)大一个的Key
		System.out.println(tm.higherKey(new R(2)));
		//返回比R(2)小的一个Key
		System.out.println(tm.lowerKey(new R(2)));
		//获取子串
		System.out.println(tm.subMap(new R(-1), new R(4)));
		System.out.println(tm);	
	}
}
