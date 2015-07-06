package sqlbuilder;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

public class DSL {

	public static Field field(String name) {
		return Field.create(name);
	}

	public static Table table(String name) {
		return Table.create(name);
	}

	public static Count count() {
		return Count.create(null);
	}

	public static Count count(Projection select) {
		return Count.create(select);
	}

	public static Value date(String value) {
		DateTimeParser[] parsers = {
				DateTimeFormat.forPattern("yyyy-MM-dd HH").getParser(),
				DateTimeFormat.forPattern("yyyy-MM-dd").getParser() };
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().append(
				null, parsers).toFormatter();

		DateTime date = formatter.parseDateTime(value);
		return Value.create(date);
	}

}
