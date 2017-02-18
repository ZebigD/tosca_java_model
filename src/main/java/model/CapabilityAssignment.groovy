package model

class CapabilityAssignment {
	
	Map model
	
	CapabilityAssignment(model) {
		if (!(model instanceof Map)) {
			"a capability assignment should be map"
		}

		this.model = model
	}
	
	Map<String,String> getProperties() {
		return ToscaModel.getPropertyAssignments(model)
	}

	Map<String,String> getAttributes() {
		return ToscaModel.getAttributeAssignments(model)
	}

}
