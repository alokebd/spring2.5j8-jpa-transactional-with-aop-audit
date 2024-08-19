package com.ait.tx.aop;

import java.util.Arrays;
import java.util.Date;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ait.tx.dto.FlightBookingRequest;
import com.ait.tx.entity.AuditLog;
import com.ait.tx.service.AuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class AuditAspect {
	
	private final Logger LOGGER = LoggerFactory.getLogger(AuditAspect.class);

	@Autowired
	private AuditService auditService;
	
	private AuditLog createAuditLog(String name, String email) {
		AuditLog log = new AuditLog();
        log.setName(name);
        log.setEmail(email);
        log.setAction("Action description");
        log.setTimestamp(new Date());
        log.setResource(name.concat(" accessed or modified"));
        log.setDetails("Additional details");
        return log;
	}
	
	/*
    @Pointcut("execution(* com.ait.tx.service.FlightBookingService.bookFlightTicket(..)) ")
    private void applyInternalPointCut() {
   	System.out.println("AuditAspect.applyFlightService running .....");
   }  
   
	@Before("applyFlightService() && args (request)")
	public void beforeAdviceWithApplyInternalPointCut(JoinPoint joinPoint, FlightBookingRequest request) {
		//Same code 
		
	}*/
	
		
	@Before("execution(* com.ait.tx.service.FlightBookingService.bookFlightTicket(..)) && args (request)")
    public void beforeAdviceDirectCall(JoinPoint joinPoint, FlightBookingRequest request) {
		LOGGER.info("AuditAspect.beforeAdviceDirectCall running .....");
    	
    	String name = request.getPassengerInfo().getName();
    	String email = request.getPassengerInfo().getEmail();
    	
    	LOGGER.info("method:" + joinPoint.getSignature()+ "\n Adding Passenger  with name- "
   	              + name + ", email- " + email);
   	        	
    	LOGGER.info("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

        AuditLog log = createAuditLog(name, email);
        
        //System.out.println("audit: " + log.toString());
        auditService.saveAuditLog(log);
        LOGGER.info("finish auding logging ....");
	}
	
    

}
