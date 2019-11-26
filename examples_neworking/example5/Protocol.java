public interface Protocol{
	int PORT = 18888;
	int DEPOSIT = 1;
	int WITHDRAW = 2;
	int BALANCE = 3;
	int QUIT = 4;
	int INVALID_COMMAND = 5;
	int CLOSED = 6;
	int SUCCEED = 7;
}

/*
Clinet side:					Server side:
----------------------------------------------
DEPOSIT account# amounnt		SUCCEED 
WITHDRAW account# amounnt		SUCCEED
BALANCE account#				SUCCEED balance
QUIT							CLOSED
----------------------------------------------
account: int
amount: double
balance: double
*/
