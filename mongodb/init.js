db = db.getSiblingDB("mydb");
db.createCollection("items");
db.items.insertOne({ name: "Preloaded Item" });

