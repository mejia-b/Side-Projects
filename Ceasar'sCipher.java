/*This program is by no means unbreakable!!  
I am sure I can improve it but at the moment this is what I have.
----------------------------------------------------------------
MESSAGE TO WHO EVER RUNS THIS PROGRAM: WHEN INPUTTING YOUR MESSAGE ONLY ENTER THE LETTERS (A-Z)
YOU CAN ENTER SPACES AS SHOWN IN THE OUTPUT EXAMPLE IN THE BOTTOM.*/




import java.util.Scanner;
public class Cipher {

	public static void main(String[] args) {
		//create the scanner object
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		//Declared variables
		char userAnswer = 'y';
		int numberKey,selection;
		String message;
		//This loop will run until user input is no longer set to 'y'
	while(userAnswer == 'y'|| userAnswer == 'Y'){
		System.out.println("Enter 1 to encrypt or 2 to decrypt a message");
		selection = input.nextInt();
		if(selection < 1 || selection > 2){
			while(selection < 1 || selection > 2){
				System.out.println("Error invalid selection");
				System.out.println("Please enter 1 to encrypt or 2 to decrypt");
				selection = input.nextInt();
			}//end of while loop 
		}//end of if statement
		//Clears the buffer
		input.nextLine();
		
		if(selection == 1){
			//Prompt user for a message
			System.out.println("Enter a message to encrypt: ");
			message = input.nextLine();
			message = message.toLowerCase();
			//Prompt user for a key shift
			System.out.println("Enter the number key (1-26)");
			numberKey = input.nextInt();
			//Clears the buffer
			input.nextLine();
			//Error checks and makes sure key number is between 1-26
			if(numberKey < 1 || numberKey > 26){
				while(numberKey < 1 || numberKey > 26){
						System.out.println("Error key value has to be between 1 and 26");
						System.out.println("Enter the number key (1-26)");
						numberKey = input.nextInt();
					}//end of while loop
			}//end of inner if statement
			
			//Store user string into char array without spaces
			char textInput [] = message.replaceAll(" ","").toCharArray();
			
			/*Calls the method and passes three arguments,
			the array containing the message, the key shift
			and the number 1 for encryption.*/
			encrypt_decrypt_text(textInput,numberKey,selection);
		
		}//end of outer if statement
		
		else if(selection == 2){
			//Prompt user for a message
			System.out.println("Enter a message to decrypt:");
			message = input.nextLine();
			message = message.toLowerCase();
			//Prompt user for the key shift
			System.out.println("Enter the number key (1-26)");
			numberKey = input.nextInt();
			//Error checks and makes sure key number is between 1-26
			if(numberKey < 1 || numberKey > 26){
				while(numberKey < 1 || numberKey > 26){
					System.out.println("Error key value has to be between 1 and 26");
					System.out.println("Enter the number key (1-26)");
					numberKey = input.nextInt();
					}//end of while loop
			}//end of inner if statement
			
			//Store user string into char array without spaces
			char textInput [] = message.replaceAll(" ","").toCharArray();
			/*Calls the method and passes three arguments,
			the array containing the message, the key shift
			and the number 2 for decryption.*/
			encrypt_decrypt_text(textInput,numberKey,selection);
		}//end of else if statement
		System.out.println("\n");
		System.out.println("Would you like to encrypt or decrypt another message?");
		System.out.println("Enter y for YES or n for NO");
		userAnswer = input.next().charAt(0);
	}//end of while loop
}//end of main 
	
	public static void encrypt_decrypt_text(char plainText[], int keyShift,int selection){
		//Array that stores the alphabet letters
		char [] alphabet={'a','b','c','d','e','f','g','h','i','j','k','l','m',
						'n','o','p','q','r','s','t','u','v','w','x','y','z'};
		//Array to store the encrypted message
		char [] message = new char[plainText.length];
		
		int num,arrayIndex=0,i;
		/*Iterate through the for loop for the length of the message
		 until each character is checked and switched to the corresponding
		 letter depending on the key shift*/
		for(i =0; i < plainText.length; i++){
			//Iterate until a match is found
			while(plainText[i] != alphabet[arrayIndex]){
						arrayIndex++;
					}//end of while loop
			
				if(selection == 1){
				num = ((arrayIndex + keyShift) % 26);
				message[i] = alphabet[num];
				}
				
				else if(selection == 2){
					num = ((arrayIndex - keyShift)% 26);
					if (num < 0){
						num = num + 26;
					}
					message[i] = alphabet[num];
				}
				//Set the arrayIndex variable back to zero 
				//to avoid an array out of bounds error
				arrayIndex=0;
			
		}//end of for loop
		
		//Prints encrypted message
		if(selection == 1){
			for(i=0; i < message.length; i++){
			System.out.print(Character.toUpperCase(message[i]));
			}//end of for loop
		}
		
		//Prints decrypted message
		else if(selection == 2){
			for(i=0; i < message.length; i++){
				System.out.print(Character.toLowerCase(message[i]));
				}//end of for loop
		}
		
		System.out.print("\n");
	}//end of encryptText
 
}//end of Cipher class



-------------------------- OUTPUT EXAMPLE ----------------------
Enter 1 to encrypt or 2 to decrypt a message
1
Enter a message to encrypt: 
this message will now be encrypted see you on the other side
Enter the number key (1-26)
9
CQRBVNBBJPNFRUUWXFKNNWLAHYCNMBNNHXDXWCQNXCQNABRMN


Would you like to encrypt or decrypt another message?
Enter y for YES or n for NO
y
Enter 1 to encrypt or 2 to decrypt a message
2
Enter a message to decrypt:
CQRBVNBBJPNFRUUWXFKNNWLAHYCNMBNNHXDXWCQNXCQNABRMN
Enter the number key (1-26)
9
thismessagewillnowbeencryptedseeyouontheotherside


Would you like to encrypt or decrypt another message?
Enter y for YES or n for NO
