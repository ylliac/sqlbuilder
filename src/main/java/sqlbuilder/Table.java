package sqlbuilder;

public class Table implements SQL {

	private String name;

	public static Table create(String name) {
		return new Table(name);
	}

	protected Table(String name) {
		this.name = name;
	}

	public Join join(Table table2) {
		From parent = From.create(this);
		return Join.create(this, table2, JoinType.INNER_JOIN, parent);
	}

	public String getSQL() {
		return name;
	}

}
