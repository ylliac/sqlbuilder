package sqlbuilder;

public class SortAsc implements OrderBy {

	private Field field;

	public static SortAsc create(Field field) {
		return new SortAsc(field);
	}

	protected SortAsc(Field field) {
		this.field = field;
	}

	public String getSQL() {
		return field.getSQL() + " ASC";
	}

}
