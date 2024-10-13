package pe.com.cibertec.Lenguaje_Programacion_T2.main.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_empleado")
public class EmpleadoEntity {
    @Id
    @Column(name = "dni_empleado", columnDefinition = "CHAR(8)", length = 8, nullable = false, unique = true)
    private String dni_empleado;

    @Column(name = "nombre_empleado", columnDefinition = "VARCHAR(45)", nullable = false)
    private String nombre_empleado;

    @Column(name = "apellido_empleado", columnDefinition = "VARCHAR(45)", nullable = false)
    private String apellido_empleado;

    @Column(name = "fecha_nacimiento", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_nacimiento;

    @Column(name = "direccion", columnDefinition = "VARCHAR(45)", nullable = false)
    private String direccion;

    @Column(name = "correo", columnDefinition = "VARCHAR(45)", nullable = false, unique = true)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private AreaEntity area;
}
