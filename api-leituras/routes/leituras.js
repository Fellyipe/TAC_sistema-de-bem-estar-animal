var express = require("express");
const Leitura = require("../models/Leitura");
const { default: mongoose } = require("mongoose");
const isAutenticated = require("../middlewares/isAutenticated");
var router = express.Router();

/* GET ALL */
router.get("/", isAutenticated, async function (req, res, next) {
  // const { name = '' } = req.query ? req.query : {};

  // console.log("name", name);

  return res.json(await Leitura.find());
});

/* GET BY ID*/
router.get("/:id", isAutenticated, async (req, res) => {
  const { id } = req.params;

  let _id = null;

  try {
    _id = new mongoose.Types.ObjectId(id);
  } catch (e) {
    return res.status(400).json({ message: "ID inválido" });
  }

  const user = await Leitura.findById(id);

  return user
    ? res.json(user)
    : res.status(404).json({ message: "Leitura não encontrado." });
});

/* CREATE */
router.post("/", async (req, res) => {
  const json = req.body;

  const user = new Leitura(json);

  const error = user.validateSync();

  return error ? res.status(400).json(error) : res.json(await user.save());

  // console.log(user);

  // users.push(user);

  // res.json({ message: "Criar pessoa" });
});

/* UPDATE */
router.put("/:id", isAutenticated, async (req, res) => {
  const { id } = req.params;
  const json = req.body;

  const user = await Leitura.findByIdAndUpdate(id, json, { new: true });

  return user
    ? res.json(user)
    : res.status(404).json({ message: "Leitura não encontrado." });
});

/* DELETE */
router.delete("/:id", isAutenticated, async (req, res) => {
  const { id } = req.params;

  const user = await Leitura.findByIdAndDelete(id);

  return user
    ? res.json({ message: "Leitura deletada com sucesso." })
    : res.status(404).json({ message: "Leitura não encontrado." });
});

module.exports = router;
