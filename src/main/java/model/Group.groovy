package model

import java.util.List;
import java.util.Map;

class Group extends ToscaObject {
		
	public Group(String name, Map model) {
		super('group', name, model)
	}
	
	Map<String,String> getProperties() {
		return ToscaModel.getProperties(model)
	}
	
	List<String> getMembers() {
		return ToscaModel.getListOfString("members", model)
	}
	
	List<Interface> getInterfaces() {
		return ToscaModel.getInterfaces(model)
	}

}
