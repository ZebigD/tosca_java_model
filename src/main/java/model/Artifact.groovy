package model

class Artifact extends ToscaObject {

	Artifact(String name, model) {
		super('artifact', name, model)
		ToscaModel.checkRequired(model, ['file'])
	}

	Artifact(String name, String file_uri) {
		ToscaModel.checkRequired(model, ['type', 'file'])
		this.name = name
		this.model = ["file":file_uri,"type":""]
	}

	String getFile() {
		return model.'file'
	}

	Repository getRepository() {
		return Repository.get(model.'repository')
	}

	String getDeploy_path() {
		return model.'deploy_path'
	}

	static Artifact get(String name) {
		return super.getInstance('artifact',name)
	}
}
