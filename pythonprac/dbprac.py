from pymongo import MongoClient
import certifi
client = MongoClient('mongodb+srv://sparta:test@cluster0.p5xkuy6.mongodb.net/?retryWrites=true&w=majority', tlsCAFile=certifi.where())
db = client.dbsparta

doc = {
    'name' : '영수',
    'age' : 24
}

db.users.insert_one(doc)