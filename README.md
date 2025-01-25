# Huffman Coding Implementation

A Java implementation of the Huffman coding algorithm for text compression and decompression.

## Core Components

### Classes

- **HuffmanCode.java**: Main implementation with encoding and decoding logic
  - **Inner Node Class**: Represents nodes in the Huffman tree

### Key Features

- Character frequency-based compression
- Binary tree implementation
- Encoding & decoding functionality
- HashMap-based code storage

### Methods

- **HuffmanCode()**: Constructor for tree creation
- **encode()**: Converts text to Huffman codes
- **decode()**: Reconstructs text from Huffman codes
- **printCodeWords()**: Displays generated codes

## Usage
java
- // Create Huffman tree
char[] chars = {'a', 'b', 'c'};
int[] freqs = {5, 2, 3}; 
HuffmanCode huffman = new HuffmanCode(chars, freqs);

- // Print codes
huffman.printCodeWords();

- // Encode text
String encoded = (String) huffman.encode("abc");

- // Decode text 
String decoded = (String) huffman.decode(encoded);

## Implementation Details

Tree Construction: Uses minimum frequency merging
Node Structure: Includes frequency, depth, and character data
HashMap Storage: Maintains character-to-code mapping
Binary Encoding: Left child = 0, Right child = 1

## Performance

Time Complexity: O(n log n) for construction
Space Complexity: O(n) for storage

## Author
Sai Ram Gandla

## License
All rights reserved by Sai Ram Gandla. Reference implementations used with attribution.
