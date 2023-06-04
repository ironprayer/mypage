from flask import Flask, render_template, request, jsonify
from pymongo import MongoClient
import certifi

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')

@app.route("/mars", methods=["POST"])
def mars_post():
    name_receive = request.form['name_give']
    address_receive = request.form['address_give']
    size_receive = request.form['size_give']

    client = MongoClient('mongodb+srv://sparta:test@cluster0.p5xkuy6.mongodb.net/?retryWrites=true&w=majority', tlsCAFile=certifi.where())
    db = client.mars

    doc = {
        'name' : name_receive,
        'address' : address_receive,
        'size' : size_receive
    }

    db.users.insert_one(doc)
    return jsonify({'msg':'저장 완료!'})

@app.route("/mars", methods=["GET"])
def mars_get():
    client = MongoClient('mongodb+srv://sparta:test@cluster0.p5xkuy6.mongodb.net/?retryWrites=true&w=majority', tlsCAFile=certifi.where())
    db = client.mars
    mars_data = list(db.users.find({}, {'_id':False}))
    return jsonify({'result':mars_data})

if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)