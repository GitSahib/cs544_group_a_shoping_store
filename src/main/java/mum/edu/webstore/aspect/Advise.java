package mum.edu.webstore.aspect;

import org.apache.log4j.Logger;

public abstract class Advise {
	protected Logger logger;
	public <T> Advise(Class<T> className) {
		logger = Logger.getLogger(className);
	}
}
