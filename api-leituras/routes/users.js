var express = require("express");
const User = require("../models/User");
const { default: mongoose } = require("mongoose");
const isAutenticated = require("../middlewares/isAutenticated");
var router = express.Router();

const users = [];

/* GET ALL */
router.get("/", isAutenticated, async function (req, res, next) {
  // const { name = '' } = req.query ? req.query : {};

  // console.log("name", name);

  return res.json(await User.find());
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

  const user = await User.findById(id);

  return user
    ? res.json(user)
    : res.status(404).json({ message: "User não encontrado." });
});

/* CREATE */
router.post("/", async (req, res) => {
  const json = req.body;

  const user = new User(json);

  const error = user.validateSync();

  return error ? res.status(400).json(error) : res.json(await user.save());

  // console.log(user);

  // users.push(user);

  // res.json({ message: "Criar pessoa" });
});

/* UPDATE */
router.put("/:id", (req, res) => {
  res.json({ message: "Atualizar pessoa" });
});

/* DELETE */
router.delete("/:id", (req, res) => {
  res.json({ message: "Deletar pessoa" });
});

module.exports = router;
