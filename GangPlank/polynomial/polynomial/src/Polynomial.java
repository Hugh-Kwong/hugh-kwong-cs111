import java.io.*;
import java.util.Scanner;

/**
 * This class implements a polynomial.
 * 
 * @author runb-cs112
 *
 */
public class Polynomial {
	
	/**
	 * Reads a polynomial from an input stream (file or keyboard). The storage format
	 * of the polynomial is:
	 * <pre>
	 *     <coeff> <degree>
	 *     <coeff> <degree>
	 *     ...
	 *     <coeff> <degree>
	 * </pre>
	 * with the guarantee that degrees will be in descending order. For example:
	 * <pre>
	 *      4 5
	 *     -2 3
	 *      2 1
	 *      3 0
	 * </pre>
	 * which represents the polynomial:
	 * <pre>
	 *      4*x^5 - 2*x^3 + 2*x + 3 
	 * </pre>
	 * 
	 * @param sc Scanner from which a polynomial is to be read
	 * @throws IOException If there is any input error in reading the polynomial
	 * @return The polynomial linked list (front node) constructed from coefficients and
	 *         degrees read from scanner
	 */
	public static Node read(Scanner sc) 
	throws IOException {
		Node poly = null;
		while (sc.hasNextLine()) {
			Scanner scLine = new Scanner(sc.nextLine());
			poly = new Node(scLine.nextFloat(), scLine.nextInt(), poly);
			scLine.close();
		}
		return poly;
	}
	
	/**
	 * Returns the sum of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list
	 * @return A new polynomial which is the sum of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node add(Node poly1, Node poly2) {

	    /** COMPLETE THIS METHOD **/
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		Node sum = new Node(0, 0, null);
		Node sumP = sum;
		Node p1 = poly1;
		Node p2 = poly2;
		while(p1.term != null || p2.term != null){
		if(poly1.term.degree < poly2.term.degree){
		Node sumG = new Node(p1.term.coeff, p1.term.degree, sumP.next);
		sum.next = sumG;
		p1 = p1.next;
		sumP = sumP.next;
		}else if(poly1.term.degree > poly2.term.degree){
		Node sumL = new Node(p1.term.coeff, p1.term.degree, sum.next);
		sum.next = sumL;
		p2 = p2.next;
		sumP = sumP.next;
		}
		Node sumF = new Node(p1.term.coeff + p2.term.coeff, p1.term.degree + p1.term.degree, sumP.next);
		p1 = p1.next;
		p2 = p2.next;
		sumP = sumP.next;
		}
		return sum;
	}	
	
	
	/**
	 * Returns the product of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list)
	 * @return A new polynomial which is the product of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node multiply(Node poly1, Node poly2) {

	    /** COMPLETE THIS METHOD **/
	    // FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
	    // CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		Node product = new Node(0, 0, null);
		Node prdptr = product;
		Node p1 = poly1;
		while(p1.term != null){
			Node p2 = poly2;
			Node part2 = new Node(0, 0, null);
			Node part2ptr = part2;
			while(p2.term != null){
				Node mult = new Node(p1.term.coeff*p2.term.coeff, p1.term.degree + p2.term.degree, part2ptr.next);
				part2ptr = part2ptr.next;
				p2 = p2.next;
			}
			product = add(product, part2);
			p1 = p1.next;
		}
		sort(product);
	    return product;	
	}
	
	/**
	 * Evaluates a polynomial at a given value.
	 * 
	 * @param poly Polynomial (front of linked list) to be evaluated
	 * @param x Value at which evaluation is to be done
	 * @return Value of polynomial p at x
	 */
	public static float evaluate(Node poly, float x) {

	    /** COMPLETE THIS METHOD **/
	    // FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
	    // CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		float sol = 0;
		while(poly.next != null){
			sol = (float)Math.pow(poly.term.coeff * x, poly.term.degree);
			poly = poly.next;
		}
	    return sol;
	}
	
	/**
	 * Returns string representation of a polynomial
	 * 
	 * @param poly Polynomial (front of linked list)
	 * @return String representation, in descending order of degrees
	 */
	public static String toString(Node poly) {
		if (poly == null) {
			return "0";
		} 
		
		String retval = poly.term.toString();
		for (Node current = poly.next ; current != null ;
		current = current.next) {
			retval = current.term.toString() + " + " + retval;
		}
		return retval;
	}	
	
	private static Node reverse(Node p) {
		Node ret=null;
		while (p != null) {
			ret = new Node(p.term.coeff, p.term.degree, ret);
			p = p.next;
		}
		return ret;
	}
	public static Node sort(Node fort){
		Node sorted = new Node(0, 0, null);
		Node large = null;
		
		while(fort.next != null){
			if(fort.term.degree > fort.next.term.degree){
			large.term = fort.term;	
			sorted.term = large.term;
			}else if(fort.term.degree < fort.next.term.degree){
			large.term = fort.next.term;
			sorted.term = large.term;
			}else{
			large.term.coeff = fort.term.coeff + fort.next.term.coeff;
			large.term.degree = fort.term.degree + fort.next.term.degree;
			sorted.term = large.term;
			}
			fort = fort.next;
			
		}
		return sorted;
	}
}
