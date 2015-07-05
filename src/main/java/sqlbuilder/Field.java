package sqlbuilder;

public class Field implements Select, OrderBy, ConditionOperand {

	private String name;

	public static Field create(String name) {
		return new Field(name);
	}

	protected Field(String name) {
		this.name = name;
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

	public OrderBy asc() {
		return OrderByBuilder.create(this).asc();
	}

	public OrderBy desc() {
		return OrderByBuilder.create(this).desc();
	}

	public OrderBy nullsFirst() {
		return OrderByBuilder.create(this).nullsFirst();
	}

	public OrderBy nullsLast() {
		return OrderByBuilder.create(this).nullsLast();
	}

	public String getSQL() {
		return name;
	}

}
