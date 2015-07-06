package sqlbuilder;

public interface ConditionOperand extends SQL {

	Condition equal(ConditionOperand operand2);

	Condition equal(int value);

	Condition equal(String value);

	Condition greaterThan(int value);

	Condition greaterThan(String value);

	Condition greaterThan(ConditionOperand operand2);

}
