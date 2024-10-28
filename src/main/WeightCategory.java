package main;

public enum WeightCategory {
    FLYWEIGHT(40, 66) {
        @Override
        public String toString() {
            return "Flyweight";
        }
    },
    LIGHTWEIGHT(67, 73) {
        @Override
        public String toString() {
            return "Lightweight";
        }
    },
    LIGHT_MIDDLEWEIGHT(74, 81) {
        @Override
        public String toString() {
            return "Light-Middleweight";
        }
    },
    MIDDLEWEIGHT(82, 90) {
        @Override
        public String toString() {
            return "Middleweight";
        }
    },
    LIGHT_HEAVYWEIGHT(91, 100) {
        @Override
        public String toString() {
            return "Light-Heavyweight";
        }
    },
    HEAVYWEIGHT(101, 200) {
        @Override
        public String toString() {
            return "Heavyweight";
        }
    };
    private final int lowerLimit;
    private final int upperLimit;

    WeightCategory(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public static String[] getCategories() {
        String[] categories = new String[WeightCategory.values().length];
        for (int i = 0; i < categories.length; i++) {
            categories[i] = WeightCategory.values()[i].toString();
        }
        return categories;
    }
}

