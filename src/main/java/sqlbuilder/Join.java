package sqlbuilder;

public class Join implements SQL {

	private From parent;
	private Table table1;
	private Table table2;
	private Condition condition;
	private JoinType type;

	public static Join create(Table table1, Table table2, JoinType type,
			From parent) {
		return new Join(table1, table2, type, parent);
	}

	protected Join(Table table1, Table table2, JoinType type, From parent) {
		this.table1 = table1;
		this.table2 = table2;
		this.type = type;
		this.parent = parent;
	}

	public From on(Condition condition) {
		this.condition = condition;

		parent.registerJoin(this);
		return parent;
	}

	public String getSQL() {
		// TODO
		return null;
	}

}
