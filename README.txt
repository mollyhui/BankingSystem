Group 14 Memebers: Diwen Sun, Nelson Mei, Yahui Chang

How to compile and run:


Account.java:
This class represents the account of customer/manager. It contains common attributes and transaction methods for all types of accounts. It is mostly used as a super class for more specific type of account.

Checking.java:
This class represents checking account. It extends Account.java.

Saving.java:
This class represents saving account. It extends Account.java. The transfer method is override in this class because of the restriction on transfer from saving to security account.

SecurityAccount.java:
This class represents security account. It extends Account.java. 

User.java:
This class represents user. It is used as a super class for manager/customer.

Customer.java:
This class represents customer. It extends User.java. It contains all types of account a customer might has.

Manager.java:
This class represents manager. It extends User.java. It contain stockMarket and methods of deleting stock/reseting price of stock.

Stock.java:
This class represents an individual stock. 

StockMarket.java:
This class represents stock market and contains all stocks.

Date.java
This class represents date which is used in daily report. It will print in the form of "day/month/year".

InsufficientFundsException.java:
Throws exception when customer does not have enough funds for a transaction.

InvalidAccountException.java:
Throws exception when customer create a type of account which is already there.

InvalidAmountException.java:
Throws exception when customer enter a invalid amount of money for a certain transaction.

TooManyLoansException.java:
We assume one customer can only have one loan.

appBackup.java:
This class cretes csv files and contains methods to access attributes in csv files.







