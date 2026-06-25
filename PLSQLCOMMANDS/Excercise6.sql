/*
EXERCISE 6 : CURSORS*/

/* Scenario 1:
Generate Monthly Statements
*/

DECLARE

```
CURSOR GenerateMonthlyStatements IS
    SELECT *
    FROM Transactions
    WHERE TRUNC(TransactionDate, 'MM')
          = TRUNC(SYSDATE, 'MM');
```

BEGIN

```
FOR rec IN GenerateMonthlyStatements LOOP

    DBMS_OUTPUT.PUT_LINE(
        'Account ID: ' || rec.AccountID ||
        ' Amount: ' || rec.Amount ||
        ' Type: ' || rec.TransactionType
    );

END LOOP;
```

END;
/

/* Scenario 2:
Apply Annual Maintenance Fee
*/

DECLARE

```
CURSOR ApplyAnnualFee IS
    SELECT AccountID
    FROM Accounts;
```

BEGIN

```
FOR rec IN ApplyAnnualFee LOOP

    UPDATE Accounts
    SET Balance = Balance - 100
    WHERE AccountID = rec.AccountID;

END LOOP;

COMMIT;
```

END;
/

/* Scenario 3:
Update Loan Interest Rates
*/

DECLARE

```
CURSOR UpdateLoanInterestRates IS
    SELECT LoanID
    FROM Loans;
```

BEGIN

```
FOR rec IN UpdateLoanInterestRates LOOP

    UPDATE Loans
    SET InterestRate = InterestRate + 0.5
    WHERE LoanID = rec.LoanID;

END LOOP;

COMMIT;
```

END;
/
