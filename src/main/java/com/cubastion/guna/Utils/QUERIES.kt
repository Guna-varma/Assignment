package com.cubastion.guna.Utils

object QUERIES {

    const val GET_Q1_QUERY =
            "SELECT d.dname, COUNT(e.ssn) AS num_employees " +
                    "FROM Employee e JOIN Department d ON e.dno = d.dnumber " +
                    "GROUP BY d.dname HAVING AVG(e.salary) > 30000;"

    const val GET_Q2_QUERY =
            "SELECT d.dname, CONCAT(m.fname, ' ', m.lname) AS manager_name, COUNT(DISTINCT e.ssn) AS num_employees, COUNT(DISTINCT p.pnumber) AS num_projects " +
                    "FROM Department d " +
                    "LEFT JOIN Employee m ON d.Mgr_ssn = m.ssn " +
                    "LEFT JOIN Employee e ON d.dnumber = e.dno " +
                    "LEFT JOIN Project p ON d.dnumber = p.dnum " +
                    "GROUP BY d.dname, m.fname, m.lname;"

    const val GET_Q3_QUERY =
            "Select p.pname, d.dname AS controlling_department, COUNT(w.essn) AS num_employees, SUM(w.hours) AS total_hours " +
                    "FROM Project p " +
                    "INNER JOIN Department d ON p.dnum = d.dnumber " +
                    "INNER JOIN WORKS_ON w ON p.pnumber = w.pno " +
                    "GROUP BY p.pnumber;"

    const val GET_Q4_QUERY =
            "SELECT p.pname, d.dname AS controlling_department, COUNT(w.essn) AS num_employees, SUM(w.hours) AS total_hours " +
                    "FROM Project p " +
                    "INNER JOIN Department d ON p.dnum = d.dnumber " +
                    "INNER JOIN WORKS_ON w ON p.pnumber = w.pno " +
                    "GROUP BY p.pnumber " +
                    "HAVING COUNT(w.essn) > 1;"

    const val GET_Q5_QUERY =
            "SELECT concat(e.fname,' ',e.lname) AS employee_name, " +
                    "e.salary AS employee_salary, " +
                    "d.dname AS department_name, " +
                    "concat(m.fname,' ',m.lname) AS manager_name, " +
                    "m.salary AS manager_salary, " +
                    "AVG(e.salary) OVER (PARTITION BY e.dno) AS department_avg_salary " +
                    "FROM Employee e " +
                    "JOIN Department d ON e.dno = d.dnumber " +
                    "JOIN Employee m ON d.Mgr_ssn = m.ssn;"

}