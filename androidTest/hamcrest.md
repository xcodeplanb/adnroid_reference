### Hamcrest

#### Hamcrest matcher
    allOf - matches if all matchers match (short circuits)
    anyOf - matches if any matchers match (short circuits)
    not - matches if the wrapped matcher doesn’t match and vice
    equalTo - test object equality using the equals method
    is - decorator for equalTo to improve readability
    hasToString - test Object.toString
    instanceOf, isCompatibleType - test type
    notNullValue, nullValue - test for null
    sameInstance - test object identity
    hasEntry, hasKey, hasValue - test a map contains an entry, key or value
    hasItem, hasItems - test a collection contains elements
    hasItemInArray - test an array contains an element
    closeTo - test floating point values are close to a given value
    greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo
    equalToIgnoringCase - test string equality ignoring case
    equalToIgnoringWhiteSpace - test string equality ignoring differences in runs of whitespace
    containsString, endsWith, startsWith - test string matching

[hamcrest doc link](http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matchers.html)