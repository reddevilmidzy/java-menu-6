package menu.model;

public class CoachName {

    private final String name;

    public CoachName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        //TODO: 길이 2~4 확인
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CoachName{" +
                "name='" + name + '\'' +
                '}';
    }
}
