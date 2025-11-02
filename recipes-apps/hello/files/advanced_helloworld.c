/* This is an advanced version extended from
 * helloworld.c in the same directory */
#include <stdio.h>
#include <string.h>

// Definitions
#define MESSAGE "Hello, world!"
#define MAX_LEN 50

void relationship(char *, char *);

int main(void)
{
    char greeting[MAX_LEN] = MESSAGE;
    char reply[MAX_LEN];

    relationship(greeting, reply);
    return 0;
}

void relationship(char *chat1, char *chat2)
{
    printf("Before strcpy: %s\n", chat1);
    strcpy(chat1, "This is not a greeting anymore!");
    printf("After strcpy: %s\n", chat1);
    printf("-------------\n");
    printf("Replying...\n");
    memcpy(chat2, chat1, strlen(chat1) + 1);
    printf("%s\n", chat2);
}
