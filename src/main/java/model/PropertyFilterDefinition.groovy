package model

class PropertyFilterDefinition {
	
	String property_name
	List<PropertyConstraintClause> property_constraint_clauses = []
	
	PropertyFilterDefinition(model) {
		if (!(model instanceof Map)) {
			throw new Exception("A property filter definition should be a map")
		}
		if (model.size() > 1) {
			throw new Exception("A property filter definition should define only one property")
		}
		model.each { String property_name, constraints ->
			this.property_name = property_name
			if (constraints instanceof Map) {
				// short notation: <property_name>: <property_constraint_clause>
				property_constraint_clauses = [ new PropertyConstraintClause(constraints) ]
				return
			}
			if (constraints instanceof List) {
				// multi-line grammar
				constraints.each {
					property_constraint_clauses << new PropertyConstraintClause(it)
				}
			}
			throw new Exception("A property filter definition constraint clause should be a map or a list")
		}
	}
	
	String getProperty_name() {
		return this.property_name
	}
	
	List<PropertyConstraintClause> getProperty_constraint_clauses() {
		return this.property_constraint_clauses
	}

}
