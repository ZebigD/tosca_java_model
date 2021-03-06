package model

import java.util.List

class CapabilityType extends ToscaType {
	
	List<Attribute> attributes
	List<String> valid_source_types
	
	CapabilityType(String name, model) {
		super('capability', name, model)
	}
	
	CapabilityType get(String ,name) {
		return super.get('capability', name)
	}
	
	List<Property> getProperties() {
		return ToscaModel.getProperties(model)
	}
	
	List<Attribute> getAttributes() {
		return ToscaModel.getAttributes(model)
	}

}
