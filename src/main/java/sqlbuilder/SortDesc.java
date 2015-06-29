package sqlbuilder;

public class SortDesc implements OrderBy {

	private Field field;

	public static SortDesc create(Field field) {
		return new SortDesc(field);
	}

	protected SortDesc(Field field) {
		this.field = field;
	}

	public String getSQL() {
		return field.getSQL() + " DESC";
	}

}
