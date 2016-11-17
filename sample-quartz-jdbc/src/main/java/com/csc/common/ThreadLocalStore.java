package com.csc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides methods to store and retrieve data in ThreadLocal
 */
public final class ThreadLocalStore {

	private static final ThreadLocal<Map<Object, Object>> store = new ThreadLocal<Map<Object, Object>>();

	public static final String USER = "USER";
	public static final String SCHEDULENAME = "SCHEDULENAME";
	public static final String SCHEDULENUMBER = "SCHEDULENUMBER";

	/**
	 * Get an object with given key from ThreadLocal
	 */
	public static Object get(Object key) {
		if (store.get() == null) {
			store.set(new HashMap<Object, Object>());
		}

		return store.get().get(key);
	}

	/**
	 * Put an object in ThreadLocal
	 */
	public static void put(Object key, Object value) {
		if (store.get() == null) {
			store.set(new HashMap<Object, Object>());
		}

		store.get().put(key, value);
	}

	/**
	 * Clear all data stored in ThreadLocal
	 */
	public static void clear() {
		store.remove();
	}
}
