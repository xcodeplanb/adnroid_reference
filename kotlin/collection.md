### Collection

1. Category
- Creation — 컬렉션을 생성하는 함수 (ex : listOf)
- Convert — 다른 유형으로 캐스팅하는 함수 (ex: asMap)
- Change — 내용을 변환하는 함수 (ex: map)
- Choose — 항목 중 하나에 접근하는 함수(ex : get)
- Conclude — 항목에서 무언가를 생성하는 함수(ex: sum)

* Creation
  * emptyL emptyList, emptyMap, emptySetist, emptyMap, emptySet
    >비어있는 읽기 전용 컬렉션
    ```
    val list: List<Int> = emptyList()
    ...
    ```
  * listOf, mapOf, setOf
    >읽기 전용 컬렉션
    ```
    val list = listOf('a', 'b', 'c')
    val map = mapOf(1 to "x", 2 to "y", -1 to "zz")
    ... 
    ```
  * mutableListOf, mutableMapOf, mutableSetOf, arrayListOf
    >변경 가능한 컬렉션
    ```
    val map = mutableMapOf(1 to "x", 2 to "y", -1 to "zz")
    map[1] = "a"
    -> {1=a, 2=y, -1=zz}
    ```
* Conclude
  * reduce
    ```
    listOf(1, 2, 3).reduce {result,item -> result * item}
    -> 6
    ```
  * fold
    ```
    listOf(1, 2, 3).fold(2) {result,item -> result * item}
    -> 12
    ```
* Change
  * map
    > 배열의 각 요소에 지정된 변환 함수를 적용한 결과가 포함 된 목록을 반환
    ```
    val numbers = listOf(1, 2, 3)
    println(numbers.map { it * it })
    -> [1, 4, 9]
    ```