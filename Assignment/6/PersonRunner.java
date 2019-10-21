public class PersonRunner
{
	public static void main(String[] args)
	{
		Person aperson = new Person("Bob", 33);
		aperson.rememberAnEvent("I was born in 1970.");
		aperson.rememberAnEvent("I finished school in 2003.");
		aperson.tellAll();
	}
}