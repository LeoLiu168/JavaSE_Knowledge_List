package org.leo.demo.db.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
	//value值的+号表示Performance的所有实现类
	@DeclareParents(value="org.leo.demo.db.aop.Performance+", defaultImpl=DefaultEncoreable.class)
	public static Encoreable encoreable;

}
