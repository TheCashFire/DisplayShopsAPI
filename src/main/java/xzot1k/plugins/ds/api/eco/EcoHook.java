package xzot1k.plugins.ds.api.eco;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class EcoHook {

    private String altName, symbol;
    private int decimalPlacement;
    private boolean rawPlaceholderValue;

    public EcoHook() {
        setAltName(null);
        setSymbol("$");
        setDecimalPlacement(2);
        setRawPlaceholderValue(false);
    }

    public abstract String getSingularName();

    public abstract String getPluralName();

    public abstract boolean deposit(@NotNull UUID playerUniqueId, double amount);

    public abstract boolean deposit(@NotNull OfflinePlayer player, double amount);

    public abstract boolean withdraw(@NotNull UUID playerUniqueId, double amount);

    public abstract boolean withdraw(@NotNull OfflinePlayer player, double amount);

    public abstract double getBalance(@NotNull UUID playerUniqueId);

    public abstract double getBalance(@NotNull OfflinePlayer player);

    /**
     * @return The economy name based on available options.
     */
    public String getName() {
        return ((getAltName() != null && !getAltName().isEmpty()) ? getAltName()
                : ((getPluralName() != null && !getPluralName().isEmpty()) ? getPluralName() : getSingularName()))
                .replace("{symbol}", (getSymbol() != null ? getSymbol() : ""));
    }

    public String getAltName() {return altName;}

    public void setAltName(String altName) {this.altName = altName;}

    public String getSymbol() {return symbol;}

    public void setSymbol(String symbol) {this.symbol = symbol;}

    public int getDecimalPlacement() {return decimalPlacement;}

    public void setDecimalPlacement(int decimalPlacement) {this.decimalPlacement = decimalPlacement;}

    public boolean isRawPlaceholderValue() {return rawPlaceholderValue;}

    public void setRawPlaceholderValue(boolean rawPlaceholderValue) {this.rawPlaceholderValue = rawPlaceholderValue;}

}