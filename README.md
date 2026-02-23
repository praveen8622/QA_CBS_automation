# KYC Automation Project

This project contains the automated test suite for KYC Customer Registration.

# KYC Automation Test Suite

### 🚀 How to Run Tests
Copy and paste these commands into your terminal:

- **Run Everything (Clean Session):**  
  `mvn clean test`
- **Run Customer Registration Class:**  
  `mvn test -Dtest=CusRegTest`
- **Run Specific Method:**  
  `mvn test -Dtest=CusRegTest#verifyIdentityDetails`
- **Run from XML Suite:**  
  `mvn test -DsuiteXmlFile=cust_reg.xml`
---

## 🛠️ Project Structure
- `src/test/java/tests`: Test class definitions.
- `src/test/java/workflows`: Reusable business logic (BOs).
- `src/test/java/base`: Base classes with robust error handling.
- `src/test/java/pages`: Page Object Model implementation.
