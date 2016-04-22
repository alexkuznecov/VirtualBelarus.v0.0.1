package by.grsu.domain;

public enum SceneType {

    SceneTypeCubic(0,"SceneTypeCubic"),
    SceneTypeCylindrical(1, "SceneTypeCylindrical"),
    SceneTypeSphire(2,"SceneTypeSphire");

    private Integer value;

    private String name;

    SceneType(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
