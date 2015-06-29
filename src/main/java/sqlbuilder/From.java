package sqlbuilder;

import java.util.ArrayList;
import java.util.List;

public class From implements SQL {

	private List<Table> tables;
	private List<Join> joins = new ArrayList<>();

	public static From create(Table table) {
		return new From(table);
	}

	protected From(Table table) {
		tables = new ArrayList<>();
		tables.add(table);
	}

	public Join join(Table table2) {
		Table table1 = tables.get(tables.size() - 1);
		return Join.create(table1, table2, JoinType.INNER_JOIN, this);
	}

	// Méthode package pour que Join puisse s'ajouter dans From
	void registerJoin(Join join) {
		joins.add(join);
	}

	public String getSQL() {
		// TODO
		return null;
	}

}
