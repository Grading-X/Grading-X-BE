from fastapi import FastAPI, Depends
from controller import users
from sqlalchemy.future import engine

from entity.base import get_db
from schemas.user import User

app = FastAPI()
app.include_router(users.router)

@app.get("/")
async def root():
    return {"message": "Hello World"}


@app.get("/hello/{name}")
async def say_hello(name: str):
    return {"message": f"Hello {name}"}

@app.get("/makeuser")
def make_user(username: str, email: str, db=Depends(get_db)):
    db_user = User(id=1, username=username, email=email)
    db.add(db_user)
    db.commit()
    return {"message": "success"}
