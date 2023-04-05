from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

import urllib.parse

password = 'eddi@123'
SQLALCHEMY_DATABASE_URL = f"postgresql+psycopg2://eddi:" + urllib.parse.quote_plus(password) +"@localhost:5432/postgres_test_db"

engine = create_engine(
    url=SQLALCHEMY_DATABASE_URL
)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

Base = declarative_base()

print('engine: ', engine)
print('SessionLocal: ', SessionLocal)
print('Base: ', Base)


def get_db():
    db = None
    try:
        db = SessionLocal()
        print('get_db(): ', db)
        yield db
    finally:
        db.close()

