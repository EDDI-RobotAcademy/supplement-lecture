from typing import List

from fastapi import Depends, status, APIRouter
from fastapi_restful import cbv
from sqlalchemy.orm import Session

from app import schemas
from app.api import dependencies
from app.domain import DeepLearn
from app.services import post_service

router = APIRouter()

@cbv(router)
class PostController:
    def __init__(self, db: Session = Depends(dependencies.get_db)):
        self.db = db

    @router.post('/', response_model=schemas.Post, status_code=status.HTTP_201_CREATED)
    def create_post(self, request: schemas.PostCreate, current_user: User = Depends(dependencies.get_current_user)):
        return post_service.create_post(db=self.db, request=request, user_id=current_user.id)

    @router.get('/', response_model=List[schemas.Post], summary="Get All Posts")
    def get_posts(self, skip: int = 0, limit: int = 100):
        return post_service.get_multi(db=self.db, skip=skip, limit=limit)

    @router.delete('/{id}', response_model=schemas.PostDeleteResponse)
    def delete_post(self, id: str, current_user: User = Depends(dependencies.get_current_user)):
        return post_service.delete_post(db=self.db, post_id=id, user_id=current_user.id)