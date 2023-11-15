package christmas.enums;

public enum Badge {
    NONE("없음"),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private final String displayName;

    Badge(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Badge fromTotalBenefits(int totalBenefits) {
        if (totalBenefits >= 20000) {
            return SANTA;
        } else if (totalBenefits >= 10000) {
            return TREE;
        } else if (totalBenefits >= 5000) {
            return STAR;
        }
        return NONE;
    }
}
