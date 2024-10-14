package main;

public enum WeightCategory {
    FLYWEIGHT {
        @Override
        public String toString() {
            return "Flyweight";
        }
    },
    LIGHTWEIGHT {
        @Override
        public String toString() {
            return "Lightweight";
        }
    },
    LIGHT_MIDDLEWEIGHT {
        @Override
        public String toString() {
            return "Light-Middleweight";
        }
    },
    MIDDLEWEIGHT {
        @Override
        public String toString() {
            return "Middleweight";
        }
    },
    LIGHT_HEAVYWEIGHT {
        @Override
        public String toString() {
            return "Light-Heavyweight";
        }
    },
    HEAVYWEIGHT {
        @Override
        public String toString() {
            return "Heavyweight";
        }
    };

    public static String[] getCategories() {
        String[] categories = new String[WeightCategory.values().length];
        for (int i = 0; i < categories.length; i++) {
            categories[i] = WeightCategory.values()[i].toString();
        }
        return categories;
    }
}

