package request;

import java.util.Map;

public class Request {
	private Map<String, Map<String, String>> params;

	public Map<String, Map<String, String>> getParams() {
		return params;
	}

	public void setParams(Map<String, Map<String, String>> params) {
		this.params = params;
	}
}
