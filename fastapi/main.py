from typing import List

from fastapi import Depends, FastAPI, HTTPException
from pydantic import BaseModel
from typing import Optional
from sqlalchemy.orm import Session, sessionmaker

import sqlalchemy.orm.session

import database.models
import database.base
import database.schemas
import database.crud

from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

#import urllib.parse

#SQLALCHEMY_DATABASE_URL = "postgresql+psycopg2://eddi:{0}@localhost/postgres_test_db"
#password = 'eddi@123'

#engine = create_engine(
#    url=SQLALCHEMY_DATABASE_URL.format(urllib.parse.quote_plus(password)),
#    connect_args={"check_same_thread": False}
#)
#SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

#Base = declarative_base()

#print('engine: ', engine)

database.models.Base.metadata.create_all(bind=database.base.engine)

app = FastAPI()


def get_db():
    db = database.base.SessionLocal()
    try:
        yield db
    finally:
        db.close()


class Item(BaseModel):
    name: str
    price: float
    is_offer: Optional[bool] = None


@app.get("/")
async def root():
    return {"message": "Hello World"}


@app.get("/hello/{name}")
async def say_hello(name: str):
    return {"message": f"Hello {name}"}


@app.put("/items/{item_id}")
def update_item(item_id: int, item: Item):
    return {"item_name": item.name, "item_id": item_id}


@app.post("/items/add")
def add_item(item: Item):
    print(item)
    return {"success": True}


@app.post("/users/", response_model=database.schemas.TestData)
def create_user(testData: database.schemas.TestDataCreate, db: Session = Depends(get_db)):
    print('testData', testData)
    print('DB Session ', db)
    return database.crud.create_test_data(db=db, testData=testData)
