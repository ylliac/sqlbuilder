package sqlbuilder;

public class DSL {

	public static Field field(String name){
		return Field.create(name);
	}
	
	public static Table table(String name){
		return Table.create(name);
	}
	
}
