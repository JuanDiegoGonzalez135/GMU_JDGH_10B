package utez.edu.mx.gmuback.modules.rol;

public enum Role {
    ADMIN("ROLE_ADMIN"),
    STUDENT("ROLE_STUDENT");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
