package dictionaries;

public enum MeasurableFrequencies {

    EVERY_DAY("Every day"), EVERY_WEEK("Every week"), EVERY_MONTH("Every month");

    private String name;

    MeasurableFrequencies(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
