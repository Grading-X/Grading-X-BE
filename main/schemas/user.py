from typing import List, Union
from pandas import Timestamp
from pydantic import BaseModel


class UserBase(BaseModel):
    username: str
    email: str = None


class User(UserBase):
    id: int

    class Config:
        orm_mode = True
