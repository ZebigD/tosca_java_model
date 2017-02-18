package model

import utils.Logger

abstract class ToscaModel {

	static checkRequired(Map model, List<String> keynames) {
		def ok = true
		keynames.each {
			if (model[it] == null) {
				Logger.error "Keyname '$it' is missing"
				ok = false
			}
		}
		if (!ok) {
			throw new Exception("Some required information is missing")
		}
	}

	static Map<String, Attribute> getAttributes(Map model) {
		if (model.'attributes' == null) {
			return [:]
		}
		if (!(model.'attributes' instanceof Map)) {
			throw new Exception("'attributes' should be a map")
		}
		Map<String, Attribute> result = [:]
		Map atts = model.'attributes'
		atts.each { String att_name, att_def ->
			result[att_name] = new Attribute(att_name, att_def)
		}
		return result
	}

	static Map<String, Property> getProperties(Map model) {
		if (model.'properties' == null) {
			return [:]
		}
		if (!(model.'properties' instanceof Map)) {
			throw new Exception("'properties' should be a map")
		}
		Map<Property> result = [:]
		Map props = model.'properties'
		props.each { String prop_name, prop_def ->
			result[prop_name] = new Property(prop_name, prop_def)
		}
		return result
	}
	
	static List<RequirementAssignment> getRequirementAssignments(Map model) {
		if (model.'requirements' == null) {
			return []
		}
		if (!(model.'requirements' instanceof List)) {
			throw new Exception("'requirements' should be a list")
		}
		List requirements = model.'requirements'
		List<RequirementAssignment> result = []
		requirements.each { r ->
			if (!(r instanceof Map)&&!(r instanceof String)) {
				"a requirement should be map or a string"
			}
			result << new RequirementAssignment(r)
		}
		return result
	}
	
	static List<Requirement> getRequirements(Map model) {
		if (model.'requirements' == null) {
			return []
		}
		if (!(model.'requirements' instanceof List)) {
			throw new Exception("'requirements' should be a list")
		}
		List requirements = model.'requirements'
		List<Requirement> result = []
		requirements.each { r ->
			result << new Requirement(r)
		}
		return result
	}

	static List<CapabilityAssignment> getCapabilityAssignments(Map model) {
		if (model.'capabilities' == null) {
			return []
		}
		if (!(model.'capabilities' instanceof List)) {
			throw new Exception("'requirements' should be a list")
		}
		List capabilities = model.'capabilities'
		def result = []
		capabilities.each { c ->
			result << new CapabilityAssignment(c)
		}
		return result
	}
	
	static List<String> getListOfString(String name, Map model) {
		if (model[name] == null) {
			return []
		}
		if (!(model[name] instanceof List)) {
			throw new Exception("'$name' should be a list")
		}
		List<String> result = []
		model[name].each { result << it.toString() }
		return result
	}
	
	static Map<String, String> getPropertyAssignments(model) {
		if (!(model instanceof Map)) {
			throw new Exception("A property assignment should be a map")
		}
		if (model['properties'] == null) {
			return [:]
		}
		if (!(model['properties'] instanceof Map)) {
			throw new Exception("properties' should be a map")
		}
		def result = [:]
		model['properties'].each {k,v ->
			result[k] = v.toString()
		}
		return result
	}
	
	static Map<String, String> getAttributeAssignments(model) {
		if (!(model instanceof Map)) {
			throw new Exception("An attribute assignment should be a map")
		}
		if (model['attributes'] == null) {
			return [:]
		}
		if (!(model['attributes'] instanceof Map)) {
			throw new Exception("attributes' should be a map")
		}
		def result = [:]
		model['attributes'].each {k,v ->
			result[k] = v.toString()
		}
		return result
	}
	
	static List<Constraint> getConstraints(Map model) {
		if (model.'constraints' == null) {
			return []
		}
		if (!(model.'constraints' instanceof List)) {
			throw new Exception("'constraints' should be a list")
		}
		List constraints = model.'constraints'
		List<Constraint> result = []
		constraints.each { c ->
			if (!(c instanceof Map)) {
				"a constraint should be map"
			}
			result << new Constraint(c)
		}
		return result
	}
	
	static List<Interface> getInterfaces(Map model) {
		if (model.'interfaces' == null) {
			return []
		}
		if (!(model.'interfaces' instanceof List)) {
			throw new Exception("'interfaces' should be a list")
		}
		List interfaces = model.'interfaces'
		List<Interface> result = []
		interfaces.each { String iname, i ->
			if (!(i instanceof Map)) {
				"Interface '$iname' should be a map"
			}
			result << new Interface(iname, i)
		}
		return result
	}

	static Map<String,Artifact> getArtifacts(Map model) {
		if (model.'artifacts' == null) {
			return [:]
		}
		if (!(model.'artifacts' instanceof Map)) {
			throw new Exception("'artifacts' should be a map")
		}
		def result = []
		model.'artifacts'.each { String aname, a ->
			if (!(a instanceof Map) && !(a instanceof String)) {
				"Artifact '$aname' should be a map or a string"
			}
			result[aname] = new Artifact(aname, a)
		}
		return result
	}
	
	static NodeFilter getNode_filter(model) {
		if (model."node_filter" == null) {
			return null
		}
		return new NodeFilter(model."node_filter")
	}
}
