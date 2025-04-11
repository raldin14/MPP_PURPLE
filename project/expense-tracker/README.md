# Expense Tracker Console Version

A Java console application to track user expenses.

## Structure
- `model/`: POJO classes
- `dao/`: Data access layer
- `service/`: Business logic
- `view/`: User interaction (console)
- `session/`: In-memory session management
- `db/`: JDBC config and utilities

## Database Initialization

Run the following script to set up the database structure and initial data:

```bash
mysql -u root -p < src/main/resources/schema/init.sql