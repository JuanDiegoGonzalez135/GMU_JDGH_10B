package utez.edu.mx.gmuback.utils;

import org.springframework.http.HttpStatus;

public class APIResponse {

    private Object data;
    private boolean error;
    private String mensaje;
    private HttpStatus status;

    public APIResponse(String mensaje, HttpStatus status) {
        this.mensaje = mensaje;
        this.status = status;
    }

    public APIResponse(String mensaje, Object data, HttpStatus status) {
        this.mensaje = mensaje;
        this.data = data;
        this.status = status;
    }

    public APIResponse(boolean error, String mensaje, HttpStatus status) {
        this.error = error;
        this.mensaje = mensaje;
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
