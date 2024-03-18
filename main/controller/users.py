from fastapi import APIRouter

router = APIRouter(
    prefix="/users",
    tags=["users"]
)

fake_user = {"username": "hello", "password": "password"}


@router.get("/")
async def get_user():
    return fake_user


@router.post("/signin")
async def signin():
    return fake_user


