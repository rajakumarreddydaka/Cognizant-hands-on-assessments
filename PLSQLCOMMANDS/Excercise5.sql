/*
EXERCISE 5 : TRIGGERS*/

/* Scenario 1:
Automatically update LastModified
when a customer record is updated
*/

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
:NEW.LastModified := SYSDATE;
END;
/

/* Scenario 2:
Maintain audit log for transactions
*/

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
INSERT INTO AuditLog
VALUES (
:NEW.TransactionID,
'Transaction Inserted',
SYSDATE
);
END;
/

/* Scenario 3:
Check deposit and withdrawal rules
*/

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
v_balance NUMBER;
BEGIN

```
SELECT Balance
INTO v_balance
FROM Accounts
WHERE AccountID = :NEW.AccountID;

IF :NEW.TransactionType = 'Withdrawal'
   AND :NEW.Amount > v_balance THEN

   RAISE_APPLICATION_ERROR(
       -20002,
       'Insufficient Balance'
   );

ELSIF :NEW.TransactionType = 'Deposit'
      AND :NEW.Amount <= 0 THEN

   RAISE_APPLICATION_ERROR(
       -20003,
       'Deposit amount must be positive'
   );
END IF;
```

END;
/
