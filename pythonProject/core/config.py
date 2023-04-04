import os
import secrets
from typing import Optional, Dict, Any

from pydantic import BaseSettings, PostgresDsn, validator

class Settings(BaseSettings):
    ENVIRONMENT: str = os.getenv('ENVIRONMENT')
    SECRET_KEY: str = secrets.token_urlsafe(32)
    # 60 minutes * 24 hours * 8 days = 8 days
    ACCESS_TOKEN_EXPIRE_MINUTES: int = 60 * 24 * 8
    DB_URL: str = os.getenv('DB_URL')
    API_PREFIX: str = "/api"
    POSTGRES_SERVER: str = "localhost"
    POSTGRES_USER: str = "eddi"
    POSTGRES_PASSWORD: str = "eddi@123"
    POSTGRES_DB: str = "postgres_test_db"

    SQLALCHEMY_DATABASE_URI: Optional[PostgresDsn] = None

    @validator("SQLALCHEMY_DATABASE_URI", pre=True)
    def assemble_db_connection(cls, v: Optional[str], values: Dict[str, Any]) -> Any:
        if isinstance(v, str):
            return v
        return PostgresDsn.build(
            scheme="postgresql",
            user=values.get("POSTGRES_USER"),
            password=values.get("POSTGRES_PASSWORD"),
            host=values.get("POSTGRES_SERVER"),
            path=f"/{values.get('POSTGRES_DB') or ''}",
        )

    class Config:
        env_file = ".env"

settings = Settings()