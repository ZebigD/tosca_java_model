package model

import java.util.List

class Capability extends ToscaObject {
	
	Capability(String name, model) {
		super('capability', name, model)
	}

	List<Property> getProperties() {
		return ToscaModel.getProperties(model)
	}
	
	List<Attribute> getAttributes() {
		return ToscaModel.getAttributes(model)
	}
	
	List<String> getValid_source_types() {
		if (model.'valid_source_types' == null) {
			return []
		}
		if (!(model.'valid_source_types' instanceof List)) {
			throw new Exception("'valid_source_types' should be a list")
		}
		List<String> result = []
		model.'valid_source_types'.each {
			result << it.toString()
		}
		return result
	}
	
	Range getOccurrences() {
		if (model.'occurrences' == null) {
			return null
		}
		return new Range(model.'occurrences')
	}
	
}
