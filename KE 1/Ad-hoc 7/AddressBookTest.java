import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;
import java.util.Date;

public class AddressBookTest {
   public static void main(String[] args) {
      Random rnd = new Random();
      ArrayAddressBook book = new ArrayAddressBook(3);

      for (int i = 0; i < 10; i++) {
         long rndMs = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
         int rndBday = Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date(rndMs)));
         String rndName = UUID.randomUUID().toString().substring(0, 8);
         book.addPerson(new Person(rndName, rndBday));

         if (i % 3 == 0) {
            book.print();
         }
      }
   }
}