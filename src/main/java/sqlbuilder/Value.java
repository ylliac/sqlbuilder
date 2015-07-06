package sqlbuilder;

import org.joda.time.DateTime;

public class Value implements ConditionOperand {

	private String stringValue;

	public static Value create(int value) {
		return new Value(Integer.toString(value));
	}

	public static Value create(String value) {
		return new Value(value);
	}

	public static Value create(DateTime value) {
		return new Value(value.toString("yyyy-MM-dd"));
	}

	protected Value(String value) {
		// TODO Echapper les '
		this.stringValue = value;
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

	@Override
	public String getSQL() {
		return stringValue;
	}

}
