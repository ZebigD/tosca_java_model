package model

class Repository {
	
	static Map<String,Repository> instances = [:]
	
	String name
	Map model
	
	Repository(String name, Map model) {
		ToscaModel.checkRequired(model, ['url'])
		this.name = name
		this.model = model
		instances[name] = this
	}
	
	String getDescription() { return model.'description' }
	String getUrl() { return model.'url' }
	Credential getCredential() { return Credential.get(model.'credential') }
	
	static Repository get(String name) {
		if (instances[name] == null) {
			throw new Exception("Repository '$name' does not exist")
		}
		return instances[name]
	}

}
