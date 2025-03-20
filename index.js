const express = require('express');
const mongoose = require('mongoose');
const app = express();
const PORT = 8080;
// Connect to MongoDB
const mongoURL = process.env.MONGO_URL || "mongodb://localhost:27017/mydb";
mongoose.connect(mongoURL, { useNewUrlParser: true, useUnifiedTopology: true });
const db = mongoose.connection;
db.on('error', console.error.bind(console, 'MongoDB connection error:'));
db.once('open', () => {
  console.log('Connected to MongoDB');
});
// Define a simple schema and model
const ItemSchema = new mongoose.Schema({ name: String });
const Item = mongoose.model('Item', ItemSchema);
// Insert a test document
app.get('/insert', async (req, res) => {
  const newItem = new Item({ name: "Hello MongoDB" });
  await newItem.save();
  res.send({ message: "Item inserted" });
});
// Retrieve data from MongoDB
app.get('/items', async (req, res) => {
  const items = await Item.find();
  res.send(items);
});
// Start server
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});

