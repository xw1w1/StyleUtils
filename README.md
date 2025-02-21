# StyleUtils
This class was created to simplify the creation of Components from the Kyori Adventure API.

It contains methods that can create colored text, add decoration, remove decoration, or glue multiple components together

# Usage

##Colors
For example, this methods used together:
`single(red("red text "), aqua("with some aqua text"))`

will give us:

`Component.text("red text ").color(NamedTextColor.RED).append(Component.text("with some aqua text").color(NamedTextColor.AQUA))`

![image](https://user-images.githubusercontent.com/102028245/235480188-a33a0ed9-d717-43c5-a7d1-51bdd56b15f7.png)

Or, we can omit the `single()` method and write directly like this:
`red("text ", gold("more text "), "with more text")`

Equivalent to this:

`MiniMessage.miniMessage.deserialize("<red>text <gold>moretext </gold>with more text")` 


![image](https://user-images.githubusercontent.com/102028245/235476435-bb87d098-8127-4fa2-a5c5-7d75764c7a9d.png)


## Text Decorations
Here we have all possible text decorations, like BOLD, TALIC, OBFUSCATED, STRIKETHROUGH etc.
for example: `bold(red("red bold text"))`, `italic()`, `obfuscated()` and `strikethrough()`

`destyle(Object)` will remove all TextDecorations from your component.


Also you can use `gradient(String color1, String color2, "text" (can be a component, like bold() or red()))` where `colors` is a hex strings, WITHOUT #'s

Method `hex(color, objects)` returns you Component.text() colored in specified HEX color

## Events

You can manualy check `hover()`, `suggestCommand()`, `openUrl()` etc. methods in source file.

As you can see it really cuts down the code, so, as for me, this thing really makes sense

![image](https://user-images.githubusercontent.com/102028245/235472856-184671a0-b9d6-4296-bdb2-eb4a2d758a9d.png)

![image](https://user-images.githubusercontent.com/102028245/235480718-a4210b92-1be8-47d6-8330-60e1e960f920.png)

