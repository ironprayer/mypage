from flask import Flask, render_template, request, jsonify
from pymongo import MongoClient
import certifi
from meta_prac import scrappingTo
app = Flask(__name__)

@app.route('/')
def home():
	return render_template('index.html')

@app.route("/movie", methods=["POST"])
def movie_post():
	url_receive = request.form['url_give']
	comment_receive = request.form['comment_give']
	star_receive = request.form['star_give']
	scrappingResult = scrappingTo(url_receive)
	client = MongoClient('mongodb+srv://sparta:test@cluster0.p5xkuy6.mongodb.net/?retryWrites=true&w=majority', tlsCAFile=certifi.where())
	db = client.movies
	doc = {
	    'title': scrappingResult['ogtitle'],
	    'image': scrappingResult['ogimage'],
	    'desc' : scrappingResult['ogdesc'],
	    'url' : url_receive,
	    'comment' : comment_receive,
	    'star' : star_receive
    }
	db.movies.insert_one(doc)
	return jsonify({'msg':'저장!'})

@app.route("/movie", methods=["GET"])
def movie_get():
	client = MongoClient('mongodb+srv://sparta:test@cluster0.p5xkuy6.mongodb.net/?retryWrites=true&w=majority', tlsCAFile=certifi.where())
	db = client.movies
	movies = list(db.movies.find({},{'_id':False}))
	return jsonify({'results':movies})

if __name__ == '__main__':
	app.run('0.0.0.0', port=5000, debug=True)