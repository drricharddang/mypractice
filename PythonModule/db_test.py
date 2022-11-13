import sqlite3


if __name__ == '__main__':
    connection = sqlite3.connect(r'mydb.db')
    cursor = connection.cursor()

    cursor.execute("""CREATE TABLE IF NOT EXISTS Department(
                            id INTEGER PRIMARY KEY,
                            name TEXT);""")

    cursor.execute("""CREATE TABLE IF NOT EXISTS Student(
                                id INTEGER PRIMARY KEY,
                                full_name TEXT,
                                email TEXT,
                                gpa REAL,
                                department INTEGER,
                                FOREIGN KEY (department) REFERENCES Department(id)
                                );""")

    connection.commit()

    # if int(input('INSERT operation? ')) == 1:
    #     cursor.execute("""INSERT INTO Department(name) VALUES ('Engineering')""")
    #     cursor.execute("""INSERT INTO Department(name) VALUES ('Mathmatics')""")
    #
    #     new_department = (45, 'Physics')
    #     cursor.execute("INSERT INTO Department(id, name) VALUES (?, ?)", new_department)
    #
    #     new_depts = [(10, 'Literature'), (11, 'Philosophy'), (12, 'Chemistry')]
    #     cursor.executemany("INSERT INTO Department(id, name) VALUES (?, ?)", new_depts)
    #
    #     students_list = [
    #         (1, 'Alan Turing', 'alan@mail.com', 9.5, 1),
    #         (2, 'Katherine Johnson', 'katherine@mail.com', 10.0, 2),
    #         (3, 'Helen Quinn', 'helen@mail.com', 8.7, 45),
    #     ]
    #     cursor.executemany('INSERT INTO Student VALUES (?, ?, ?, ?, ?)', students_list)
    #
    #     connection.commit()

    cursor.execute("""SELECT id
                        FROM Department
                        WHERE name = ?""", [input()])
    result = cursor.fetchone()[0]
    print(result)
    # for i in result:
    #     print(i)

    cursor.close()
    connection.close()
