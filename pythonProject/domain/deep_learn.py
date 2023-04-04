import uuid

from sqlalchemy import Column, Integer, String, ForeignKey, DateTime, func, Text
from sqlalchemy.dialects.postgresql import UUID
from sqlalchemy.orm import relationship

from app.db.base_class import Base

class DeepLearn(Base):
    __tablename__ = 'deep_learn'

    id = Column(Text, primary_key=True, index=True, default=lambda: str(uuid.uuid4()))
    estimated_number = Column(Integer, default=0)

    created_at = Column(DateTime(timezone=True), server_default=func.now())
    updated_at = Column(DateTime(timezone=True), onupdate=func.now())