package sqlbuilder;

public abstract class Condition implements SQL {

	public ComposedCondition or(Condition condition2) {
		return ComposedCondition.create(this, condition2,
				ConditionLogicalOperator.OR);
	}

	public ComposedCondition and(Condition condition2) {
		return ComposedCondition.create(this, condition2,
				ConditionLogicalOperator.AND);
	}

	public abstract String getSQL();

}
