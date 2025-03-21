db = db.getSiblingDB("mydb");
db.createCollection("items");
db.items.insertOne({ name: "Preloaded Item", firstName:"ashok" });

db.createUser({
    user: 'admin',
    pwd: 'secret',
    roles: [{ role: 'root', db: 'admin' }]
  });
