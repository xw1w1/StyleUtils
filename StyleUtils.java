import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Arrays;
import java.util.Objects;

public class StyleUtils {

    /**
     *
     * @param components List of components to be converted into one
     * @return Array of objects
     */
    public @NotNull Component single(@NotNull Component... components) {
            return Component.join(JoinConfiguration.noSeparators(), components);
    }

    /**
     *
     * @param object object to be transformed
     * @return Component with content of the form String.valueOf(object)
     */
    public static @NotNull Component component(@NotNull Object object) {
        return object instanceof Component c ? c : Component.text(String.valueOf(object));
    }

    /**
     *
     * @param objects objects to be converted into components
     * @return Component[]
     */
    public static @NotNull Component @NotNull [] components(@Nullable Object @NotNull ... objects) {
        return Arrays.stream(objects).filter(Objects::nonNull).map(StyleUtils::component).toArray(Component[]::new);
    }

    /**
     * @return Component.newline()
     **/
    public static @NotNull Component newline() {
        return Component.newline();
    }


    /**
     * @return Component.empty()
     */
    public static @NotNull Component empty() {
        return Component.empty();
    }

    /**
     *
     * @param objects Strings or Components to be colored in gradient
     * @param firstColor HEX color in format "000000"
     * @param secondColor HEX color in format "000000"
     * @return Component.text() colored in gradient
     */
    public @NotNull Component gradient(int firstColor, int secondColor, Object @NotNull... objects) {
        return MiniMessage.miniMessage().deserialize("<gradient:#" + firstColor + ":#" + secondColor + "><content></gradient>",
                Placeholder.component("content", single(components(objects))));
    }

    /**
     *
     * @param objects Strings or Components to be colored in gradient
     * @param firstColor HEX color in format "000000"
     * @param secondColor HEX color in format "000000"
     * @param thirdColor HEX color in format "000000"
     * @return Component.text() colored in gradient
     */
    public @NotNull Component gradient(int firstColor, int secondColor, int thirdColor, @Nullable Object @NotNull... objects) {
        return MiniMessage.miniMessage().deserialize("<gradient:#" + firstColor + ":#" + secondColor + ":#" + thirdColor + "><content></gradient>",
                Placeholder.component("content", single(components(objects))));
    }

    /**
     *
     * @param objects Strings or Components to be colored in gradient
     * @param firstColor HEX color in format "000000"
     * @param secondColor HEX color in format "000000"
     * @param thirdColor HEX color in format "000000"
     * @param fourthColor HEX color in format "000000"
     * @return Component.text() colored in gradient
     */
    public @NotNull Component gradient(int firstColor, int secondColor, int thirdColor, int fourthColor, @Nullable Object @NotNull... objects) {
        return MiniMessage.miniMessage().deserialize("<gradient:#" + firstColor + ":#" + secondColor + ":#" + thirdColor + ":#" + fourthColor + "><content></gradient>",
                Placeholder.component("content", single(components(objects))));
    }

