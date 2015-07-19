package io.pivotal.socialmedia.buslogic;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.RegionEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import java.util.Properties;
import java.io.Console;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingCacheListener<K, V> extends CacheListenerAdapter<K, V>
			implements Declarable {
		private Logger logger = Logger.getLogger(LoggingCacheListener.class.getName());

		public void afterCreate(EntryEvent<K, V> e) {
			System.out.println("    Received afterCreate event for entry: "
					+ e.getKey() + ", " + e.getNewValue());
			logger.info(e.getKey() + ", " + e.getNewValue());
		}

		public void afterUpdate(EntryEvent<K, V> e) {
			System.out.println("    Received afterUpdate event for entry: "
					+ e.getKey() + ", " + e.getNewValue());
		}

		public void afterDestroy(EntryEvent<K, V> e) {
			System.out.println("    Received afterDestroy event for entry: "
					+ e.getKey());
		}

		public void afterInvalidate(EntryEvent<K, V> e) {
			System.out.println("    Received afterInvalidate event for entry: "
					+ e.getKey());
		}

		public void afterRegionLive(RegionEvent e) {
			System.out
					.println("    Received afterRegionLive event, sent to durable clients after \nthe server has finished replaying stored events.  ");
		}

		
		public void init(Properties props) {
			String filename = props.getProperty("filename");
			initializeLogger(filename);
		}
		
		private void initializeLogger(String filename) {
			FileHandler fh;
	        logger.setLevel(Level.INFO);
			try {
				fh = new FileHandler(filename, true);
				fh.setFormatter(new SimpleFormatter());
				logger.addHandler(fh);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} 
			
		}
	 }

