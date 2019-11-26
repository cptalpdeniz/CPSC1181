public interface Protocol{
	int DATA=1;
	int END=2;
}

/*
Clinet side:					Server side:
--------------------------------------------
DATA message 
END								close the connection
--------------------------------------------
message: String
*/
