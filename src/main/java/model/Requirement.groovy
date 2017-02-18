package model

class Requirement {
	
	String name // ex log_endpoint
	String capability // ex tosca.capabilities.Endpoint
	String node // ex tosca.nodes.SoftwareComponent.Logstash
	String relationship // ex tosca.relationships.ConnectsTo
	String occurrences_min
	String occurrences_max
	
	Requirement(model) {
		if (!(model instanceof Map)) {
			throw new Exception("a requirement should be map")
		}
		if (!(model.size() == 1)) {
			throw new Exception("a requirement should have a single map entry")
		}
		model.each { r_name, r ->
			this.name = r_name
			if (!(r instanceof Map)&&!(r instanceof String)) {
				throw new Exception("a requirement definition should be map or a string")
			}
			if (r instanceof String) {
				// simple grammar
				this.capability = r
				return
			}
			// extended grammar
			if (r.'capability' == null) {
				throw new Exception("'capability' is required for a requirement definition")
			}
			this.capability = r.'capability'
			this.node = r.'node'
			if (r.'relationship' != null) {
				def rl = r.'relationship'
				if (!(rl instanceof Map)&&!(rl instanceof String)) {
					throw new Exception("a requirement relationship should be map or a string")
				}
				if (rl instanceof Map && rl.'type' == null) {
					throw new Exception("a requirement relationship definition must have a type")
				}
				this.relationship = rl
			}
			if (r.'occurrences' != null) {
				if (!(r.'occurrences' instanceof List)) {
					throw new Exception("'occurrences' should be a list")
				}
				if (!(r.'occurrences'.size() == 2)) {
					throw new Exception("'occurrences' should have a min and a max")
				}
				this.occurrences_min = r.'occurrences'[0].toString()
				this.occurrences_max = r.'occurrences'[1].toString()
			} 
		}
	}

	public String getName() {
		return name;
	}

	public String getCapability() {
		return capability;
	}

	public String getNode() {
		return node;
	}

	public String getRelationship() {
		return relationship;
	}

	public String getRelationship_type_name() {
		if (this.relationship == null) {
			return null
		}
		if (this.relationship instanceof String) {
			return this.relationship
		}
		return relationship.'type'
	}

	public Map<String,Interface> getRelationship_interfaces() {
		// TODO
	}

	public String getOccurrences_min() {
		return occurrences_min;
	}

	public String getOccurrences_max() {
		return occurrences_max;
	}

}
