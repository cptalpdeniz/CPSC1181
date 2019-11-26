public interface Protocol{
	int NUMBER=1;
	int RESULT=2;
	int QUIT=3;
}

/*
Clinet side:					Server side:
--------------------------------------------
NUMBER n 						RESULT n
QUIT							close the connection
--------------------------------------------
n: int
*/
