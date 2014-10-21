package sis.studentinfo;
import java.math.BigDecimal;
import junit.framework.*;

public class AccountTest extends TestCase{
	public void testTanscation(){
		Account account = new Account();
		account.credit(new BigDecimal("0.10"));
		account.credit(new BigDecimal("11.00"));
		assertEquals(new BigDecimal("11.00"), account.getBalance());
	}
}
