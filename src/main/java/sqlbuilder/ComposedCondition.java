package sqlbuilder;

public class ComposedCondition implements Condition {

	public enum OPERATOR {
		OR, AND
	}

	private Condition condition1;
	private Condition condition2;
	private OPERATOR operator;

	public static ComposedCondition create(Condition condition1,
			Condition condition2, OPERATOR operator) {
		return new ComposedCondition(condition1, condition2, operator);
	}

	protected ComposedCondition(Condition condition1, Condition condition2,
			OPERATOR operator) {
		this.condition1 = condition1;
		this.condition2 = condition2;
		this.operator = operator;
	}

	public Condition or(Condition condition2) {
		return ComposedCondition.create(this, condition2,
				ComposedCondition.OPERATOR.OR);
	}

	public Condition and(Condition condition2) {
		return ComposedCondition.create(this, condition2,
				ComposedCondition.OPERATOR.AND);
	}

	public String getSQL() {
		if (condition1 == null || condition2 == null || operator == null) {
			throw new IllegalStateException("Condition is not complete");
		}

		String result = condition1.getSQL();

		switch (operator) {
		case OR:
			result += " OR ";
			break;
		case AND:
			result += " AND ";
			break;
		}

		result += condition2.getSQL();

		return result;
	}

}
