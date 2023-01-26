package pam.test.automation;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper class for thread safe passing data between step definitions.
 */
public enum TestContext {

	INSTANCE;

	public static final ThreadLocal<Map<String, Object>> THREAD_LOCAL_DATA_MAP = new ThreadLocal<Map<String, Object>>() {
		@Override
		protected Map<String, Object> initialValue() {
			return new HashMap<String, Object>();
		};
	};

	@SuppressWarnings("unchecked")
	public <T> T getContext(String key) {
		Object value = THREAD_LOCAL_DATA_MAP.get().get(key);

		return (T) value;
	}

	public Object setContext(String key, Object value) {
		return THREAD_LOCAL_DATA_MAP.get().put(key, value);
	}

	public void clearData() {
		THREAD_LOCAL_DATA_MAP.get().clear();
	}
}
