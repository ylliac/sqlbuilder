package sqlbuilder;

public class Field implements Select, OrderBy {

	private String name;

	public static Field create(String name) {
		return new Field(name);
	}

	protected Field(String name) {
		this.name = name;
	}

	public Condition equal(Field field2) {
		String condition = this.getSQL() + " = " + field2.getSQL();
		return SimpleCondition.create(condition);
	}

	public Condition equal(int value) {
		String condition = this.getSQL() + " = " + value;
		return SimpleCondition.create(condition);
	}

	public Condition equal(String value) {
		// TODO Echapper les '
		String condition = this.getSQL() + " = '" + value + "'";
		return SimpleCondition.create(condition);
	}

	public SortAsc asc() {
		return SortAsc.create(this);
	}

	public SortDesc desc() {
		return SortDesc.create(this);
	}

	public String getSQL() {
		return name;
	}

}
