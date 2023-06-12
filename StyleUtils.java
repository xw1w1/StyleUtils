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

    /**
    * Class made for more convenient work with text elements and text
    * @version 1.5
    */
public class StyleUtils {

    
    /**
     *
     * @param components List of components to be converted into one
     * @return Array of objects
     * @since 1.1
     */
    public static @NotNull Component single(@NotNull Component... components) {
            return Component.join(JoinConfiguration.noSeparators(), components);
    }

    /**
     *
     * @param object object to be transformed
     * @return Component with content of the form String.valueOf(object)
     * @since 1.1
     */
    public static @NotNull Component component(@NotNull Object object) {
        return object instanceof Component c ? c : Component.text(String.valueOf(object));
    }

    /**
     *
     * @param objects objects to be converted into components
     * @return Component[]
     * @since 1.1
     */
    public static @NotNull Component @NotNull [] components(@Nullable Object @NotNull ... objects) {
            return Arrays.stream(objects).filter(Objects::nonNull).map(StyleUtils::component).toArray(Component[]::new);
    }

    /**
     * @param objects Objects to be newlined (will be transformed to Components)
     * @return Component.text() with newlined Components (objects)
     * @since 1.5
     **/
    public static @NotNull Component newlined(@NotNull Object... objects) {
        return Component.join(JoinConfiguration.newlines(), components(objects));
    }

    /**
     * @return Component.newline()
     * @since 1.2
     **/
    public static @NotNull Component newline() {
        return Component.newline();
    }

    /**
     * @return Component.empty()
     * @since 1.2
     */
    public static @NotNull Component empty() {
        return Component.empty();
    }
    

    /**
     *
     * @param objects Components that needs to be transformed into String
     * @return String of text provided in objects
     * @since 1.5
     */
    public static @NotNull String toString(@NotNull Object... objects) {
        return PlainTextComponentSerializer.plainText().serialize(single(components(objects)));
    }

    /**
     *
     * @param objects Strings or Components to be colored in gradient
     * @param firstColor HEX color in format "000000"
     * @param secondColor HEX color in format "000000"
     * @return Component.text() colored in gradient
     */
    public static @NotNull Component gradient(@NotNull String firstColor, @NotNull String secondColor, Object @NotNull ... objects) {
        return MiniMessage.miniMessage().deserialize("<gradient:#" + firstColor + ":#" + secondColor + "><content></gradient>",
                Placeholder.component("content", single(components(objects))));
    }

