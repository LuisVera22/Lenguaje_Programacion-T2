package pe.com.cibertec.Lenguaje_Programacion_T2.main.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "tb_area")
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id", nullable = false, unique = true)
    private Integer area_id;
    
    @Column(name = "nombre_area", columnDefinition = "VARCHAR(45)", nullable = false, unique = true)
    private String nombre_area;
    
    @OneToMany(mappedBy = "area")
    private List<EmpleadoEntity> empleados;
}
