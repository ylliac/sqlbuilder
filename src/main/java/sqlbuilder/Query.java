package sqlbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Arriver à ca : 

//create.select(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME, count())
//.from(AUTHOR)
//.join(BOOK).on(AUTHOR.ID.equal(BOOK.AUTHOR_ID))
//.where(BOOK.LANGUAGE.eq("DE"))
//.and(BOOK.PUBLISHED.gt(date("2008-01-01")))
//.groupBy(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
//.having(count().gt(5))
//.orderBy(AUTHOR.LAST_NAME.asc().nullsFirst())
//.limit(2)
//.offset(1)

//ou ca : http://www.jooq.org/doc/3.0/manual/getting-started/use-cases/jooq-as-a-standalone-sql-builder/

//String sql = create.select(field("BOOK.TITLE"), field("AUTHOR.FIRST_NAME"), field("AUTHOR.LAST_NAME"))
//.from(table("BOOK"))
//.join(table("AUTHOR"))
//.on(field("BOOK.AUTHOR_ID").equal(field("AUTHOR.ID")))
//.where(field("BOOK.PUBLISHED_IN").equal(1948))
//.getSQL();

//(vient de JOOQ : http://www.jooq.org/javadoc/latest/)

/// Memo : ordre d'évaluation des clauses SQL
//FROM clause
//WHERE clause
//GROUP BY clause
//HAVING clause
//SELECT clause
//ORDER BY clause

public class Query implements SQL {

	private List<Select> selects = new ArrayList<>();
	private From from = null;
	private Condition where = null;
	private List<OrderBy> orderBys = new ArrayList<>();

	public static Query create() {
		return new Query();
	}

	protected Query() {

	}

	public Query select(Select... selects) {
		this.selects.addAll(Arrays.asList(selects));
		return this;
	}

	public Query from(From from) {
		if (this.from != null) {
			throw new IllegalStateException("Only one FROM clause is allowed");
		}

		this.from = from;
		return this;
	}

	public Query where(Condition where) {
		if (this.where != null) {
			throw new IllegalStateException("Only one WHERE clause is allowed");
		}

		this.where = where;
		return this;
	}

	public Query orderBy(OrderBy... orderBys) {
		this.orderBys.addAll(Arrays.asList(orderBys));
		return this;
	}

	public String getSQL() {
		StringBuilder query = new StringBuilder();

		// Projections
		query.append("SELECT ");
		for (Select select : selects) {
			query.append(select.getSQL());
		}

		// Joins
		query.append("FROM ");
		// TODO

		// Restrictions
		query.append("WHERE ");
		// TODO

		// Groups
		// TODO

		// Orders
		// TODO

		// Limits
		// TODO

		return query.toString();
	}

}
