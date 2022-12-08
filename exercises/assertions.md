# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer
### Answer of exercice 1
##### Question 1
The assertion fail because 3 * .4 gives us the result: 1.2000000000000002.
If we do (3 * .4) - 1.2 it gives us a result close to 0 but never equal to 0. So the assertion can never return **True**.
If we want to correct the assertion we have to replace :
```
assertTrue(3 * .4 == 1.2)
```
by
```
assertTrue(Math.abs(3*.4 - 1.2)<0.000001);
```
With math.abs we will have an approximation:
1.2000000000000002 will become 1.2.

##### Question 2
**assertSame()**
Checks the object reference using the == operator. 

**assertEquals()**
If primitive values are passed and then the values are compared.
If objects are passed, then the equals() method is invoked.

##### Question 3
Fail could be used if you want to detect if you go through a necessary path.

For example, the following code tries to determine if a is negative or positive, but it doesn’t take the case of 0. 
The code initializes a null string and completes that string in one of the if. If we don’t go through one of the two if, the code will print a null result. So to verify if we go through one of the two necessary paths, it throws an error. 
```
public class test {

	public static void main(String[] args) {
		int a =0;
		String output = null;
		if(a<0) {
			output = "négatif";
		}
		if(a>0) {
			output = "positif";
		}
		else {
			fail();
		}
		System.out.println(output);
	}

}
```

##### Question 4
The advantage of **assertThrows()** is, he allows you to test multiple exceptions within the same test. With support for lambdas in Java 8, this is the canonical way to test for exceptions in JUnit.
