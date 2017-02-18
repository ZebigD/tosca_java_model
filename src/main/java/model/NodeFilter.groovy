package model

class NodeFilter {
	
	Map model
	
	NodeFilter(model) {
		if (!(model instanceof Map)) {
			throw new Exception("a node filter should be a map")
		}
		model.each{ k,v ->
			if (k != "properties" && k != "capabilities") {
				throw new Exception("Invalid keyname '$k' in node_filter")
			}
		}
		this.model = model
	}
	
	List<PropertyFilterDefinition> getProperties() {
		if (model.'properties' == null) {
			return []
		}
		if (!(model.'properties' instanceof List)) {
			throw new Exception("'properties' should be a list in node_filter")
		}
		def result = []
		model.'properties'.each {
			result << new PropertyFilterDefinition(it)
		}
		return result
	}
	
	List<Capability> getCapabilities() {
		if (model.'capabilities' == null) {
			return []
		}
		if (!(model.'capabilities' instanceof List)) {
			throw new Exception("'capabilities' should be a list in node_filter")
		}
		def result = []
		model.'capabilities'.each {
			result << new Capability(it)
		}
		return result
	}	
}
