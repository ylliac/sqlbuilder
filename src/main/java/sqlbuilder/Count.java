package sqlbuilder;

public class Count implements Projection, ConditionOperand {

	private Projection select;

	public static Count create(Projection select) {
		return new Count(select);
	}

	protected Count(Projection select) {
		this.select = select;
	}

	public Condition equal(ConditionOperand operand2) {
		return ConditionBuilder.create(this).equal(operand2);
	}

	public Condition equal(int value) {
		return ConditionBuilder.create(this).equal(value);
	}

	public Condition equal(String value) {
		return ConditionBuilder.create(this).equal(value);
	}

	public Condition greaterThan(int value) {
		return ConditionBuilder.create(this).greaterThan(value);
	}
	
	public Condition greaterThan(String value) {
		return ConditionBuilder.create(this).greaterThan(value);
	}
	
	public Condition greaterThan(ConditionOperand value) {
		return ConditionBuilder.create(this).greaterThan(value);
	}

	public String getSQL() {
		return select == null ? "COUNT (*)" : "COUNT(" + select.getSQL() + ")";
	}

}
