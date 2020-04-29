package com.home.SpringBootDemo.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "P_TIPOS_SERVICIO")
@Data
public class PTipoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoServicio_generator")
    @SequenceGenerator(name="tipoServicio_generator", sequenceName = "P_TIPO_SERVICIO_PK_SEQ", allocationSize=1)
    private int IDP_TIPO_SERVICIO;
    private String DESCRIPCION_V;
    private Integer HORAS_ESPERADS_ATENCION_N;

    public PTipoServicio() {
    }

    public PTipoServicio(int idTipoServicio, String descripcion, Integer horasAtencion) {
        this.IDP_TIPO_SERVICIO = idTipoServicio;
        this.DESCRIPCION_V = descripcion;
        this.HORAS_ESPERADS_ATENCION_N = horasAtencion;
    }
    public PTipoServicio(String descripcion, Integer horasAtencion) {
        this.DESCRIPCION_V = descripcion;
        this.HORAS_ESPERADS_ATENCION_N = horasAtencion;
    }

}

