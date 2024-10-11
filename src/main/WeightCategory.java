package main;

public enum WeightCategory {
    FLYWEIGHT         (66),
    LIGHTWEIGHT       (73),
    LIGHTMIDDLEWEIGHT (81),
    MIDDLEWEIGHT      (90),
    LIGHTHEAVYWEIGHT  (100),
    HEAVYWEIGHT       (101);

    private final int limit;

    WeightCategory(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public static String[] getCategories() {
        String[] categories = new String[WeightCategory.values().length];
        for (int i = 0; i < categories.length; i++) {
            categories[i] = WeightCategory.values()[i].name();
        }
        return categories;
    }
}

