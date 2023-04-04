from fastapi import APIRouter

from api.endpoints import deep_learn

api_router = APIRouter()

api_router.include_router(deep_learn.router, prefix="/deep_learn", tags=["DeepLearn"])