package firstartifactlogs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class log4j2usinglogger {

	private static final Logger log=LogManager.getLogger(log4j2usinglogger.class);
	
	@Test
	public void log4jtest() {
		log.trace("this is TRACE msg------");
		log.trace("this is DEBUG msg------");
		log.trace("starting with log4j tests----");
		log.trace("this is WARN msg------");
		log.trace("this is ERROR msg------");
		log.trace("this is FATAL msg------");
		
		try {
			int res=10/0;
		}
		catch(Exception e) {
			log.error("exception occured---"+e);
		}
	}
	
	
	@Test
	public void parameterizedlog() {
		String user="vaishnaviiieeee";
		int attempts=7;
		log.info("user {} attempted login {} times----",user,attempts);
		log.debug("data acheived from user - {}", user);
	}
}
