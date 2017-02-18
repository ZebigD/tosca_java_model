package model

import java.util.Map;

class ArtifactType extends ToscaType {
	
	ArtifactType(String name, model) {
		super('artifact', name, model)
	}
	
	static ArtifactType get(String name) {
		return super.get('artifact', name)
	}
	
	String getMime_type() { return model.'mime_type' }
	
	List<String> getFile_ext() { 
		return ToscaModel.getListOfString("file_ext", model)
	}
	
	List<Property> getProperties() {
		return ToscaModel.getProperties(model)
	}

}
