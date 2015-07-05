package sqlbuilder;

public interface Condition extends SQL {
	
	Condition or(Condition condition2);

	Condition and(Condition condition2);

}
