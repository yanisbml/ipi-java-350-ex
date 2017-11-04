import com.ipiecoles.java.java350.Compte;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class CompteTest {
    public final static String LINE_SEPARATOR = System.getProperty("line.separator");
    @Test
    public void testCompte(){
        //Given
        String input = "C"+LINE_SEPARATOR+"123"+LINE_SEPARATOR+"500"+LINE_SEPARATOR;
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        //When
        Compte c = new Compte();

        //Then
        Assertions.assertThat(c.getTypeCompte()).isEqualTo("Courant");
        Assertions.assertThat(c.getNumeroCompte()).isEqualTo("123");
        Assertions.assertThat(c.getValeurCourante()).isEqualTo(500.0);
    }
}
