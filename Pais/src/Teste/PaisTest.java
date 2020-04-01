package Teste;

import model.Pais;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import service.PaisService;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	
    Pais pais, auxPais;
    PaisService paisService;
    static int id = 0;

    @Before
    public void setUp() throws Exception {
    	
    	System.out.println("setUp Test");
        pais = new Pais();
        pais.setId(id);
        pais.setNome("Brasil");
        pais.setPopulacao(Long.valueOf("2000000"));
        pais.setArea(String.valueOf(2093833));
        
        auxPais = new Pais();
        auxPais.setId(id);
        auxPais.setNome("França");
        auxPais.setPopulacao(Long.valueOf("9273633"));
        auxPais.setArea(String.valueOf(3838338));
        paisService = new PaisService();
        
        //Retorno 
        System.out.println(pais);
        System.out.println(auxPais);
        System.out.println(id);
    }

    @Test
    public void testCarregar() {
    	
        System.out.println("carregar @Test");
        Pais fixture = new Pais();
        fixture.setId(1);
        fixture.setNome("Inglaterra");
        fixture.setPopulacao(Long.valueOf("323342223"));
        fixture.setArea(String.valueOf(65443433));
        PaisService novoService = new PaisService();
        Pais novo = novoService.carregarPais(3);
        assertEquals("@Test - inclusao", novo, fixture);
    }

    @Test
    public void testCriar() {
    	
        System.out.println("criar @Test");
        id = paisService.incluirPais(pais);
        System.out.println(id);
        auxPais.setId(id);
        assertEquals("@Test - criacao", pais, auxPais);
    }

    @Test
    public void testAtualizar() {
    	
        System.out.println("atualizar @Test");
        pais.setPopulacao(Long.valueOf("323342223"));
        auxPais.setArea(String.valueOf(23498769));
        paisService.upDatePais(pais);
        pais = paisService.carregarPais(pais.getId());
        assertEquals("@Test - atualização", pais, auxPais);
    }

    @Test
    public void testExcluir() {
    	
        System.out.println("excluir @Test");
        auxPais.setId(-1);
        auxPais.setNome(null);
        auxPais.setPopulacao(null);
        auxPais.setArea(null);
        paisService.deletarPais(id);
        pais = paisService.carregarPais(id);
        assertEquals("@Test - exclusão", pais, auxPais);
    }
}