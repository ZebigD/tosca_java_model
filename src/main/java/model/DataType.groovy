package model

import java.util.List;

class DataType extends ToscaType {
	
	DataType(String name, Map model) {
		super('data', name, model)
	}
	
	static DataType get(String name) {
		return super.get('data', name)
	}
	
	List<Constraint> getConstraints() {
		return ToscaModel.getConstraints(model)
	}
	
	List<Property> getProperties() {
		return ToscaModel.getProperties(model)
	}

}
