package main;

public class WeightComparison {
    private final double weight;
    private final int[] limits;
    private final WeightCategory category;
    private String suggestion = "";

    public WeightComparison(WeightCategory category, double weight) {
        this.weight = weight;
        this.category = category;
        this.limits = switch (category) {
            case WeightCategory.FLYWEIGHT -> new int[] {0, 66};
            case WeightCategory.LIGHTWEIGHT -> new int[] {67, 73};
            case WeightCategory.LIGHTMIDDLEWEIGHT -> new int[] {74, 81};
            case WeightCategory.MIDDLEWEIGHT -> new int[] {82, 90};
            case WeightCategory.LIGHTHEAVYWEIGHT -> new int[] {91, 100};
            case WeightCategory.HEAVYWEIGHT -> new int[] {101, 0};
        };
    }

    public String getLimit() {
        return switch (category) {
            case WeightCategory.HEAVYWEIGHT -> "Unlimited";
            default -> String.format(limits[1] + " kg");
        };
    }

    public String getResult() {
        String result = "";
        switch (category) {
            case WeightCategory.FLYWEIGHT:
                if (weight < limits[1]) {
                    result = "Within limit.";
                } else {
                    result = String.format("Exceeds limit by %.2f kg.", weight - limits[1]);
                    suggestion = "Athlete needs to lose weight.";
                }
                break;
            case WeightCategory.HEAVYWEIGHT:
                if (weight < limits[0]) {
                    result = String.format("Below limit by %.2f kg.", limits[0] - weight);
                    suggestion = "Athlete needs to gain weight.";
                } else {
                    result = "Within limit.";
                }
                break;
            default: 
                if (weight < limits[0]) {
                    result = String.format("Below limit by %.2f kg.", limits[0] - weight);
                    suggestion = "Athlete needs to lose weight.";
                } else if (weight > limits[1]) {
                    result = String.format("Exceeds limit by %.2f kg.", weight - limits[1]);
                    suggestion = "Athlete needs to gain weight.";
                } else {
                    result = "Within limit.";
                }
        }

        return result;
    }

    public String getSuggestion() {
        return suggestion;
    }

}
