package com.login.loginjwt;

import com.login.loginjwt.api.MedicosController;
import com.login.loginjwt.domain.Medicos;
import com.login.loginjwt.repo.MedicosRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MedicosRepoTest {
    @Mock
    private MedicosRepo testMedicos;
    @InjectMocks
    private MedicosController medicosController;
    private Medicos medicos;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        medicos = new Medicos();
        medicos.setId(1);
        medicos.setNombre("Efrain");
        medicos.setApellido("Caza");
        medicos.setDescripcion("Medico");
        medicos.setUrlImagen("algo.jpg");
    }
    @Test
    void verMedicos(){
        when(testMedicos.findAll()).thenReturn(Arrays.asList(medicos));
        assertNotNull(testMedicos.findAll());
    }
}
