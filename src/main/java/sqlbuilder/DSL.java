package sqlbuilder;

public class DSL {

	public static Field field(String name){
		return Field.create(name);
	}
	
	public static Table table(String name){
		return Table.create(name);
	}
	
	public static Count count(){
		return Count.create(null);
	}
	
	public static Count count(Select select){
		return Count.create(select);
	}
	
}
