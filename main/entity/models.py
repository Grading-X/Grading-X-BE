from sqlalchemy import Integer, String
from sqlalchemy.sql.schema import Column
from .base import Base


class users(Base):
    __tablename__ = 'users'

    id = Column(Integer, primary_key=True)
    title = Column(String, nullable=False)
    description = Column(String, nullable=False)