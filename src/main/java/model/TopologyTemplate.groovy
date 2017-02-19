package model

class TopologyTemplate {
	
	Map model
	
	List<Parameter> inputs
	List<NodeTemplate> node_templates
	List<RelationshipTemplate> relationship_templates
	List<Group> groups
	List<Policy> policies
	List<Parameter> outputs
	Map substitution_mappings
	
	TopologyTemplate(Map model) {
		this.model = model
	}
	
	String getDescription() {
		return model.'description'
	}
	
	List<Parameter> getInputs() {
		def result = []
		model.'inputs'.each { String input_name, input_def ->
			result << new Parameter(input_name, input_def)
		}
		return result
	}

}
