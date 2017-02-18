package model

import java.util.List
import java.util.Map

class NodeType extends ToscaType {
	
	NodeType(String name, Map model) {
		super('node', name, model)
		this.name = name
		this.model = model
	}
	
	String getDescription() { return model.'description' }
	
	Map<String, String> getProperties() {
		return ToscaModel.getProperties(model)
	}
	
	Map<String, String> getAttributes() {
		return ToscaModel.getAttributes(model)
	}
	
	List<RequirementAssignment> getRequirements() {
		return ToscaModel.getRequirements(model)
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
