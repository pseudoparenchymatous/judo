package main;

public enum WeightCategory {
    FLYWEIGHT,
    LIGHTWEIGHT,
    LIGHTMIDDLEWEIGHT,
    MIDDLEWEIGHT,
    LIGHTHEAVYWEIGHT,
    HEAVYWEIGHT;

    public static String[] getCategories() {
        String[] categories = new String[WeightCategory.values().length];
        for (int i = 0; i < categories.length; i++) {
            categories[i] = WeightCategory.values()[i].name();
        }
        return categories;
    }
}

