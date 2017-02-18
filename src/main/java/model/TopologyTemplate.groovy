package model

class TopologyTemplate {
	
	String type
	String description
	List<Parameter> inputs
	List<NodeTemplate> node_templates
	List<RelationshipTemplate> relationship_templates
	List<Group> groups
	List<Policy> policies
	List<Parameter> outputs
	Map substitution_mappings

}
