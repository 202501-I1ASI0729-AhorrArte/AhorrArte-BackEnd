package com.finsuma.ahorrarte.platform.finantialEducation.interfaces.rest.resources;

public class FinantialEducationResource {

    private Long id;
    private String titulo;
    private PreguntaResource pregunta;
    private RespuestaResource respuesta;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public PreguntaResource getPregunta() { return pregunta; }

    public void setPregunta(PreguntaResource pregunta) { this.pregunta = pregunta; }

    public RespuestaResource getRespuesta() { return respuesta; }

    public void setRespuesta(RespuestaResource respuesta) { this.respuesta = respuesta; }
}
