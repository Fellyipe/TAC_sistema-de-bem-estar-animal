const mongoose = require("mongoose");

const LeituraSchema = new mongoose.Schema({
  idSensor: { type: String, require: true },
});

module.exports = mongoose.model("Leitura", LeituraSchema, "leitura");
