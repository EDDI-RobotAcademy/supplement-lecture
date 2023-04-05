from sqlalchemy.orm import Session
from database import models, schemas
#import database


def create_test_data(db: Session, testData: schemas.TestDataCreate):
    print('testData ', testData)
    db_test_data = models.TestData(testNumber=testData.testNumber)
    print('db_test_data: ', db_test_data)
    db.add(db_test_data)
    print('db add success!')
    db.commit()
    print('db commit success!')
    db.refresh(db_test_data)
    return db_test_data
