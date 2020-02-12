package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	
	public static void main(String[] args) {
		
		System.out.println("\n    starting Log4jDemo   \n");
		logger.info("info message");
		logger.warn("warn message");
		logger.debug("debug message");
		logger.error("error message");
		logger.fatal("fatal message");
		logger.trace("trace message");
		
		
		System.out.println("\n    End f Log4jDemo   \n");
	

	}

}
