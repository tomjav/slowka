package pl.mgrzybowski.slowka;

import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SlowkaApplicationTests {

	@Test
	public void contextLoads() {

		CustomInt cos = new CustomInt(10);

		increment(cos);

		System.out.println(cos.getP());
	}

	public CustomInt increment(CustomInt cos){

		cos.setP(cos.getP() + 1);

		return cos;
	}


}
