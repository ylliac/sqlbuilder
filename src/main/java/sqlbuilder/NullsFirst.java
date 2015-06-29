package sqlbuilder;

public class NullsFirst implements OrderBy {

	private Field field;

	public static NullsFirst create(Field field) {
		return new NullsFirst(field);
	}

	protected NullsFirst(Field field) {
		this.field = field;
	}

	public String getSQL() {
		return field.getSQL() + " NULLS FIRST";
	}

}
