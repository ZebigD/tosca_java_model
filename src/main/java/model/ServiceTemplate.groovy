package model

class ServiceTemplate {

	String tosca_definitions_version
	Map<String,String> metadata
	String description
	Map dsl_definitions
	List<Repository> repositories = []
	List<Import> imports = []
	List<ArtifactType> artifact_types = []
	List<DataType> data_types = []
	List<CapabilityType> capability_types = []
	List<InterfaceType> interface_types = []
	List<RelationshipType> relationship_types = []
	List<NodeType> node_types = []
	List<GroupType> group_types = []
	List<PolicyType> policy_types = []
	TopologyTemplate topology_template

	ServiceTemplate(Map model) {
		tosca_definitions_version = model.'tosca_definitions_version'
		metadata = model.'metadata'
		description = model.'description'
		dsl_definitions = model.'dsl_definitions'
		model.'repositories'.each {	repo_name, repo_model -> repositories << new Repository(repo_name, repo_model) }
		model.'imports'.each { import_name, import_model -> imports << new Import(import_name, import_model) }
		model.'artifact_types'.each { artifact_types << new ArtifactType(it) }
		model.'data_types'.each { data_types << new DataType(it) }
		model.'capability_types'.each { capability_types << new CapabilityType(it) }
		model.'interface_types'.each { interface_types << new InterfaceType(it) }
		model.'relationship_types'.each { relationship_types << new RelationshipType(it) }
		model.'node_types'.each { node_types << new NodeType(it) }
		model.'group_types'.each { group_types << new GroupType(it) }
		model.'policy_types'.each { policy_types << new PolicyType(it) }
		if (model.'topology_template') {
			topology_template = new TopologyTemplate(model.'topology_template')
		}
	}
}
