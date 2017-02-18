package model

import java.util.List;

class NodeTemplate extends ToscaObject {
	
	NodeTemplate(String name, Map model) {
		super('node_template', name, model)
	}
	
	List<String> getDirectives() {
		return ToscaModel.getListOfString("directives", model)
	}	
	
	Map<String, String> getPropertyAssignments() {
		return ToscaModel.getPropertyAssignments(model)
	}
	
	Map<String, String> getAttributeAssignments() {
		return ToscaModel.getAttributeAssignments(model)
	}
	
	List<RequirementAssignment> getRequirements() {
		return ToscaModel.getRequirementAssignments(model)
	}
	
	List<CapabilityAssignment> getCapabilities() {
		return ToscaModel.getCapabilityAssignments(model)
	}
	
	List<Interface> getInterfaces() {
		return ToscaModel.getInterfaces(model)
	}
	
	List<Artifact> getArtifacts() {
		return ToscaModel.getArtifacts(model)
	}
	
	NodeFilter getNode_filter() {
		return ToscaModel.getNode_filter(model)
	}
	
	String getCopy() {
		return model.'copy'.toString()
	}

}
