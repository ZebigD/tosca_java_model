package model

class EntrySchema {
	
	String type
	String description
	List<Constraint> constraints = []
	
	EntrySchema(String model) {
		type = model // syntax: entry_schema: <datatype name>
	}
	
	EntrySchema(Map model) {
		if (model.'type' == null) {
			throw new Exception("invalid entry_schema: 'type' missing")
		}
		type = model.'type'.toString()
		description = model.'description'?.toString()
		constraints = ToscaModel.getConstraints(model)
	}
	
	String getType() { return type }
	
	String getDescription() { return description } 
	
	List<Constraint> getConstraints() { return constraints }

}
