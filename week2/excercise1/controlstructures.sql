//Scenario 1 
BEGIN
  FOR cust IN (
    SELECT CustomerID
    FROM Customers
    WHERE MONTHS_BETWEEN(SYSDATE, DOB) / 12 > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = cust.CustomerID;
  END LOOP;

  COMMIT;
END;

//Scenario 2
ALTER TABLE Customers ADD (IsVIP VARCHAR2(5));

BEGIN
  FOR cust IN (
    SELECT CustomerID
    FROM Customers
    WHERE Balance > 10000
  ) LOOP
    UPDATE Customers
    SET IsVIP = 'TRUE',
        LastModified = SYSDATE
    WHERE CustomerID = cust.CustomerID;
  END LOOP;

  COMMIT;
END;

//Scenario 3
BEGIN
  FOR loan IN (
    SELECT LoanID, CustomerID, EndDate
    FROM Loans
    WHERE EndDate <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Customer ' || loan.CustomerID || 
      ', your loan (ID: ' || loan.LoanID || 
      ') is due on ' || TO_CHAR(loan.EndDate, 'DD-MON-YYYY')
    );
  END LOOP;
END;


