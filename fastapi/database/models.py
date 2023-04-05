from sqlalchemy import Column, Integer
from database.base import Base


class TestData(Base):
    __tablename__ = "learn_test_data"

    id = Column(Integer, primary_key=True, index=True)
    testNumber = Column(Integer)
