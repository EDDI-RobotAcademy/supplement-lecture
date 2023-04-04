from fastapi import FastAPI
from core.config import settings
from api.router import api_router
from utility.logger import init_loggers

app = FastAPI(
    title='FastAPI Server',
)

@app.on_event('startup')
async def startup_event():
    init_loggers()

app.include_router(api_router, prefix=settings.API_PREFIX)