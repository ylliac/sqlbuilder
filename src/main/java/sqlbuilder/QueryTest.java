package sqlbuilder;

public class QueryTest {

	public static void main(String[] args) {

		String sql = Query
				.create()
				.select(DSL.field("BOOK.TITLE"),
						DSL.field("AUTHOR.FIRST_NAME"),
						DSL.field("AUTHOR.LAST_NAME"))
				.from(DSL
						.table("BOOK")
						.join(DSL.table("AUTHOR"))
						.on(DSL.field("BOOK.AUTHOR_ID").equal(
								DSL.field("AUTHOR.ID"))))
				.where(DSL.field("BOOK.PUBLISHED_IN").equal(1948)).getSQL();

		System.out.println(sql);

		sql = Query
				.create()
				.select(DSL.field("AUTHOR.FIRST_NAME"),
						DSL.field("AUTHOR.LAST_NAME"), DSL.count())
				.from(DSL
						.table("AUTHOR")
						.join(DSL.table("BOOK"))
						.on(DSL.field("AUTHOR.ID").equal(
								DSL.field("BOOK.AUTHOR_ID"))))
				.where(DSL.field("BOOK.LANGUAGE").equal("DE"))
				.and(DSL.field("BOOK.PUBLISHED").gt(date("2008-01-01")))
				.groupBy(DSL.field("AUTHOR.FIRST_NAME"),
						DSL.field("AUTHOR.LAST_NAME")).having(DSL.count().gt(5))
				.orderBy(DSL.field("AUTHOR.LAST_NAME").asc().nullsFirst())
				.limit(2).offset(1).getSQL();

		System.out.println(sql);
	}
}
