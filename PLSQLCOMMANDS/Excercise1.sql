/*
EXERCISE 1 : CONTROL STRUCTURES*/

/*
Scenario 1:
Apply 1% Discount to Loan Interest Rates
for Customers Above 60 Years Old*/

DECLARE
CURSOR c_customers IS
SELECT CustomerID,
FLOOR(MONTHS_BETWEEN(SYSDATE, DOB)/12) AS Age
FROM Customers;
BEGIN
FOR cust IN c_customers LOOP
IF cust.Age > 60 THEN
UPDATE Loans
SET InterestRate = InterestRate - 1
WHERE CustomerID = cust.CustomerID;
END IF;
END LOOP;

```
COMMIT;
```

END;
/

/*
Scenario 2:
Promote Customers to VIP Status
if Balance is Greater Than 10000*/

DECLARE
BEGIN
FOR cust IN (
SELECT CustomerID, Balance
FROM Customers
) LOOP

```
    IF cust.Balance > 10000 THEN
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = cust.CustomerID;
    END IF;

END LOOP;

COMMIT;
```

END;
/

/*
Scenario 3:
Send Reminder for Loans Due
Within the Next 30 Days*/

BEGIN
FOR rec IN (
SELECT c.Name,
l.LoanID,
l.EndDate
FROM Customers c
JOIN Loans l
ON c.CustomerID = l.CustomerID
WHERE l.EndDate BETWEEN SYSDATE
AND SYSDATE + 30
) LOOP

```
    DBMS_OUTPUT.PUT_LINE(
        'Reminder: Loan ' || rec.LoanID ||
        ' for customer ' || rec.Name ||
        ' is due on ' ||
        TO_CHAR(rec.EndDate, 'DD-MON-YYYY')
    );

END LOOP;
```

END;
/
