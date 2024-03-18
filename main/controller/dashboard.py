from fastapi import APIRouter

router = APIRouter(
    prefix="/controller/dashboard",
    tags=["dashboard"]
)


@router.get("/")
async def get_dashboard():
    return {"username": ""}


@router.get("/class")
async def get_class():
    return {"class": ""}