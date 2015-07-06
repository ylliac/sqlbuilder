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

//Validateur MySQL : http://fr.piliapp.com/mysql-syntax-check/

public class Query implements SQL {

	private List<Projection> selects = new ArrayList<>();
	private From from = null;
	private Condition where = null;
	private List<OrderBy> orderBys = new ArrayList<>();
	private List<GroupBy> groupBys = new ArrayList<>();
	private Condition having = null;
	private Integer limit = null;
	private Integer offset = null;

	public static Query create() {
		return new Query();
	}

	protected Query() {

	}

	public Query select(Projection... selects) {
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

	public Query groupBy(GroupBy... groupBys) {
		this.groupBys.addAll(Arrays.asList(groupBys));
		return this;
	}

	public Query having(Condition condition) {
		this.having = condition;
		return this;
	}

	public Query limit(int limit) {
		this.limit = limit;
		return this;
	}

	public Query offset(int offset) {
		this.offset = offset;
		return this;
	}

	public String getSQL() {
		StringBuilder query = new StringBuilder();

		// Projections
		query.append("SELECT ");
		if (selects.isEmpty()) {
			query.append("*");
		} else {
			for (Projection select : selects) {
				query.append(select.getSQL());
				//TODO mettre des virgules
			}
		}

		// Joins
		query.append(" FROM ");
		query.append(from.getSQL());

		// Restrictions
		if (where != null) {
			query.append(" WHERE ");
			query.append(where.getSQL());
		}

		// Groups
		if (!groupBys.isEmpty()) {
			query.append(" GROUP BY ");
			for (GroupBy groupBy : groupBys) {
				query.append(groupBy.getSQL());
			}

			// Having
			query.append(" HAVING ");
			query.append(having.getSQL());
		}

		// Orders
		if (!orderBys.isEmpty()) {
			query.append(" ORDER BY ");
			for (OrderBy orderBy : orderBys) {
				query.append(orderBy.getSQL());
			}
		}

		// Limit and offset
		if (limit != null) {
			query.append(" LIMIT ");
			query.append(limit);
		}

		if (offset != null) {
			query.append(" OFFSET ");
			query.append(offset);
		}

		return query.toString();
	}

}
