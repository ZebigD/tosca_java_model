package model

class Credential {
	
	static Map<String,Credential> instances = [:]
	
	String name
	Map model
	
	Credential(String name, Map model) {
		ToscaModel.checkRequired(model, ['token_type', 'token'])
		this.name = name
		instances[name] = this
	}
	
	String getProtocol() { return model.'protocol' }
	
	String getToken_type() { return model.'token_type' }
	
	String getToken() { return model.'token' }
	
	Map<String,String> getKeys() {
		if (model.'keys' == null) {
			return [:]
		}
		if (!(model.'keys' instanceof Map)) {
			throw new Exception("Credential 'keys' should be a map")
		}
		def result = [:]
		Map keys = model.'keys'
		keys.each { k, v ->
			result[k.toString()] = v.toString()
		}
		return result
	}
	
	String getUserh() { return model.'userh' }
	
	static Credential get(String name) {
		if (instances[name] == null) {
			throw new Exception("Credential '$name' does not exist")
		}
		return instances[name]
	}
	
}
