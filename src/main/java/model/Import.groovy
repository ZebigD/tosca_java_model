package model

class Import {
	
	String name
	String file
	String repository
	String namespace_uri
	String namespace_prefix
	
	Import(String name, String file) {
		this.file = file
	}
	
	Import(String name, Map model) {
		if (model.'file' == null) {
			throw new Exception("invalid import: 'file' missing")
		}
		this.file = model.'file'.toString()
		this.repository = model.'repository'?.toString()
		this.namespace_uri = model.'namespace_uri'?.toString()
	}
	
	String getFile() { return this.file }
	String getRepository() { return this.repository }
	String getNamespace_uri() { return this.namespace_uri }
	String geNamespace_prefix() { return this.namespace_prefix }
	
}
