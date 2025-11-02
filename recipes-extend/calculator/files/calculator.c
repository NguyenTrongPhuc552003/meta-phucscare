#include <stdio.h>
#include "libmath.h"   // Our custom library

int main() {
    int a = 10, b = 5;
    printf("Calculator:\n");
    printf("%d + %d = %d\n", a, b, add(a,b));
    printf("%d - %d = %d\n", a, b, sub(a,b));
    return 0;
}

