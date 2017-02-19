package builder

import org.yaml.snakeyaml.Yaml

import parser.ToscaParser

/**
 * Helper class to build tosca service templates as maps
 *  
 * @author zebig
 *
 */
class ToscaTestBuilder extends NodeBuilder {

	Map model

	ToscaTestBuilder() {
		model = [:]
	}

	void service_template(Map p) {
		p.each { k,v -> model[k] = v }
	}

	void node_template(String name, String node_type, Map p = [:]) {
		if  (model.'topology_template' == null) {
			model.'topology_template' = [:]
			model.'topology_template'.'node_templates' = [:]
		}
		model.'topology_template'.'node_templates'."$name" = [ 'type':node_type ]
		p.each { k,v ->
			model.'topology_template'.'node_templates'."$name"."$k" = v
		}
	}

	void compute(String name) {
		node_template(name, 'tosca.nodes.Compute')
	}

	void capability(String node_name, String cap_name, Map p) {
		assert model.'topology_template'.'node_templates'."$node_name" != null
		if (model.'topology_template'.'node_templates'."$node_name"."capabilities" == null) {
			model.'topology_template'.'node_templates'."$node_name"."capabilities" = [:]
		}
		model.'topology_template'.'node_templates'."$node_name"."capabilities"."$cap_name" = [ 'properties':[:]]
		def cap = model.'topology_template'.'node_templates'."$node_name"."capabilities"."$cap_name"
		p.each { k,v ->
			cap."properties"."$k" = v
		}
	}
	
	static Map simple_host() {
		return [num_cpus:1, disk_size:'10 GB', mem_size:'4096 MB']
	}

	static Map simple_os() {
		return [architecture:'x86_64', type:'linux', distribution:'rhel', version:'7.2']
	}

	static Map simple_compute() {
		def b = new ToscaTestBuilder()
		b.service_template(
				tosca_definitions_version: 'tosca_simple_yaml_1_0',
				description: 'Template for deploying a single server with predefined properties.')
		b.compute("my_server")
		b.capability("my_server", "host", simple_host())
		b.capability("my_server", "os", simple_os())
		return b.model
	}
}

def model = ToscaTestBuilder.simple_compute()
def src = new Yaml().dump(model)

assert ToscaParser.validate_tosca_yaml(src);
assert ToscaParser.validate_service_template(model);
