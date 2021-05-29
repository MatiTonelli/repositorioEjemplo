import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AgendaTests {

    private Agenda agendita;

    @Before
    public void inicio() {
    	agendita = new Agenda(5);
    }

    @Test
    public void ingresarContacto() {
        agendita.ingresarNuevoContacto("Matias", "Tonelli");
        Assert.assertEquals("Matias", agendita.getContacto(1).getPrimerNombre());
        Assert.assertEquals("Tonelli", agendita.getContacto(1).getApellido());
    }

    @Test
    public void ingresarContactoConSegundoNombre() {
        agendita.ingresarNuevoContactoConSegundoNombre("Matias", "Sebastian", "Tonelli");
        Assert.assertEquals("Sebastian", agendita.getContacto(1).getSegundoNombre());
    }

    @Test(expected=Error.class)
    public void intentarAgendarMasContactosQueElLimiteDeLaAgenda() {
        agendita.ingresarNuevoContacto("Matias", "Tonelli");
        agendita.ingresarNuevoContacto("Matias", "Tonelli");
        agendita.ingresarNuevoContacto("Matias", "Tonelli");
        agendita.ingresarNuevoContacto("Matias", "Tonelli");
        agendita.ingresarNuevoContacto("Matias", "Tonelli");
        agendita.ingresarNuevoContacto("Matias", "Tonelli");
    }
    
    @Test(expected=Error.class)
    public void intentarAgendarMasContactosQueElLimiteDeLaAgendaConSegundoNombre() {
    	agendita.ingresarNuevoContactoConSegundoNombre("Matias", "Sebastian", "Tonelli");
    	agendita.ingresarNuevoContactoConSegundoNombre("Matias", "Sebastian", "Tonelli");
    	agendita.ingresarNuevoContactoConSegundoNombre("Matias", "Sebastian", "Tonelli");
    	agendita.ingresarNuevoContactoConSegundoNombre("Matias", "Sebastian", "Tonelli");
    	agendita.ingresarNuevoContactoConSegundoNombre("Matias", "Sebastian", "Tonelli");
    	agendita.ingresarNuevoContactoConSegundoNombre("Matias", "Sebastian", "Tonelli");
    }
    
    @Test
    public void borrarUnContacto() {
        agendita.ingresarNuevoContactoConSegundoNombre("Matias", "Sebastian", "Tonelli");
        agendita.borrarUnContactoPorIndice(1);
        Assert.assertTrue(agendita.getContacto(1) == null);
    }
    
    @Test
    public void editarUnContacto() {
        agendita.ingresarNuevoContacto("Matias", "Tonelli");
        agendita.editarContacto(1, "Nicolas", "Vega");
        Assert.assertEquals("Nicolas", agendita.getContacto(1).getPrimerNombre());
        Assert.assertEquals("Vega", agendita.getContacto(1).getApellido());
    }
    
    @Test
    public void editarSegundoNombre() {
        agendita.ingresarNuevoContactoConSegundoNombre("Matias", "Sebastian", "Tonelli");
        agendita.editarSegundoNombre(1, "Marcelo");
        Assert.assertEquals("Marcelo", agendita.getContacto(1).getSegundoNombre());
    }
    
    @Test
    public void agregarSegundoNombre() {
        agendita.ingresarNuevoContacto("Matias", "Tonelli");
        agendita.editarSegundoNombre(1, "Marcelo");
        Assert.assertEquals("Marcelo", agendita.getContacto(1).getSegundoNombre());
    }
    
    @Test(expected = Error.class)
    public void pedirDatosDeUnContactoInexistente() {
    	agendita.mostrarDatosDelContacto(1);
    }
    
    @Test
    public void settearTelefono() {
    	String[] prueba = {"1234", "Celu"};
    	agendita.ingresarNuevoContacto("Matias", "Tonelli");
    	agendita.getContacto(1).setTelefono("1234", "Celu");
    	Assert.assertArrayEquals(prueba, agendita.getContacto(1).getTelefono());
    }
    
    @Test
    public void settearMail() {
    	String[] prueba = {"mati@hola", "Trabajo"};
    	agendita.ingresarNuevoContacto("Matias", "Tonelli");
    	agendita.getContacto(1).setMail("mati@hola", "Trabajo");
    	Assert.assertArrayEquals(prueba, agendita.getContacto(1).getMail());
    }
    
    @Test
    public void settearDomicilio() {
    	String[] prueba = {"Calle falsa", "123", "1", "B", "Villa Bosch", "Tres De Febrero", "Buenos Aires", "Argentina"};
    	agendita.ingresarNuevoContacto("Matias", "Tonelli");
    	agendita.getContacto(1).setDomicilio("Calle falsa", "123", "Villa Bosch", "Buenos Aires", "Argentina");
    	agendita.getContacto(1).setPiso("1");
    	agendita.getContacto(1).setDepto("B");
    	agendita.getContacto(1).setPartido("Tres De Febrero");
    	Assert.assertArrayEquals(prueba, agendita.getContacto(1).getDomicilio());
    }
    
    @Test
    public void settearCumpleanios() {
    	agendita.ingresarNuevoContacto("Matias", "Tonelli");
    	agendita.getContacto(1).setCumpleanios("11/09");
    	Assert.assertEquals("11/09", agendita.getContacto(1).getCumpleanios());
    }
    
    @Test
    public void settearEmpresa() {
    	agendita.ingresarNuevoContacto("Matias", "Tonelli");
    	agendita.getContacto(1).setEmpresa("Coca-Cola");
    	Assert.assertEquals("Coca-Cola", agendita.getContacto(1).getEmpresa());
    }

}