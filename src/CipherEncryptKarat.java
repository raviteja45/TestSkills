public String encrypt(String text, String key) {
		StringBuilder sb = new StringBuilder();
		List<Character> list = new ArrayList<>();
		Map<Character,Character> map = new HashMap<>();
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < key.length(); i++) {
			if (Character.isAlphabetic(key.charAt(i)) && !list.contains(Character.toLowerCase(key.charAt(i)))) {
				list.add(Character.toLowerCase(key.charAt(i)));
			}
		}
		for(int i=0;i<26;i++) {
			map.put(alphabets.charAt(i), list.get(i));
		}
		for(int i=0;i<text.length();i++) {
			if(Character.isAlphabetic(text.charAt(i))) {
				char c = map.get(Character.toLowerCase(text.charAt(i)));
				if(Character.isUpperCase(text.charAt(i))) {
					sb.append(Character.toUpperCase(c));
				}else {
					sb.append(c);
				}
			}else {
				sb.append(text.charAt(i));
			}
		}
		return sb.toString();
	}

System.out.println(k.encrypt("Would you kindly?", "The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!"));

/**
You decide to create a substitution cipher. The cipher alphabet is based on a key shared amongst those of your friends who don't mind spoilers.

Suppose the key is:
"The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!".

We use only the unique letters in this key to set the order of the characters in the substitution table.

T H E Q U I C K O N Y X G B L R A S W D J M P V Z F

(spaces added for readability)

We then align it with the regular alphabet:
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
T H E Q U I C K O N Y X G B L R A S W D J M P V Z F

Which gives us the substitution mapping: A becomes T, B becomes H, C becomes E, etc.

Write a function that takes a key and a string and encrypts the string with the key.

Example:
key = "The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!"
encrypt("It was all a dream.", key) -> "Od ptw txx t qsutg."
encrypt("Would you kindly?", key) -> "Pljxq zlj yobqxz?"

Complexity analysis:

m: The length of the message
k: The length of the key
*/
