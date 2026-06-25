/*
EXERCISE 4 : FUNCTIONS*/

/* Scenario 1: CalculateAge */

CREATE OR REPLACE FUNCTION CalculateAge(
p_DOB DATE
)
RETURN NUMBER
IS
BEGIN
RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
END;
/

/* Scenario 2: CalculateMonthlyInstallment */

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
p_LoanAmount NUMBER,
p_InterestRate NUMBER,
p_Years NUMBER
)
RETURN NUMBER
IS
v_monthly NUMBER;
BEGIN
v_monthly :=
(p_LoanAmount +
(p_LoanAmount * p_InterestRate / 100))
/ (p_Years * 12);

```
RETURN v_monthly;
```

END;
/

/* Scenario 3: HasSufficientBalance */

CREATE OR REPLACE FUNCTION HasSufficientBalance(
p_AccountID NUMBER,
p_Amount NUMBER
)
RETURN BOOLEAN
IS
v_balance NUMBER;
BEGIN
SELECT Balance
INTO v_balance
FROM Accounts
WHERE AccountID = p_AccountID;

```
RETURN v_balance >= p_Amount;
```

END;
/
