**BetterThanWools brings the wool processing line and Knitting system from [Better Than Wolves](https://wiki.btwce.com/view/Main_Page) to modern Minecraft.**

🛠️ **Mechanics:** Sheep now drop raw wool instead of blocks. Raw wool must be processed by hand with Knitting Needles into Wool Knits, which are used to make early-game armor, bedrolls, and other colorful wool products.

⚙️ **Config:** BetterThanWools is highly configurable. In its default state the mod is configured to closely mirror the BetterThanWolves wool mechanics, but several new options are included to configure the mod to your needs.

*Features marked as **New** are 'new' features not in the original Better Than Wolves mod.*

## 🧾 Requirements

- [Fabric API](https://modrinth.com/mod/fabric-api)
- [Slowcraft](https://modrinth.com/mod/slowcraft) library
- (Optional) [JEI](https://modrinth.com/mod/jei)
- (Optional) [Mod Menu](https://modrinth.com/mod/modmenu) and [Cloth Config](https://modrinth.com/mod/cloth-config)

## 🪡 Knitting

Knitting Needles are crafted with two sticks. Craft two Raw Wool with the Knitting Needles to create a Knitting tool.

Hold right-click with the Knitting tool to work on it. Its durability bar shows your progress, and once completed, you'll receive a Wool Knit and be given back the Knitting Needles.

Knitting progress is saved whenever you stop, allowing Knits to be completed a little at a time... Now you can weave through the night!

**New:** The default knitting time is 60 seconds and can be changed in the configuration.

## 🐑 Wool Processing

There is now more involved progression between sheep and finished wool products:

- Sheep drop and produce Raw Wool instead of complete wool blocks
- Knitting turns Raw Wool into Wool Knits
- Wool Knits are used to craft armor and bedrolls
- The vanilla String -> Wool Block recipe is replaced with a more demanding alternative by default
- **New:** Optional regressive recipes allow processed materials to be broken back down

## 🎨 Color Combination System

This mod adds the Color Combination system from BetterThanWolves, allowing two different colored pieces of Raw Wool to be crafted with Knitting Needles into a single Knitting tool.

Using two Raw Wool of the same color produces that color, but different colors can also be paired, letting players blend through the full set of 16 wool colors.

<details>
<summary>Color Combination Table</summary>

Use the color on the left as the first Raw Wool, then find the second Raw Wool across the top to find the resulting Wool Knit color:


| Raw Wool   | White      | Black  | Gray       | Brown      | Light Gray | Red        | Green      | Orange     | Yellow     | Lime       | Blue    | Light Blue | Cyan    | Purple  | Pink    | Magenta |
| ---------- | ---------- | ------ | ---------- | ---------- | ---------- | ---------- | ---------- | ---------- | ---------- | ---------- | ------- | ---------- | ------- | ------- | ------- | ------- |
| Magenta    | White      | Purple | Magenta    | Purple     | Magenta    | Magenta    | Purple     | Pink       | Pink       | Gray       | Purple  | Magenta    | Magenta | Purple  | Magenta | Magenta |
| Pink       | White      | Purple | Light Gray | Purple     | Gray       | Orange     | Light Gray | Pink       | Orange     | Gray       | Magenta | Light Blue | Gray    | Magenta | Pink    |         |
| Purple     | Light Blue | Purple | Purple     | Purple     | Pink       | Purple     | Purple     | Magenta    | Gray       | Light Gray | Blue    | Purple     | Purple  | Purple  |         |         |
| Cyan       | Light Blue | Cyan   | Cyan       | Cyan       | Cyan       | Purple     | Cyan       | Light Gray | Gray       | Pink       | Blue    | Cyan       | Cyan    |         |         |         |
| Light Blue | Light Blue | Cyan   | Cyan       | Purple     | Gray       | Light Gray | Cyan       | Gray       | Light Gray | Gray       | Cyan    | Light Blue |         |         |         |         |
| Blue       | Light Blue | Cyan   | Cyan       | Cyan       | Cyan       | Purple     | Cyan       | Light Gray | Light Gray | Cyan       | Blue    |            |         |         |         |         |
| Lime       | Light Gray | Green  | Pink       | Pink       | Lime       | Pink       | Pink       | Orange     | Lime       | Lime       |         |            |         |         |         |         |
| Yellow     | White      | Green  | Orange     | Orange     | Orange     | Orange     | Orange     | Orange     | Yellow     |            |         |            |         |         |         |         |
| Orange     | Pink       | Brown  | Orange     | Red        | Orange     | Orange     | Orange     | Orange     |            |            |         |            |         |         |         |         |
| Green      | Light Gray | Brown  | Green      | Brown      | Gray       | Brown      | Green      |            |            |            |         |            |         |         |         |         |
| Red        | Pink       | Brown  | Purple     | Brown      | Purple     | Red        |            |            |            |            |         |            |         |         |         |         |
| Light Gray | White      | Gray   | Light Gray | Light Gray | Light Gray |            |            |            |            |            |         |            |         |         |         |         |
| Brown      | Light Gray | Black  | Brown      | Brown      |            |            |            |            |            |            |         |            |         |         |         |         |
| Gray       | Light Gray | Black  | Gray       |            |            |            |            |            |            |            |         |            |         |         |         |         |
| Black      | Light Gray | Black  |            |            |            |            |            |            |            |            |         |            |         |         |         |         |
| White      | White      |        |            |            |            |            |            |            |            |            |         |            |         |         |         |         |


This makes wool processing more interesting: spare colors can be blended into new Knits instead of every color needing to be dyed directly.

</details>

## 🧥 Wool Equipment

Finished Wool Knits can be made into a complete set of dyeable wool clothing:

- **Wool Tuque**
- **Wool Jacket**
- **Wool Britches**
- **Wool Waders**

The recipes are cheaper than a vanilla set of Minecraft armor, only requiring 1-4 Knits for each piece.

**New:** Optional configuration settings can give wool armor knockback resistance or grant Fire Resistance while wearing the complete set.

## ⛺ Bedrolls

Wool Knits can also be crafted into thin, sleeping-bag style bedrolls available in all 16 colors.

Bedrolls are rugged, and do not change players spawn point when sleeping in them. 

**New:** Setting spawn with a bedroll can be enabled in the configuration.

## 🧰 **New:** Configuration

BetterThanWools includes a robust config, and has options for:

- Knitting time
- Sheep shearing drops
- Sheep death drops
- Removal of the vanilla string -> wool block recipe
- Regressive processing recipes
- Whether bedrolls set spawn
- Wool armor knockback resistance
- Wool armor full-set Fire Resistance

The configuration is stored in `config/betterthanwools.json`.

## ➡️ Integration

With [JEI](https://modrinth.com/mod/jei) installed, BetterThanWools Knitting tools use Slowcraft's **Progressive Crafting** recipe category, showing their outputs and crafting time.

With [Mod Menu](https://modrinth.com/mod/modmenu) and [Cloth Config](https://modrinth.com/mod/cloth-config), the config settings can be changed in-game.

## 📃 Source

BetterThanWools is open source under MIT at [GitHub](https://github.com/nibbyy/betterthanwools).

## 📣 Credits

- **FlowerChild** for being a bloom of inspiration and creativity.
- **BTW CE 3.0 Community** for continuing the legacy.
