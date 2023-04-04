from enum import Enum
from fastapi import FastAPI
from typing import Union
from pydantic import BaseModel

app = FastAPI()

# Python Console: !uvicorn main:app --reload <<<- PyCharm
# http://127.0.0.1:8000/items/3
# http://localhost:8000/models/alexnet
# http://localhost:8000/files/test/go/test.txt
# http://127.0.0.1:8000/items/?skip=0&limit=10
# http://127.0.0.1:8000/select/foo?short=True
# http://127.0.0.1:8000/select/foo?short=no
# http://127.0.0.1:8000/essential/foo-item
# http://127.0.0.1:8000/essential/foo-item?needy=sooooneedy

class ModelName(str, Enum):
    alexnet = "alexnet"
    resnet = "resnet"
    lenet = "lenet"

@app.get("/")
async def root():
    return {"message": "Hello EDDI!"}

@app.get("/var-items/{item_id}")
async def read_item(item_id):
    return {"item_id": item_id}

@app.get("/items/{item_id}")
async def read_item(item_id: int):
    return {"item_id": item_id}

@app.get("/models/{model_name}")
async def get_model(model_name: ModelName):
    if model_name is ModelName.alexnet:
        return {"model_name": model_name, "message": "Deep Learning FTW!"}

    if model_name.value == "lenet":
        return {"model_name": model_name, "message": "LeCNN all the images"}

    return {"model_name": model_name, "message": "Have some residuals"}

@app.get("/files/{file_path:path}")
async def read_file(file_path: str):
    return {"file_path": file_path}

fake_items_db = [{"item_name": "Foo"}, {"item_name": "Bar"}, {"item_name": "Baz"}]

@app.get("/items/")
async def read_item(skip: int = 0, limit: int = 10):
    return fake_items_db[skip : skip + limit]

@app.get("/select/{item_id}")
async def read_item(item_id: str, q: Union[str, None] = None, short: bool = False):
    item = {"item_id": item_id}
    if q:
        item.update({"q": q})
    if not short:
        item.update(
            {"description": "This is an amazing item that has a long description"}
        )
    return item

@app.get("/essential/{item_id}")
async def read_user_item(item_id: str, needy: str):
    item = {"item_id": item_id, "needy": needy}
    return item

class Item(BaseModel):
    name: str
    description: str | None = None
    price: float
    tax: float | None = None

@app.post("/items-test/")
async def create_item(item: Item):
    return item

@app.put("/request-body/{item_id}")
async def create_item(item_id: int, item: Item):
    return {"item_id": item_id, **item.dict()}