    /**
     *
     * @param objects Strings or Components to be colored in specified HEX color
     * @param color HEX color in format "000000"
     * @return Component.text() colored in specified HEX color
     */
    public @NotNull Component hex(int color, @Nullable Object @NotNull... objects) {
        return single(components(objects)).colorIfAbsent(TextColor.fromHexString("#" + color));
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component without any decoration
     * @return Component.text(String.valueOf(object)) decorated with no any TextDecoration
     */
    public @NotNull Component destyle(@Nullable Object... objects) {
        return single(components(objects)).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, false).decoration(TextDecoration.UNDERLINED, false)
                .decoration(TextDecoration.STRIKETHROUGH, false).decoration(TextDecoration.OBFUSCATED, false);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component with bold text decoration
     * @return Component.text(objects) decorated with TextDecoration.BOLD
     */
    public @NotNull Component bold(@Nullable Object... objects) {
        return single(components(objects)).decorate(TextDecoration.BOLD);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component with italic text decoration
     * @return Component.text(objects) decorated with TextDecoration.ITALIC
     */
    public @NotNull Component italic(@Nullable Object... objects) {
        return single(components(objects)).decorate(TextDecoration.ITALIC);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component with strikethrough text decoration
     * @return Component.text(objects) decorated with TextDecoration.STRIKETHROUGH
     */
    public @NotNull Component strikethrough(@Nullable Object... objects) {
        return single(components(objects)).decorate(TextDecoration.STRIKETHROUGH);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component with underlined text decoration
     * @return Component.text(objects) decorated with TextDecoration.UNDERLINED
     */
    public @NotNull Component underlined(@Nullable Object... objects) {
        return single(components(objects)).decorate(TextDecoration.UNDERLINED);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component with obfuscated text decoration
     * @return Component.text(objects) decorated with TextDecoration.OBFUSCATED
     */
    public @NotNull Component obfuscated(@Nullable Object... objects) {
        return single(components(objects)).decorate(TextDecoration.OBFUSCATED);
    }

    /**
     *
     * @param component The component which the hover event will be applied to
     * @param objects Components displayed in the hover event
     * @return Component.text() with HoverEvent that equals to objects.
     */
    public @NotNull Component hover(@NotNull Component component, @Nullable Object... objects) {
        return component.hoverEvent(HoverEvent.showText(single(components(objects))));
    }

    /**
     *
     * @param component The component which the click event will be applied to
     * @param link Link to be opened on click
     * @return Component.text() with ClickEvent.openUrl
     */
    public @NotNull Component openUrl(@NotNull Component component, @NotNull String link) {
        return component.clickEvent(ClickEvent.openUrl(link));
    }

    /**
     *
     * @param component The component which the click event will be applied to
     * @param command Command to be suggested
     * @return Component.text() with ClickEvent.suggestCommand
     */
    public @NotNull Component suggestCommand(@NotNull Component component, @NotNull String command) {
        return component.clickEvent(ClickEvent.suggestCommand(command));
    }

    /**
     *
     * @param component The component which the click event will be applied to
     * @param command Command to be executed
     * @return Component.text() with ClickEvent.runCommand
     */
    public @NotNull Component runCommand(@NotNull Component component, @NotNull String command) {
        return component.clickEvent(ClickEvent.runCommand(command));
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in red
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.RED)
     */
    public @NotNull Component red(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.RED);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark_red
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_RED)
     */
    public @NotNull Component darkRed(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_RED);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in gold
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.GOLD)
     */
    public @NotNull Component gold(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.GOLD);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in yellow
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.YELLOW)
     */
    public @NotNull Component yellow(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.YELLOW);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in green
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.GREEN)
     */
    public @NotNull Component green(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.GREEN);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark green
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_GREEN)
     */
    public @NotNull Component darkGreen(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_GREEN);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in green
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.GREEN)
     */
    public @NotNull Component aqua(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.AQUA);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark aqua
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_AQUA)
     */
    public @NotNull Component darkAqua(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_AQUA);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in blue
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.BLUE)
     */
    public @NotNull Component blue(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.BLUE);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark blue
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_BLUE)
     */
    public @NotNull Component darkBlue(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_BLUE);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in light purple (NOT PINK)
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.LIGHT_PURPLE)
     */
    public @NotNull Component lightPurple(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.LIGHT_PURPLE);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark purple (NOT PINK)
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_PURPLE)
     */
    public @NotNull Component darkPurple(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_PURPLE);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in gray
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.GRAY)
     */
    public @NotNull Component gray(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.GRAY);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark gray
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_GRAY)
     */
    public @NotNull Component darkGray(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_GRAY);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in black
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.BLACK)
     */
    public @NotNull Component black(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.BLACK);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in white
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.WHITE)
     */
    public @NotNull Component white(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.WHITE);
    }

    public @NotNull Component example() {
        Component example1 = red("Red text ", bold(aqua("with some bold aqua text, "), "or not aqua? "),
                italic(gold("how about orange?")), " or still want red?", newline(), yellow(" Lets start from "), yellow("new line"));
        Component example2 = single(italic(underlined(gray("scary and "), obfuscated("tttttttt"))),
                red(". Example text."), strikethrough(green(" Strikethrough text.")));
        return single(example1, example2);
    }
}
