#include <stdio.h>
#include <string.h>

void swap(char* a, char* b);

void reverse(char* str);

int main(){

	// static string input
	//char mystring[] = "yaw buu sell yaw";
	
	// ask user for String input
	char mystring[1000];
	printf("Enter your string to reverse: ");
	scanf(" %[^\n]s",mystring);	
	
	printf("The original words: %s \n",mystring);
	reverse(mystring);
	printf("Reversed words: %s \n",mystring);
}

void swap(char* a, char* b){
	char temp = *a;
	*a = *b;
	*b = temp;

}


void reverse(char* str){

	// check empty string
	if(!*str){
		return;
	}


	char* start = str;
	char* end = start +strlen(str)-1;


	while(start < end){
		swap(start, end);
		start++;
		end--;
	}
}


// For more information Read here:     nam://gist.github.com/habina/d55da65182a6622e64b5 


