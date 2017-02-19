package model

import java.util.Map;

class Policy extends ToscaObject {
		
	Policy(String policy_name, model) {
		super('policy', policy_name, model)
	}
	
	Map<String,String> getProperties() {
		return ToscaModel.getProperties(model)
	}
	
	List<String> getTargets() {
		return ToscaModel.getListOfString('targets', model)
	}

}
