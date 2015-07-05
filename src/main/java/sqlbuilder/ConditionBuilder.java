package sqlbuilder;

public class ConditionBuilder implements Condition {

	private enum OPERATOR {
		EQUAL
	}

	private ConditionOperand operand1;
	private ConditionOperand operand2;
	private OPERATOR operator;

	public static ConditionBuilder create(ConditionOperand operand) {
		return new ConditionBuilder(operand);
	}

	protected ConditionBuilder(ConditionOperand operand) {
		this.operand1 = operand;
	}

	public ConditionBuilder equal(ConditionOperand operand2) {
		this.operand2 = operand2;
		this.operator = OPERATOR.EQUAL;
		return this;
	}

	public ConditionBuilder equal(int value) {
		this.operand2 = value;
		this.operator = OPERATOR.EQUAL;
		return this;
	}

	public ConditionBuilder equal(String value) {
		// TODO Echapper les '
		this.operand2 = value;
		this.operator = OPERATOR.EQUAL;
		return this;
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
		if (operand1 == null || operand2 == null || operator == null) {
			throw new IllegalStateException("Condition is not complete");
		}

		String result = operand1.getSQL();

		switch (operator) {
		case EQUAL:
			result += " = ";
			break;
		}

		result += operand2.getSQL();

		return result;
	}

}
