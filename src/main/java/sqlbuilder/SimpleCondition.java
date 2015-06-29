package sqlbuilder;

public class SimpleCondition extends Condition {

	private String condition;

	public static SimpleCondition create(String condition) {
		return new SimpleCondition(condition);
	}

	protected SimpleCondition(String condition) {
		this.condition = condition;
	}

	public String getSQL() {
		return condition;
	}

}
