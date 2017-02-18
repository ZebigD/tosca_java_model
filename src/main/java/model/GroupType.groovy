package model

import java.util.List;

class GroupType extends ToscaType {
	
	GroupType(String name, Map model) {
		super('group', name, model)
	}
	
	static GroupType get(String name) {
		return super.get('group', name)
	}
	
	List<Property> getProperties() {
		return ToscaModel.getProperties(model)
	}

	List<String> getMembers() {
		return ToscaModel.getListOfString("members", model)
	}
	
	List<Interface> getInterfaces() {
		return ToscaModel.getInterfaces(model)
	}

}