    /**
     *
     * @param objects Strings or Components to be colored in specified HEX color
     * @param color HEX color in format "#000000"
     * @return Component.text() colored in specified HEX color
     * @since 1.4
     */
    public static @NotNull Component hex(@NotNull String color, @Nullable Object @NotNull ... objects) {
        return single(components(objects)).colorIfAbsent(TextColor.fromHexString(color));
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component with bold text decoration
     * @return Component.text(objects) decorated with TextDecoration.BOLD
     * @since 1.1
     */
    public static @NotNull Component bold(@Nullable Object... objects) {
        return single(components(objects)).decorate(TextDecoration.BOLD);
    }

    /**
     *
     * @param objects Objects (components) on which all TextDecoration needs to be remover
     * @return Component.text(objects) without any TextDecoration
     * @since 1.3
     */
    public static @NotNull Component destyle(@Nullable Object... objects) {
        return single(components(objects)).decoration(TextDecoration.ITALIC, false).decoration(TextDecoration.BOLD, false).decoration(TextDecoration.UNDERLINED, false)
                .decoration(TextDecoration.STRIKETHROUGH, false).decoration(TextDecoration.OBFUSCATED, false);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component with strikethrough text decoration
     * @return Component.text(objects) decorated with TextDecoration.STRIKETHROUGH
     * @since 1.1
     */
    public static @NotNull Component italic(@Nullable Object... objects) {
        return single(components(objects)).decorate(TextDecoration.ITALIC);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component with strikethrough text decoration
     * @return Component.text(objects) decorated with TextDecoration.STRIKETHROUGH
     * @since 1.1
     */
    public static @NotNull Component strikethrough(@Nullable Object... objects) {
        return single(components(objects)).decorate(TextDecoration.STRIKETHROUGH);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component with underlined text decoration
     * @return Component.text(objects) decorated with TextDecoration.UNDERLINED
     * @since 1.1
     */
    public static @NotNull Component underlined(@Nullable Object... objects) {
        return single(components(objects)).decorate(TextDecoration.UNDERLINED);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component with obfuscated text decoration
     * @return Component.text(objects) decorated with TextDecoration.OBFUSCATED
     * @since 1.1
     */
    public static @NotNull Component obfuscated(@Nullable Object... objects) {
        return single(components(objects)).decorate(TextDecoration.OBFUSCATED);
    }

    /**
     *
     * @param component The component which the hover event will be applied to
     * @param objects Components displayed in the hover event
     * @return Component.text() with HoverEvent that equals to objects.
     * @since 1.2
     */
    public static @NotNull Component hover(@NotNull Component component, @Nullable Object... objects) {
        return component.hoverEvent(HoverEvent.showText(single(components(objects))));
    }

    /**
     *
     * @param component The component which the click event will be applied to
     * @param link Link to be opened on click
     * @return Component.text() with ClickEvent.openUrl
     * @since 1.2
     */
    public static @NotNull Component openUrl(@NotNull Component component, @NotNull String link) {
        return component.clickEvent(ClickEvent.openUrl(link));
    }

    /**
     *
     * @param component The component which the click event will be applied to
     * @param command Command to be suggested
     * @return Component.text() with ClickEvent.suggestCommand
     * @since 1.2
     */
    public static @NotNull Component suggestCommand(@NotNull Component component, @NotNull String command) {
        return component.clickEvent(ClickEvent.suggestCommand(command));
    }

    /**
     *
     * @param component The component which the click event will be applied to
     * @param command Command to be executed
     * @return Component.text() with ClickEvent.runCommand
     * @since 1.2
     */
    public static @NotNull Component runCommand(@NotNull Component component, @NotNull String command) {
        return component.clickEvent(ClickEvent.runCommand(command));
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in red
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.RED)
     * @since 1.0
     */
    public static @NotNull Component red(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.RED);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark_red
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_RED)
     * @since 1.0
     */
    public static @NotNull Component darkRed(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_RED);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in gold
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.GOLD)
     * @since 1.0
     */
    public static @NotNull Component gold(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.GOLD);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in yellow
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.YELLOW)
     * @since 1.0
     */
    public static @NotNull Component yellow(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.YELLOW);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in green
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.GREEN)
     * @since 1.0
     */
    public static @NotNull Component green(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.GREEN);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark green
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_GREEN)
     * @since 1.0
     */
    public static @NotNull Component darkGreen(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_GREEN);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in aqua
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.AQUA)
     * @since 1.0
     */
    public static @NotNull Component aqua(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.AQUA);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark aqua
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_AQUA)
     * @since 1.0
     */
    public static @NotNull Component darkAqua(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_AQUA);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in blue
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.BLUE)
     * @since 1.0
     */
    public static @NotNull Component blue(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.BLUE);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark blue
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_BLUE)
     * @since 1.0
     */
    public static @NotNull Component darkBlue(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_BLUE);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in light purple (NOT PINK)
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.LIGHT_PURPLE)
     * @since 1.0
     */
    public static @NotNull Component lightPurple(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.LIGHT_PURPLE);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark purple (NOT PINK)
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_PURPLE)
     * @since 1.0
     */
    public static @NotNull Component darkPurple(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_PURPLE);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in gray
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.GRAY)
     * @since 1.0
     */
    public static @NotNull Component gray(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.GRAY);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in dark gray
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.DARK_GRAY)
     * @since 1.0
     */
    public static @NotNull Component darkGray(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.DARK_GRAY);
    }


    /**
     *
     * @param objects String text which will then be transformed into a Component colored in black
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.BLACK)
     * @since 1.0
     */
    public static @NotNull Component black(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.BLACK);
    }

    /**
     *
     * @param objects String text which will then be transformed into a Component colored in white
     * @return Component.text(String.valueOf(objects)).color(NamedTextColor.WHITE)
     * @since 1.0
     */
    public static @NotNull Component white(@Nullable Object... objects) {
        return single(components(objects)).colorIfAbsent(NamedTextColor.WHITE);
    }
    
    public static @NotNull Component text(@Nullable Object... objects) {
        return single(components(objects));
    }
}
