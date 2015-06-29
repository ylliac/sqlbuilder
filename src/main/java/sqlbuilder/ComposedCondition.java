package sqlbuilder;

public class ComposedCondition extends Condition {

	private Condition condition1;
	private Condition condition2;
	private ConditionLogicalOperator operator;

	public static ComposedCondition create(Condition condition1,
			Condition condition2, ConditionLogicalOperator operator) {
		return new ComposedCondition(condition1, condition2, operator);
	}

	protected ComposedCondition(Condition condition1, Condition condition2,
			ConditionLogicalOperator operator) {
		this.condition1 = condition1;
		this.condition2 = condition2;
		this.operator = operator;
	}

	public String getSQL() {
		// TODO
		return null;
	}

}
