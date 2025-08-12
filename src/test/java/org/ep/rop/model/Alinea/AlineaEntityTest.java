package org.ep.rop.model.Alinea;

   import org.ep.rop.domain.model.Entities.AlineaEntity;
   import org.ep.rop.domain.model.Entities.ContentEntity;
   import org.ep.rop.domain.model.P;
   import org.junit.jupiter.api.Test;

   import static org.junit.jupiter.api.Assertions.*;

   public class AlineaEntityTest {

       @Test
       void AlineaTest() {
           AlineaEntity alinea = new AlineaEntity();
           alinea.setContent(new ContentEntity("Alinea content test"));
           assertEquals("Alinea content test", alinea.getContent().getP());
       }

       @Test
       void AlineaWithCOntentTest() {

           ContentEntity content = new ContentEntity("Alinea content test");
           AlineaEntity alinea = new AlineaEntity(content);
           assertEquals("Alinea content test", alinea.getContent().getP());
       }
   }