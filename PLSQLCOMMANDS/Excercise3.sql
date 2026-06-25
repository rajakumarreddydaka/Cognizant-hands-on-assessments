/*
EXERCISE 3 : STORED PROCEDURES
*/

/* Scenario 1: ProcessMonthlyInterest */

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
UPDATE Accounts
SET Balance = Balance + (Balance * 0.01)
WHERE AccountType = 'Savings';

```
COMMIT;
```

END;
/

/* Scenario 2: UpdateEmployeeBonus */

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
p_Department VARCHAR2,
p_BonusPercent NUMBER
)
IS
BEGIN
UPDATE Employees
SET Salary = Salary + (Salary * p_BonusPercent / 100)
WHERE Department = p_Department;

```
COMMIT;
```

END;
/

/* Scenario 3: TransferFunds */

CREATE OR REPLACE PROCEDURE TransferFunds(
p_FromAccount NUMBER,
p_ToAccount NUMBER,
p_Amount NUMBER
)
IS
v_balance NUMBER;
BEGIN
SELECT Balance
INTO v_balance
FROM Accounts
WHERE AccountID = p_FromAccount;

```
IF v_balance >= p_Amount THEN

    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccount;

    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccount;

    COMMIT;

ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
END IF;
```

END;
/
