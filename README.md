# StyleUtils
This class was created to simplify the creation of Components from the Kyori Adventure API.

It contains methods that can create colored text, add decoration, remove decoration, or glue multiple components together

# Usage

## Colors
For example, this methods used together:
`single(red("Red text "), aqua("with some aqua text after"), green(", and a little bit of green"))`

will give us:

`Component.text("Red text ").color(NamedTextColor.RED)
.append(Component.text("with some aqua text after").color(NamedTextColor.AQUA))
.append(Component.text(, and a little bit of green").color(NamedTextColor.GREEN))`

![image](https://github.com/user-attachments/assets/de0f945f-0c97-4444-8bf0-b29641ca7d59)


Or, we can omit the `single()` method and write directly like this:
`red("A component ", gold("with even more components "), aqua("inside"), "!");`
_as you can see, if you just write a string after all those extra components, it will be the color it is in._

Equivalent to this:

`MiniMessage.miniMessage.deserialize("<red>A component</red> <gold>with even more components</gold> <aqua>inside</aqua> <red>!</red>")` 


![изображение](https://github.com/user-attachments/assets/56395519-f0e4-41f6-861f-3649470c19f6)



## Text Decorations
Here we have all possible text decorations, like BOLD, TALIC, OBFUSCATED, STRIKETHROUGH etc.
for example: `bold(red("Red bold text, "), strikethrough(aqua("and aqua text again.")));`, `italic()`, `obfuscated()` and `strikethrough()`
![изображение](https://github.com/user-attachments/assets/af2d7e3f-66e0-4b71-ba17-11e832157b41)


`destyle(Object)` will remove all TextDecorations from your component.


Also you can use `gradient(String color1, String color2, "text" (can be a component, like bold() or red()))` where `colors` is a hex strings, WITHOUT #'s
![изображение](https://github.com/user-attachments/assets/ae5e822e-2417-4710-b24e-1b80ee79e4f6)


Method `hex(color, objects)` returns you Component.text() colored in specified HEX color

## Events

You can manualy check `hover()`, `suggestCommand()`, `openUrl()` etc. methods in source file.

As you can see it really cuts down the code, so, as for me, this thing really makes sense

![image](https://user-images.githubusercontent.com/102028245/235472856-184671a0-b9d6-4296-bdb2-eb4a2d758a9d.png)

![image](https://user-images.githubusercontent.com/102028245/235480718-a4210b92-1be8-47d6-8330-60e1e960f920.png)

