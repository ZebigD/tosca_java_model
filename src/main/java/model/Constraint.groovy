package model

class Constraint {

	String operator
	String operand

	Constraint(Map model) {
		if (model.size() != 1) {
			throw new Exception("Invalid constraint clause: '"+model+"'")
		}
		model.each { k,v ->
			if (k == "equal"
			|| k == "greater_than"
			|| k == "greater_or_equal"
			|| k == "less_than"
			|| k == "less_or_equal"
			|| k == "length"
			|| k == "min_length"
			|| k == "max_length"
			|| k == "pattern"
			) {
				operator = k
				operand = v.toString()
				return
			}
			if (k == "in_range" || k == "valid_values") {
				if (!(v instanceof List)) {
					throw new Exception("For the constraint operator '$k', clause should be a list")
				}
				operator = k
				operand = v.toString()
				return
			}
			throw new Exception("Constraint operator '$k' is invalid")
		}
	}
}
