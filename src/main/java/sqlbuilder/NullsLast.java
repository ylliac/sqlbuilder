package sqlbuilder;

public class NullsLast implements OrderBy {

	private Field field;

	public static NullsLast create(Field field) {
		return new NullsLast(field);
	}

	protected NullsLast(Field field) {
		this.field = field;
	}

	public String getSQL() {
		return field.getSQL() + " NULLS LAST";
	}

}
