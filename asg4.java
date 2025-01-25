/**
 * You should not modify this program. You should develop your own 
 * HuffmanTree.java and put it in the same directory
 * 
 * @author Chung-Chih Li, 3/7/2023
 *
 */

public class asg4 {
	// This frequency is based on the example from Corman's book
	static public void CormanFrequency() {
	    	int[] f = {82,15,29,43,127,22,20,61,70,5,8,40,24,67,75,19,4,60,63,91,28,10,23,2,21,1,123};
		char[] a = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '};
		HuffmanCode hc = new HuffmanCode(a, f); // Construct a Huffman Tree based on a and f
		hc.printCodeWords();
		
		System.out.printf("%nCode1: %s", hc.encode("SPRING IS ARROUND THE CORNER"));	
		System.out.printf("%nCode2: %s", hc.encode("HUFFMAN CODES CAN BE USED TO COMPRESS DATA AND PICTURES LIKE ZIP AND JPG"));
		System.out.printf("%nCode3: %s%n%n", hc.encode("ALGORITHM IS VERY IMPORTANT"));
		
		System.out.printf("Text1: %s%n", 
						hc.decode("00111011100110100010011101100101000001101011000110011010100111110011101001011100010000010011101010011010010000110"));	
		System.out.printf("Text2: %s%n",
						hc.decode("0010011111111001111001111101100100101001110101011010000001101001110110010010101111110000010011110011000110100101110101001001110101011111010111001100000011001101011010110011101100010110010011101001010111010000111011100111101100000011010101101000101111000001011111111111000101110010110010011101001011111110101110110110"));
		System.out.printf("Text3: %s%n",
						hc.decode("1100101101101101010011010001110001011111001010000011010101111100001101101110101000111110101110101001101110110010011110"));
		System.out.printf("Text4: %s%n",
				hc.decode("110111101001111010011101100100101011111010101101010001111001101110101110001010000011010101110011010101101100110110011111001011111101101110100111100111000100111011001011000111011100111111001011001011110001100001111111100111100010010111011011101011001001110010110110111001110000011010110010011101001011111101000111001000111110011010001001110110010111010100101101000010111110001011010101011100101101111010011110110010101011110110010100111010101111101011100110000001100111000100111011001010111001101010110110011011001111100011"));	
		System.out.println();	
	}
		
	public static void main(String[] args) {		
		CormanFrequency();
	}

}
