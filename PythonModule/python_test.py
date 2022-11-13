from sqlalchemy import *
import sqlite3
from datetime import date

if __name__ == "__main__":
    engine = create_engine('sqlite:///mydb.db')
    connection = engine.connect()

    metadata = MetaData()

    choice = int(input('Choice: '))
    if choice == 1:
        animals = Table('animals', metadata,
                        Column('id', Integer, primary_key=True),
                        Column('petname', String(30)),
                        Column('age', Integer),
                        Column('weight', Integer))

        print(engine.table_names())
        print(animals)

    elif choice == 2:
        departments = Table('Animals', metadata, autoload=True, autoload_with=engine)

        print(repr(departments))

    else:
        con = sqlite3.connect('mydb.db')
        cursor = con.cursor()
        cursor.execute('select * from Department')
        print(cursor.fetchall())
