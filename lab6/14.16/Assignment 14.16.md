## Question 14.16

An agency called *Instant Cover* supplies part-time/temporary staff to hotels within Scotland. The table shown in Figure 14.20 displays sample data, which lists the time spent by agency staff working at various hotels. The National Insurance Number (NIN) is unique for every member of staff.

### (a) The table shown in Figure 14.20 is susceptible to update anomalies. Provide examples of insertion, deletion, and update anomalies.

### (b) Identify the functional dependencies represented by the attributes shown in the table of Figure 14.20. State any assumptions that you make about the data and the attributes shown in this table.

### (c) Describe and illustrate the process of normalizing the table shown in Figure 14.20 to 3NF. Identify primary, alternate, and foreign keys in your relations.

---

## ✅ Answer

### (a) Update Anomalies

The table is not normalized and suffers from the following anomalies:

- **Insertion anomaly**:  
  A new hotel (e.g., `H100`) cannot be added unless at least one staff member is assigned to it.

- **Deletion anomaly**:  
  If we delete the row where `NIN = 1057`, we also lose the information about hotel `H25`.

- **Update anomaly**:  
  If the location of hotel `H4` changes, we must update all rows referencing `H4`. Missing any row can lead to inconsistent data.

---

### (b) Functional Dependencies

**Assumptions**:

- Each staff member has a unique `NIN` and associated name `eName`
- Each hotel has a unique number `hNo` that determines its location `hLoc`
- The combination `(NIN, contractNo)` uniquely identifies a work assignment

**Functional Dependencies**:

```
NIN → eName  
hNo → hLoc  
(NIN, contractNo) → hours, hNo
```

---

### (c) Normalization to 3NF

#### Step 1: Eliminate partial dependencies
Move `eName` and `hLoc` to separate tables because they depend only on `NIN` and `hNo`, respectively.

---

### Final Schema (3NF)

#### 1. Staff Table
```sql
CREATE TABLE Staff (
    NIN INT PRIMARY KEY,
    eName VARCHAR(50) NOT NULL
);
```

#### 2. Hotel Table
```sql
CREATE TABLE Hotel (
    hNo VARCHAR(10) PRIMARY KEY,
    hLoc VARCHAR(100) NOT NULL
);
```

#### 3. Work Table
```sql
CREATE TABLE Work (
    NIN INT,
    contractNo VARCHAR(10),
    hours INT,
    hNo VARCHAR(10),
    PRIMARY KEY (NIN, contractNo),
    FOREIGN KEY (NIN) REFERENCES Staff(NIN),
    FOREIGN KEY (hNo) REFERENCES Hotel(hNo)
);
```

---

### Keys Summary

| Table | Primary Key         | Foreign Keys               | Notes                       |
|-------|----------------------|-----------------------------|-----------------------------|
| Staff | NIN                  | —                           | NIN is also a candidate key |
| Hotel | hNo                  | —                           | hNo is a unique hotel ID    |
| Work  | (NIN, contractNo)    | NIN → Staff, hNo → Hotel    | Composite primary key       |

---
