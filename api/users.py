from fastapi import APIRouter

router = APIRouter(
    prefix="/users",
    tags=["users"]
)


@router.get("/get")
async def get_user():
    return "GET USERS"
