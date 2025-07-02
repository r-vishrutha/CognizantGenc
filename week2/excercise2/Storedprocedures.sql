--Scenario1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR acct IN (
    SELECT AccountID, Balance
    FROM Accounts
    WHERE AccountType = 'Savings'
  ) LOOP
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountID = acct.AccountID;
  END LOOP;

  COMMIT;
END;

--Scenario2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_Department IN VARCHAR2,
  p_BonusPercent IN NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_BonusPercent / 100)
  WHERE Department = p_Department;

  COMMIT;
END;

--Scenario3
CREATE OR REPLACE PROCEDURE TransferFunds(
  p_FromAccountID IN NUMBER,
  p_ToAccountID IN NUMBER,
  p_Amount IN NUMBER
) IS
  v_FromBalance NUMBER;
BEGIN
  -- Get current balance of source account
  SELECT Balance INTO v_FromBalance
  FROM Accounts
  WHERE AccountID = p_FromAccountID
  FOR UPDATE;

  
  IF v_FromBalance < p_Amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
  END IF;

  
  UPDATE Accounts
  SET Balance = Balance - p_Amount,
      LastModified = SYSDATE
  WHERE AccountID = p_FromAccountID;

  
  UPDATE Accounts
  SET Balance = Balance + p_Amount,
      LastModified = SYSDATE
  WHERE AccountID = p_ToAccountID;

  COMMIT;
END;

