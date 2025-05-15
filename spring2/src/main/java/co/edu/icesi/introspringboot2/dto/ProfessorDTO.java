package co.edu.icesi.introspringboot2.dto;

public class ProfessorDTO {
    private long id;
    private String name;

    // Constructor vacío (requerido por algunas libs y frameworks)
    public ProfessorDTO() {}

    // Constructor opcional si lo necesitas
    public ProfessorDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

