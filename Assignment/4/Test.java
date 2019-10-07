public class Test 
{ 
	enum Direction 
		{ 
			UP,DOWN,LEFT,RIGHT; 
		}	
	public static void main(String[] args) 
	{ 
		Direction d1 = Direction.UP; 
		System.out.println(d1); 

		int value;
		value = Direction.UP.ordinal();
		System.out.println(value);

		value = Direction.RIGHT.ordinal();
		System.out.println(value);

		for (Direction dir : Direction.values())
        {
			System.out.println("direction :"+ dir.name());
		}

	} 
}