package aop2;

import org.aspectj.lang.ProceedingJoinPoint;

//여기는 핵심관심사만 
public class LogAop {

		// Around Advice에서 사용할 공통기능 메서드는, 대부분 파라미터로 전달받은 
		// ProceedingJoinPoint의 proceed() 메서드만 호출
		// Proxy(복덕방)
		public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
			String signatureStr = joinpoint.getSignature().toShortString();
			// 핵심관심사의 수행 메소드
			System.out.println( signatureStr + " is start.");
			long st = System.currentTimeMillis();
			try {
				// 핵심관심사를 수행시킴
				Object obj = joinpoint.proceed();
				return obj;
			} finally {
				long et = System.currentTimeMillis();
				System.out.println( signatureStr + "is finished.");
				System.out.println( signatureStr + " 경과시간 : " + (et - st));
			}
			
		}

		public void beforeAdvice() {
			System.out.println("beforeAdvice()");
		}
		
		public void afterReturningAdvice() {
			System.out.println("afterReturningAdvice()");
		}
		
		public void afterThrowingAdvice() {
			System.out.println("afterThrowingAdvice()");
		}
		
		public void afterAdvice() {
			System.out.println("afterAdvice()");
		}
	

}
