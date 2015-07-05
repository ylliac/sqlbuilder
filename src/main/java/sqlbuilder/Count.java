package sqlbuilder;

public class Count implements Select, ConditionOperand {

	private Select select;

	public static Count create(Select select) {
		return new Count(select);
	}

	protected Count(Select select) {
		this.select = select;
	}

	public String getSQL() {
		return select == null ? "COUNT (*)" : "COUNT(" + select.getSQL() + ")";
	}

}
