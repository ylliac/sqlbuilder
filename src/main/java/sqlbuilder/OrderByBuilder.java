package sqlbuilder;

public class OrderByBuilder implements OrderBy {

	private enum ORDER {
		ASC, DESC
	}

	private enum NULLS {
		FIRST, LAST
	}

	private Field field;

	private ORDER order;

	private NULLS nulls;

	public static OrderByBuilder create(Field field) {
		return new OrderByBuilder(field);
	}

	protected OrderByBuilder(Field field) {
		this.field = field;
	}

	public OrderBy asc() {
		this.order = ORDER.ASC;
		return this;
	}

	public OrderBy desc() {
		this.order = ORDER.DESC;
		return this;
	}

	public OrderBy nullsFirst() {
		this.nulls = NULLS.FIRST;
		return this;
	}

	public OrderBy nullsLast() {
		this.nulls = NULLS.LAST;
		return this;
	}

	public String getSQL() {
		String result = field.getSQL();

		switch (order) {
		case ASC:
			result += " ASC";
			break;
		case DESC:
			result += " DESC";
			break;
		}

		switch (nulls) {
		case FIRST:
			result += " NULLS FIRST";
			break;
		case LAST:
			result += " NULLS LAST";
			break;
		}

		return result;
	}

}
