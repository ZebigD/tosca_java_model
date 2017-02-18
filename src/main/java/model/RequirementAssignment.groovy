package model

class RequirementAssignment {
	
	Map model
	
	NodeFilter node_filter
	
	RequirementAssignment(String rs) {
		this.model = ["node":rs]	
	}
	
	RequirementAssignment(Map model) {
		this.model = model
	}
	
	String getNode() {
		return model.'node'
	}
	
	String getCapability() {
		return model."capability"
	}
	
	String getRelationship() {
		return model."relationship"
	}
	
	NodeFilter getNode_filter() {
		return ToscaModel.getNode_filter(model)
	}

}
