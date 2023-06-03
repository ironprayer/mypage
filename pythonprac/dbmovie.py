import requests
from bs4 import BeautifulSoup
from pymongo import MongoClient
import certifi

URL = "https://movie.daum.net/ranking/reservation"
headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36'}
data = requests.get(URL,headers=headers)
soup = BeautifulSoup(data.text, 'html.parser')

client = MongoClient('mongodb+srv://sparta:test@cluster0.p5xkuy6.mongodb.net/?retryWrites=true&w=majority', tlsCAFile=certifi.where())
db = client.dbsparta

video_list = soup.select("#mainContent > div > div.box_ranking > ol > li")
# for video in video_list:
#   rank = video.select_one(".rank_num").text
#   title = video.select_one(".tit_item").text.strip("\n")
#   rate = video.select_one(".txt_grade").text
#   doc = {
# 			'title': title,
#             'rank': rank,
#             'rate': rate
#         }
#   db.movies.insert_one(doc)

movie = db.movies.find_one({'title':'슈퍼 마리오 브라더스'})

target_rate = movie['rate']
print(movie)

movies = list(db.movies.find({'rate':target_rate}))

for a in movies:
    print(a['title'])

db.movies.update_one({'title':'슈퍼 마리오 브라더스'},{'$set':{'rate':'0'}})