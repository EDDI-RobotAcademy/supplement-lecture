from pydantic import BaseModel


class TestDataBase(BaseModel):
    testNumber: int


class TestDataCreate(TestDataBase):
    pass


class TestData(TestDataBase):
    id: int

    class Config:
        orm_mode = True
