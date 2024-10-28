package main;

public class WeightComparison {
    private final double weight;
    private final WeightCategory category;
    private String suggestion = "";

    public WeightComparison(WeightCategory category, double weight) {
        this.weight = weight;
        this.category = category;
    }

    public String getResult() {
        String result = "";
        int lowerLimit = category.getLowerLimit();
        int upperLimit = category.getUpperLimit();

        if (weight > upperLimit) {
            result = String.format("Exceeds limit by %.2f kg.", weight - upperLimit);
            suggestion = "Athlete needs to lose weight.";
        } else if (weight < lowerLimit) {
            result = String.format("Below limit by %.2f kg.", lowerLimit - weight);
            suggestion = "Athlete needs to gain weight.";
        } else {
            result = "Within limit.";
        }

        return result;
    }

    public String getSuggestion() {
        return suggestion;
    }

}
