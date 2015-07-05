package sqlbuilder;

public interface OrderBy extends SQL {

	OrderBy asc();

	OrderBy desc();

	OrderBy nullsFirst();

	OrderBy nullsLast();

}
