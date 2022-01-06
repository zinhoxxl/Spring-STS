package och06_AOP1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	// Around Advice에서 사용할 공통기능 메서드는, 대부분 파라미터로 전달받은 
	// ProceedingJoinPoint의 proceed() 메서드만 호출
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toString();
		// 핵심관심사의 수행 메소드
		System.out.println( signatureStr + " is start.");
		long st = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println( signatureStr + "is finished.");
			System.out.println( signatureStr + " 경과시간 : " + (et - st));
		}
		
	}

}
