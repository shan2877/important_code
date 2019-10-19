package com.shan.codetest;


import java.io.IOException;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

class GFG {

	// Driver code
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		// Creating a string stream

	
		
		Cache<Object, Object> cache = createCache();
		System.out.println("Cache Contains=== " + cache.containsKey("hello")); 
		cache.put("hello", "world");
		cache.containsKey("hello"); // returns true
		System.out.println(cache.get("hello")); // returns "world"
	}
	
	private static Cache<Object, Object> createCache() throws IOException {
	    EmbeddedCacheManager cacheManager = new DefaultCacheManager("infinispan.xml");
	    cacheManager.getMembers().stream().forEach((s) ->{System.out.println(s);} );
	    Cache<Object, Object> cache = cacheManager.getCache();
	    return cache;
	    
	}
}
