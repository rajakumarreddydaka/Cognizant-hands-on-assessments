/*
EXERCISE 2 : ERROR HANDLING*/

/* Scenario 1: SafeTransferFunds */

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
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
IF v_balance < p_Amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient Funds');
END IF;

UPDATE Accounts
SET Balance = Balance - p_Amount
WHERE AccountID = p_FromAccount;

UPDATE Accounts
SET Balance = Balance + p_Amount
WHERE AccountID = p_ToAccount;

COMMIT;
```

EXCEPTION
WHEN OTHERS THEN
ROLLBACK;
DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

/* Scenario 2: UpdateSalary */

CREATE OR REPLACE PROCEDURE UpdateSalary(
p_EmployeeID NUMBER,
p_Percentage NUMBER
)
IS
BEGIN
UPDATE Employees
SET Salary = Salary + (Salary * p_Percentage / 100)
WHERE EmployeeID = p_EmployeeID;

```
IF SQL%ROWCOUNT = 0 THEN
    RAISE NO_DATA_FOUND;
END IF;

COMMIT;
```

EXCEPTION
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE('Employee ID not found');

```
WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE(SQLERRM);
```

END;
/

/* Scenario 3: AddNewCustomer */

CREATE OR REPLACE PROCEDURE AddNewCustomer(
p_CustomerID NUMBER,
p_Name VARCHAR2,
p_DOB DATE,
p_Balance NUMBER
)
IS
BEGIN
INSERT INTO Customers
VALUES (
p_CustomerID,
p_Name,
p_DOB,
p_Balance,
SYSDATE,
NULL
);

```
COMMIT;
```

EXCEPTION
WHEN DUP_VAL_ON_INDEX THEN
DBMS_OUTPUT.PUT_LINE('Customer ID already exists');
END;
/
