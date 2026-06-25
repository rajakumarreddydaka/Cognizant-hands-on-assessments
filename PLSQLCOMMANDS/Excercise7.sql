/*
EXERCISE 7 : PACKAGES*/

/*
Scenario 1 : CustomerManagement Package
*/

CREATE OR REPLACE PACKAGE CustomerManagement AS

```
PROCEDURE AddCustomer(
    p_ID NUMBER,
    p_Name VARCHAR2,
    p_DOB DATE,
    p_Balance NUMBER
);

PROCEDURE UpdateCustomer(
    p_ID NUMBER,
    p_Name VARCHAR2
);

FUNCTION GetCustomerBalance(
    p_ID NUMBER
) RETURN NUMBER;
```

END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

```
PROCEDURE AddCustomer(
    p_ID NUMBER,
    p_Name VARCHAR2,
    p_DOB DATE,
    p_Balance NUMBER
) IS
BEGIN
    INSERT INTO Customers
    VALUES(
        p_ID,
        p_Name,
        p_DOB,
        p_Balance,
        SYSDATE,
        NULL
    );
END;

PROCEDURE UpdateCustomer(
    p_ID NUMBER,
    p_Name VARCHAR2
) IS
BEGIN
    UPDATE Customers
    SET Name = p_Name
    WHERE CustomerID = p_ID;
END;

FUNCTION GetCustomerBalance(
    p_ID NUMBER
) RETURN NUMBER
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Customers
    WHERE CustomerID = p_ID;

    RETURN v_balance;
END;
```

END CustomerManagement;
/

/*
Scenario 2 : EmployeeManagement Package
*/

CREATE OR REPLACE PACKAGE EmployeeManagement AS

```
PROCEDURE HireEmployee(
    p_ID NUMBER,
    p_Name VARCHAR2,
    p_Position VARCHAR2,
    p_Salary NUMBER,
    p_Department VARCHAR2
);

PROCEDURE UpdateEmployee(
    p_ID NUMBER,
    p_Salary NUMBER
);

FUNCTION CalculateAnnualSalary(
    p_ID NUMBER
) RETURN NUMBER;
```

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

```
PROCEDURE HireEmployee(
    p_ID NUMBER,
    p_Name VARCHAR2,
    p_Position VARCHAR2,
    p_Salary NUMBER,
    p_Department VARCHAR2
) IS
BEGIN
    INSERT INTO Employees
    VALUES(
        p_ID,
        p_Name,
        p_Position,
        p_Salary,
        p_Department,
        SYSDATE
    );
END;

PROCEDURE UpdateEmployee(
    p_ID NUMBER,
    p_Salary NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = p_Salary
    WHERE EmployeeID = p_ID;
END;

FUNCTION CalculateAnnualSalary(
    p_ID NUMBER
) RETURN NUMBER
IS
    v_salary NUMBER;
BEGIN
    SELECT Salary
    INTO v_salary
    FROM Employees
    WHERE EmployeeID = p_ID;

    RETURN v_salary * 12;
END;
```

END EmployeeManagement;
/

/*
Scenario 3 : AccountOperations Package
*/

CREATE OR REPLACE PACKAGE AccountOperations AS

```
PROCEDURE OpenAccount(
    p_AccountID NUMBER,
    p_CustomerID NUMBER,
    p_Type VARCHAR2,
    p_Balance NUMBER
);

PROCEDURE CloseAccount(
    p_AccountID NUMBER
);

FUNCTION GetTotalBalance(
    p_CustomerID NUMBER
) RETURN NUMBER;
```

END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

```
PROCEDURE OpenAccount(
    p_AccountID NUMBER,
    p_CustomerID NUMBER,
    p_Type VARCHAR2,
    p_Balance NUMBER
) IS
BEGIN
    INSERT INTO Accounts
    VALUES(
        p_AccountID,
        p_CustomerID,
        p_Type,
        p_Balance,
        SYSDATE
    );
END;

PROCEDURE CloseAccount(
    p_AccountID NUMBER
) IS
BEGIN
    DELETE FROM Accounts
    WHERE AccountID = p_AccountID;
END;

FUNCTION GetTotalBalance(
    p_CustomerID NUMBER
) RETURN NUMBER
IS
    v_total NUMBER;
BEGIN
    SELECT SUM(Balance)
    INTO v_total
    FROM Accounts
    WHERE CustomerID = p_CustomerID;

    RETURN NVL(v_total, 0);
END;
```

END AccountOperations;
/
