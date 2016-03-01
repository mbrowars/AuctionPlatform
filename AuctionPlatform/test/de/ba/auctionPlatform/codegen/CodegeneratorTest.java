/**
 *  SE-PROJEKT_AuctionPlatform
 * 
 *  team:	Markus Fröhlich, Max Göppert, Matthias Browarski
 *
 */
package de.ba.auctionPlatform.codegen;

import org.junit.Test;

/**
 * 
 * @author Matthias Browarski
 *
 */
public class CodegeneratorTest {

	Codegenerator c = new Codegenerator();

	@Test
	public void testSecurityCode() {
		int test = c.securityCode();
		System.out.println(test);
	}

	@Test
	public void testValidator() {
		int test = c.securityCode();
		c.validate(test, test);
		int test2 = 12345678;
		int test3 = 12345678;
		c.validate(test2, test3);
	}
}
