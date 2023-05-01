# StyleUtils
part of ru.mineum.mcore TextSenderAdapter

This class was created to simplify the creation of Components from the Kyori Adventure API.

It contains methods that can recolor, add decoration, remove decoration, or glue multiple components together

# Usage
for example:

`single(red("red text ", aqua("with some aqua text")))`

will give us:

`Component.text("red text ").color(NamedTextColor.RED).append(Component.text("with some aqua text").color(NamedTextColor.AQUA))`

![image](https://user-images.githubusercontent.com/102028245/235480188-a33a0ed9-d717-43c5-a7d1-51bdd56b15f7.png)


`red("text ", gold("more text "), "with more text")`

will give us:

`MiniMessage.miniMessage.deserialize("<red>text <gold>moretext </gold>with more text")` 


![image](https://user-images.githubusercontent.com/102028245/235476435-bb87d098-8127-4fa2-a5c5-7d75764c7a9d.png)


`bold(red("red bold text"))` same as `italic()` and `obfuscated()` or `strikethrough()` i don't think needs to be explained

`destyle(Object)` will remove all TextDecorations from your Object (Component)

also you can use `gradient(int color1, int color2, "text" (can be a component, like bold() or red()))` where `color` = HEX num

gradient with 3 or even 4 colors also avaliable

`hex(String #000000)` returns you Component.text colored in specified HEX color

check `hover()`, `suggestCommand()`, `openUrl()` etc. in java file

As you can see it really cuts down the code, so, as for me, this thing really makes sense

![image](https://user-images.githubusercontent.com/102028245/235472856-184671a0-b9d6-4296-bdb2-eb4a2d758a9d.png)

![image](https://user-images.githubusercontent.com/102028245/235480718-a4210b92-1be8-47d6-8330-60e1e960f920.png)

# GLORY TO PaperMC and Kyori ofc

