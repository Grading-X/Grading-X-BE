import sys
import random

def grading(answerId, answer, questionId, email):
    return random.randint(0, 10)

answerId = int(sys.argv[1])
answer = sys.argv[2]
questionId = int(sys.argv[3])
email = sys.argv[4]

score = grading(answerId, answer, questionId, email)
print(score)