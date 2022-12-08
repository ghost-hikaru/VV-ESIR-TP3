# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer
### Answer of exercice 2
We didn’t discuss one of the PMD rules in the selection but we spoke about the close Ressource rule. It is available since PMD 1.2.2 and it ensures that resources (like Connection, Statement,and ResultSet objects) are always closed after use. 

We use the PMD rules JUnitTestContainsTooManyAsserts in the selection on the projects **commons-collection-master** and we get that result : 
```
/commons-collections-master/src/test/java/org/apache/commons/collections4/iterators/SingletonIteratorTest.java:68:JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
```
To correct this errors, we need to reduce the number of assert in the test.
The initial test :
```
 @Test
    public void testIterator() {
        final Iterator<E> iter = makeObject();
        assertTrue("Iterator has a first item", iter.hasNext());

        final E iterValue = iter.next();
        assertEquals("Iteration value is correct", testValue, iterValue);

        assertFalse("Iterator should now be empty", iter.hasNext());

        try {
            iter.next();
        } catch (final Exception e) {
            assertEquals("NoSuchElementException must be thrown", e.getClass(), new NoSuchElementException().getClass());
        }
    }

```
The correct way to make the test :
```
@Test
    public void testIterator() {
        final Iterator<E> iter = makeObject();
        assertTrue("Iterator has a first item", iter.hasNext());
    }
@Test
    public void testIterator2() {
        final E iterValue = iter.next();
        assertEquals("Iteration value is correct", testValue, iterValue);
    }
@Test
    public void testEmptyIterator() {
        assertFalse("Iterator should now be empty", iter.hasNext());
    }

@Test
    public void testexceptionIterator(){
       try {
            iter.next();
        } catch (final Exception e) {
            assertEquals("NoSuchElementException must be thrown", e.getClass(), new NoSuchElementException().getClass());
        } 
    }
```

