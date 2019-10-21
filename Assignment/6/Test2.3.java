ArrayList<BankAccount> bankAccList = new ArrayList<BankAccount>();
bankAccList.add(ba1); 
bankAccList.add(ba2); 
bankAccList.add(ba3);  
bankAccList.add(ba4); 
bankAccList.add(ba5);  
Collections.sort(bankAccList);
for (BankAccount bankAcc : bankAccList)
{
	bankAcc.getBalance();
}