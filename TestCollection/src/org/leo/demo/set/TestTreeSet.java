package org.leo.demo.set;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestTreeSet {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		TreeSet<Integer> nums = new TreeSet<>();
		SortedSet<Integer> set = Collections.synchronizedSortedSet(nums);
		nums.add(5);
		nums.add(2);
		nums.add(10);
		nums.add(-9);
		//输出,此时已按自然排序
		System.out.println(nums);
		System.out.println(nums.first());
		System.out.println(nums.last());
		//返回<4的子序列
		System.out.println(nums.headSet(4));
		//返回>=5的子序列
		System.out.println(nums.tailSet(5));
		//返回[-3, 4)的子序列
		System.out.println(nums.subSet(-3, 4));
	}

}
